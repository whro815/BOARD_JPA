 
참고 ) https://youtube.com/@codingrecipe?si=4YBbnOtNgcFK1DeD

#JPA 게시판 CRUD

##개발환경
1. 인텔리제이
2. Spring boot 3.2.0
3. JDK 21.0.1
4. postgreSQL
5. Spring Data JPA
6. Thymeleaf

##게시판 기능
1. 게시판 (/board)
   1. 등록 (/insert)
   2. 수정 (/update/{id})
   3. 삭제 (/delete/{id})
   4. 목록 (/list)
   5. 조회 (/detail/{id})
      1. 조회수 ++
      2. 댓글 기능(/comment)
   6. 페이징 조회 (/paging)
   7. 파일 첨부 (이미지)
      1. 단일 파일 첨부
         1. Config
         2. BoardFileEntity
      2. 다중 파일 처리

## SWAGGER
localhost:8080/swagger-ui/index.html

