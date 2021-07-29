package com.example.demo.exception;

public class ReleaseNotFoundException extends Exception {
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}