package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/03.
 */
public interface PlaceHolderEnsurer {
    <TPlaceHolderObject extends PlaceHolderObject,TPlaceHolder extends PlaceHolder> TPlaceHolderObject ensure(TPlaceHolder placeHolder);
}
