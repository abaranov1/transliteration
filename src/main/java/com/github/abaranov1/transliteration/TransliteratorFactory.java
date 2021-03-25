package com.github.abaranov1.transliteration;

import com.github.abaranov1.transliteration.russian.IKAO20122016;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorFactory {

    static Map<TransliterationType, Transliterator> transliteratorMapping = new HashMap<>();

    static {
        transliteratorMapping.put(TransliterationType.RUSSIAN_IKAO_2012_2016, new IKAO20122016());
    }

    public static Transliterator createTransliteratorByType(TransliterationType type){
        Transliterator transliterator = transliteratorMapping.get(type);
        return transliterator;
    }

    private TransliteratorFactory(){

    }
}
