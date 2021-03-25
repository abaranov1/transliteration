package com.github.abaranov1.transliteration.russian;

import com.github.abaranov1.transliteration.TransliterationType;
import com.github.abaranov1.transliteration.Transliterator;
import com.github.abaranov1.transliteration.TransliteratorFactory;
import com.github.abaranov1.transliteration.exception.IllegalLetterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IKAO20122016Test {
    @Test
    void simpleTest(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String expected = "Privet!";
        String actual = transliterator.transliterate("Привет!");
        assertEquals(expected, actual);
    }

    @Test
    void allAlphabetTests(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String alphabet = "абвгдеёжзиклмнопрестуфхцчшщьыъэюя";
        assertDoesNotThrow(()->transliterator.transliterate(alphabet));
    }

    @Test
    void notCharactersWereNotTransliterated(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String expected = "$5 - $^&*";
        String actual = transliterator.transliterate(expected);
        assertEquals(expected, actual);
    }

    @Test
    void unexpectedCharactersError(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        assertThrows(IllegalLetterException.class, () -> transliterator.transliterate("Apple"));
    }

    @Test
    void multiCharCharactersCapitalization(){
        Transliterator transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
        String expected = "Shchuka";
        String actual = transliterator.transliterate("Щука");
        assertEquals(expected, actual);
    }
}