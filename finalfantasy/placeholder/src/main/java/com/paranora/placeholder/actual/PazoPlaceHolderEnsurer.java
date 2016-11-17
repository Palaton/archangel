package com.paranora.placeholder.actual;


import com.paranora.placeholder.AbstractPlaceHolderEnsurer;
import com.paranora.placeholder.PlaceHolder;
import com.paranora.placeholder.PlaceHolderObject;

/**
 * Created by yangqun on 2016/11/03.
 */
public class PazoPlaceHolderEnsurer extends AbstractPlaceHolderEnsurer {

    public PazoPlaceHolderEnsurer(){

    }

    @Override
    public <TPlaceHolderObject extends PlaceHolderObject,TPlaceHolder extends PlaceHolder> TPlaceHolderObject ensure(TPlaceHolder placeHolder) {
        TPlaceHolderObject placeHolderObject =super.ensure(placeHolder);
        if(null!=parameters&&parameters.size()>0) {
            for (String key : parameters.keySet()) {
                if (placeHolderObject.getName().equalsIgnoreCase(key)) {
                    placeHolderObject.setName(parameters.get(key).toString());
                    break;
                }
            }
        }

        return placeHolderObject;
    }
}
