package com.paranora.placeholder.actual;

import com.paranora.placeholder.PlaceHolderScheme;
import com.paranora.placeholder.PlaceHolderValidator;

/**
 * Created by yangqun on 2016/11/03.
 */
public class PazoPlaceHolderValidator implements PlaceHolderValidator {

    @Override
    public <TPlaceHolderScheme extends PlaceHolderScheme> boolean validate(TPlaceHolderScheme placeHolderStructure, String content) {
        return true;
    }
}
