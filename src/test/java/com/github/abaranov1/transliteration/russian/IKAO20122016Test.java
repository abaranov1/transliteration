package com.github.abaranov1.transliteration.russian;

import com.github.abaranov1.transliteration.TransliterationType;
import com.github.abaranov1.transliteration.Transliterator;
import com.github.abaranov1.transliteration.TransliteratorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IKAO20122016Test {
    @Test
    void simpleTest(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String expected = "Privet!";
        String actual = transliterator.start("Привет!");
        assertEquals(expected, actual);
    }

    @Test
    void allAlphabetTests(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String alphabet = "абвгдеёжзиклмнопрестуфхцчшщьыъэюя";
        assertDoesNotThrow(()->transliterator.start(alphabet));
    }

    @Test
    void notCharactersWereNotTransliterated(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String expected = "$5 - $^&*";
        String actual = transliterator.start(expected);
        assertEquals(expected, actual);
    }

    @Test
    void unexpectedCharactersError(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        assertThrows(RuntimeException.class, () -> transliterator.start("Apple"));
    }
}