package com.github.abaranov1.transliteration.exception;

public class TransliteratorClassNotFoundException extends RuntimeException {
    public TransliteratorClassNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
