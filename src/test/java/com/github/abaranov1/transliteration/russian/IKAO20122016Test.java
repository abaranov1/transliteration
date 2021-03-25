package com.github.abaranov1.transliteration.russian;

import com.github.abaranov1.transliteration.TransliterationType;
import com.github.abaranov1.transliteration.Transliterator;
import com.github.abaranov1.transliteration.TransliteratorFactory;
import com.github.abaranov1.transliteration.exception.IllegalLetterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IKAO20122016Test {

    static Transliterator transliterator;

    @BeforeAll
    static void createTransliterator(){
        transliterator = TransliteratorFactory.createTransliteratorByType(TransliterationType.RUSSIAN_IKAO_2012_2016);
    }

    @Test
    void simpleTest(){
        String actual = transliterator.transliterate("Привет!");
        assertEquals("Privet!", actual);
    }

    @Test
    void Julia(){
        String actual = transliterator.transliterate("Юлия");
        assertEquals("Iuliya", actual);
    }

    @Test
    void allAlphabet(){
        String alphabet = "абвгдеёжзиклмнопрестуфхцчшщьыъэюя";
        assertDoesNotThrow(()->transliterator.transliterate(alphabet));
    }

    @Test
    void notCharactersWereNotTransliterated(){
        String expected = "$5 - $^&*";
        String actual = transliterator.transliterate(expected);
        assertEquals(expected, actual);
    }

    @Test
    void unexpectedCharactersError(){
        assertThrows(IllegalLetterException.class, () -> transliterator.transliterate("Apple"));
    }

    @Test
    void multiCharCharactersCapitalization(){
        String actual = transliterator.transliterate("Щука");
        assertEquals("Shchuka", actual);
    }
}