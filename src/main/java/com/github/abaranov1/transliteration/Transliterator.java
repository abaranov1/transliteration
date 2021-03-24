package com.github.abaranov1.transliteration;


public interface Transliterator {
    String start(String text);
    void initCache();
}
