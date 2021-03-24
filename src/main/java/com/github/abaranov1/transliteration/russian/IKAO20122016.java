package com.github.abaranov1.transliteration.russian;

import com.github.abaranov1.transliteration.AbstactTransliterator;
import com.github.abaranov1.transliteration.Transliterator;

import java.util.HashMap;
import java.util.Map;


public class IKAO20122016 extends AbstactTransliterator implements Transliterator {

    private static Map<String, String> cache = new HashMap<>();

    {
        cache.put("а","a");
        cache.put("б", "b");
        cache.put("в", "v");
        cache.put("г", "g");
        cache.put("д", "d");
        cache.put("е", "e");
        cache.put("ё","e");
        cache.put("ж", "zh");
        cache.put("з", "z");
        cache.put("и", "i");
        cache.put("й", "i");
        cache.put("к", "k");
        cache.put("л", "l");
        cache.put("м", "m");
        cache.put("н", "n");
        cache.put("о", "o");
        cache.put("п", "p");
        cache.put("р", "r");
        cache.put("с", "s");
        cache.put("т", "t");
        cache.put("у", "u");
        cache.put("ф", "f");
        cache.put("х", "kh");
        cache.put("ц", "ts");
        cache.put("ч", "ch");
        cache.put("ш", "sh");
        cache.put("щ", "shch");
        cache.put("ъ", "ie");
        cache.put("ы", "y");
        cache.put("ь", "-");
        cache.put("э", "e");
        cache.put("ю", "iu");
        cache.put("я", "ya");
    }

    @Override
    public void initCache() {
        setCache(cache);
    }
}
