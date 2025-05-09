package com.gachonproject.buildingservice.global.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {
    private final int code;
    private final String message;
    private final T data;

    private ApiResponse(int code, String message, T data) {
        this.code    = code;
        this.message = message;
        this.data    = data;
    }

    public static <T> ApiResponse<T> response(HttpStatus status, String message, T data) {
        return new ApiResponse<>(status.value(), message, data);
    }

    public static <T> ApiResponse<T> response(HttpStatus status, String message) {
        return new ApiResponse<>(status.value(), message, null);
    }
}