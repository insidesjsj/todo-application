package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
    // 다른 모델의 DTO도 ResponseDTO를 이용해 리턴할 수 있도록 자바 Generic을 이용
    private String error;
    private List<T> data;   // Todo를 하나만 반환하는 경우보다 리스트를 반환하는 경우가 많음
}
