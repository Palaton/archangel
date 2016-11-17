package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/03.
 */
public interface PlaceHolderEnsurer {
    <TParameter> void appendParaemter(Class<TParameter> type, TParameter parameter);
    <TPlaceHolderObject extends PlaceHolderObject,TPlaceHolder extends PlaceHolder> TPlaceHolderObject ensure(TPlaceHolder placeHolder);
}
