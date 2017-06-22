package com.daydic.domain;

/**
 * Created by kusob on 2017. 5. 9..
 */

import lombok.*;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class ResponseDto {
    private Status status;
    private String message;

    enum Status {
        SUCCESS,
        FAIL
    }

    public static ResponseDto ofSuccess(String message) {
        return ResponseDto.builder()
                .status(Status.SUCCESS)
                .message(message).build();
    }

    public static ResponseDto ofFail(String message) {
        return ResponseDto.builder()
                .status(Status.FAIL)
                .message(message).build();
    }

    public static ResponseDto ofEmpty() {
        return ResponseDto.builder()
                .status(Status.FAIL)
                .message(null)
                .build();
    }
}
