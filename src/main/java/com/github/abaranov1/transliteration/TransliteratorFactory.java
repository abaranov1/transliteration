package com.github.abaranov1.transliteration;

import com.github.abaranov1.transliteration.exception.TransliteratorClassNotFoundException;
import com.github.abaranov1.transliteration.exception.TransliteratorInstantiationException;
import com.github.abaranov1.transliteration.russian.IKAO20122016;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

public class TransliteratorFactory {

    static Map<TransliterationType, Class<? extends AbstactTransliterator>> transliteratorMapping = new EnumMap<>(TransliterationType.class);

    static {
        transliteratorMapping.put(TransliterationType.RUSSIAN_IKAO_2012_2016, IKAO20122016.class);
    }

    public static Transliterator createTransliteratorByType(TransliterationType type){
        Class<? extends AbstactTransliterator> transliteratorClass = transliteratorMapping.get(type);
        if(transliteratorClass == null){
            throw new TransliteratorClassNotFoundException(String.format("Could not find class for type %s", type));
        }

        Transliterator transliterator;
        try {
            transliterator =  (Transliterator) Class.forName(transliteratorClass.getName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            throw new TransliteratorInstantiationException(String.format("Could not instantiate transliterator by class %s", transliteratorClass.getName()));
        }
        return transliterator;
    }

    private TransliteratorFactory(){

    }
}
