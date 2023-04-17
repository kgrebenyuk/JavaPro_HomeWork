package com.example.demowithtests.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyGlobalExceptionHandler extends Throwable {
    private String message;
}
