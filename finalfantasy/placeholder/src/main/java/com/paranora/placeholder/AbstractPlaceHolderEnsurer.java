package com.paranora.placeholder;

import java.util.Map;

/**
 * Created by yangqun on 2016/11/03.
 */
public abstract class AbstractPlaceHolderEnsurer implements PlaceHolderEnsurer {

    protected Map<String,Object> parameters;

    @Override
    public <TParameter> void appendParaemter(Class<TParameter> type, TParameter parameter) {
        if(parameter instanceof Map){
            parameters=(Map<String,Object>)parameter;
        }
    }

    @Override
    public  <TPlaceHolderObject extends PlaceHolderObject,TPlaceHolder extends PlaceHolder> TPlaceHolderObject ensure(TPlaceHolder placeHolder){
        return (TPlaceHolderObject) new PlaceHolderObject().setName(placeHolder.getContent()).setHolder(placeHolder);
    }
}
