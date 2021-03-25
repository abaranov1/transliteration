package com.github.abaranov1.transliteration.exception;

public class IllegalLetterException extends RuntimeException {
    public IllegalLetterException(String errorMessage){
        super(errorMessage);
    }
}
