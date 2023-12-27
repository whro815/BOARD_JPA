package com.jgh.board_jpa.dto.board;

import com.jgh.board_jpa.domain.entity.Board;
import com.jgh.board_jpa.domain.entity.BoardFile;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor      // 기본 생성자
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
public class BoardDto {

    private Long id;
    private String boardWriter;     //작성자
    private String boardTitle;      //게시판 제목
    private String boardContents;   //게시판 내용
    private String boardPass;       //비밀번호
    private int boardHits;          //게시판 조회

    private LocalDateTime boardCreatedTime;  // 게시판 생성 시간
    private LocalDateTime boardUpdatedTime;  // 게시판 수정 시간

    // 다중 private List<MultipartFile> boardFile;
    private MultipartFile boardFile;    //  insert.html -> Controller 파일 담는 용도
    private String orgFileName;         //  원본 파일 이름
    private String storedFileName;      //  서버 저장 파일 이름
    private int fileAttached;           //  파일 첨부 여부(첨부 1, 미첨부 0)

    public BoardDto(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public Board ToEntity(){        // 엔티티에게
        return Board.builder()
                .boardWriter(this.boardWriter)
                .boardTitle(this.boardTitle)
                .boardContents(this.boardContents)
                .boardPass(this.boardPass)
                .boardHits(0)
                .fileAttached(this.fileAttached)
                .build();
    }

    public Board ToUpdateEntity(BoardDto boardDto){        // 엔티티에게
        return Board.builder()
                .id(boardDto.getId())
                .boardWriter(boardDto.getBoardWriter())
                .boardTitle(boardDto.getBoardTitle())
                .boardContents(boardDto.getBoardContents())
                .boardPass(boardDto.getBoardPass())
                .boardHits(boardDto.getBoardHits())
                .build();
    }


    /*
    *  page 메서드 기능 확인
    * */
    public static void pageDataWrite(Page<Board> boardEntities){
        System.out.println("요청 페이지에 해당하는 글 = " + boardEntities.getContent());
        System.out.println("전체 글갯수 = " + boardEntities.getTotalElements());
        System.out.println("DB로 요청한 페이지 번호 = " + boardEntities.getNumber());
        System.out.println("전체 페이지 갯수 = " + boardEntities.getTotalPages());
        System.out.println("한 페이지에 보여지는 글 갯수 = " + boardEntities.getSize());
        System.out.println("이전 페이지 존재 여부 = " + boardEntities.hasPrevious());
        System.out.println("첫 페이지 여부 = " + boardEntities.isFirst());
        System.out.println("마지막 페이지 여부 = " + boardEntities.isLast());
    }

}
