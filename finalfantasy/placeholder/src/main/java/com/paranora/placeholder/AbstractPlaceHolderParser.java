package com.paranora.placeholder;

import java.util.Map;

/**
 * Created by yangqun on 2016/11/04.
 */
public abstract   class AbstractPlaceHolderParser implements PlaceHolderParser {
    public abstract PlaceHolderAnalyzer getPlaceHolderAnalyzer();

    @Override
    public <TPlaceHolderScheme extends PlaceHolderScheme> String parse(String content, TPlaceHolderScheme placeHolderScheme,PlaceHolderEnsurer placeHolderEnsurer) {
        return getPlaceHolderAnalyzer().analyse(content,placeHolderScheme,placeHolderEnsurer);
    }

    @Override
    public <TPlaceHolderScheme extends PlaceHolderScheme> String parse(String content, TPlaceHolderScheme placeHolderScheme, Map<String, Object> parameters) {
        return null;
    }

}
