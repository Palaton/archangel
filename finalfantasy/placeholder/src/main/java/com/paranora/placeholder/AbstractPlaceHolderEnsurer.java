package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/03.
 */
public abstract class AbstractPlaceHolderEnsurer implements PlaceHolderEnsurer {

    @Override
    public  <TPlaceHolderObject extends PlaceHolderObject,TPlaceHolder extends PlaceHolder> TPlaceHolderObject ensure(TPlaceHolder placeHolder){
        return (TPlaceHolderObject) new PlaceHolderObject().setName(placeHolder.getContent()).setHolder(placeHolder);
    }
}
