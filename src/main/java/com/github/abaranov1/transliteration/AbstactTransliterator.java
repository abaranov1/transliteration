package com.github.abaranov1.transliteration;

import java.util.Map;

public abstract class AbstactTransliterator {

    private Map<String, String> cache;

    public void setCache(Map<String, String> cache) {
        this.cache = cache;
    }

    public String start(String text){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i <= text.length() - 1; i++){
            char character = text.charAt(i);
            if(Character.isLetter(character)){
                String opposite = cache.get(String.valueOf(character).toLowerCase());
                if(opposite == null) {
                    throw new RuntimeException(String.format("Could not find letter for: %s", Character.toLowerCase(character)));
                }
                if(!opposite.equals("-")){
                    boolean isLowerCase = Character.isLowerCase(character);
                    builder.append(isLowerCase ? opposite: opposite.toUpperCase());
                }
            }else{
                builder.append(character);
            }
        }
        return builder.toString();
    }
}
