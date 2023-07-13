package com.example.peterpet.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status","message","result"})
public class BaseResponse<T>{

    private HttpStatus status;
    private String message;
    private T result;

    public static <T> BaseResponse<T> ok (HttpStatus status, String message){
        return new BaseResponse<>(status, message,null);
    }

    public static <T> BaseResponse<T> ok (HttpStatus status, String message, T result){
        return new BaseResponse<>(status, message,result);
    }
}
