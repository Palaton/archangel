package com.paranora.placeholder;

/**
 * Created by Paranora on 2016/11/02.
 */
public interface PlaceHolderValidator {
    <TPlaceHolderScheme extends PlaceHolderScheme> boolean validate(TPlaceHolderScheme placeHolderStructure, String content);
}
