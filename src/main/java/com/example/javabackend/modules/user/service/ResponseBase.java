package com.example.javabackend.modules.user.service;

import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseBase {
    public ResponseBase(ResponseStatus status, String message, Object data) {
    }
}
