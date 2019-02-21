package com.paranora.placeholder;


import java.util.Iterator;

/**
 * Created by yangqun on 2016/11/03.
 */
public interface PlaceHolderAnalyzer {
    <TPlaceHolderScheme extends PlaceHolderScheme> String analyse(String source, TPlaceHolderScheme placeHolderScheme, PlaceHolderEnsurer placeHolderEnsurer);
}
