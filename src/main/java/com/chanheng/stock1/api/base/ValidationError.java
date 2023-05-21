package com.chanheng.stock1.api.base;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationError{
    private String field;
    private String detail;
}
