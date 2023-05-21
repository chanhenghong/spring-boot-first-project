package com.chanheng.stock1.api.base;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Getter
public class RestError<T> {
    private String message;
    private Boolean status;
    private Integer code;
    private Timestamp timestamp;
    private T errors;
}
