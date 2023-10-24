package com.example.demo.controller;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.DTO.TestRequestBodyDTO;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") // 리소스
public class TestController {
    @GetMapping
    public String testController() {
        return "Hello world";
    }
    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello world test GetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariable(@PathVariable(required = false) int id) {
        // required = false : 이 매개변수가 꼭 필요한 것은 아니라는 뜻
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
         return "Hello World ID " + id;
    }

    //
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO TestRequestBodyDTO) {
        return "Hello World ID " + TestRequestBodyDTO.getId() + " Message : " + TestRequestBodyDTO.getMessage();
    }

    // ResponseDTO를 반환하는 컨트롤러 메소드
    @GetMapping("/testReponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    // ResponsEntity를 반환하는 컨트롤러 메서드
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 400으로 설정
        return ResponseEntity.badRequest().body(response);

        // 포스트맨을 이용해 실습해보면 400 Bad Requset가 반환된 것을 확인
    }
}
