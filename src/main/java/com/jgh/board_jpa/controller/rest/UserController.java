package com.jgh.board_jpa.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

        @Operation(summary = "first api",description = "(설명)첫번째 테스트중")
        @ApiResponses(value = {
                    @ApiResponse(responseCode = "success", description = "성공"),
                    @ApiResponse(responseCode = "fail", description = "실패")
                })
        @GetMapping("/first")
        public String firstController() {
            return "hello first";
        }
}
