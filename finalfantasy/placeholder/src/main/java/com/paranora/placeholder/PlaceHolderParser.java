package com.paranora.placeholder;

import java.util.Map;

/**
 * Created by yangqun on 2016/11/01.
 */
public interface PlaceHolderParser {
    <TPlaceHolderScheme extends PlaceHolderScheme> String parse(String content, TPlaceHolderScheme placeHolderScheme, PlaceHolderEnsurer placeHolderEnsurer);
    <TPlaceHolderScheme extends PlaceHolderScheme> String parse(String content, TPlaceHolderScheme placeHolderScheme, Map<String,Object> parameters);
}
