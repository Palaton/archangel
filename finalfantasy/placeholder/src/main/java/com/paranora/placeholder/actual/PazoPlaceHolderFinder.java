package com.paranora.placeholder.actual;

import com.paranora.placeholder.AbstractPlaceHolderFinder;
import com.paranora.placeholder.PlaceHolder;
import com.paranora.placeholder.PlaceHolderFinderContext;

/**
 * Created by yangqun on 2016/11/15.
 */
public class PazoPlaceHolderFinder extends AbstractPlaceHolderFinder {

    protected int prefixIndex;
    protected int suffixIndex;
    protected PlaceHolderFinderContext context;

    @Override
    public void preare(PlaceHolderFinderContext context) {
        this.context = context;
        prefixIndex=0;
        suffixIndex=0;
    }


    @Override
    public boolean hasNext() {
        return ((prefixIndex = context.getSource().indexOf(context.getPlaceHolderScheme().getPrefix(), suffixIndex)) > -1);
    }

    @Override
    public PlaceHolder next() {
        if (!hasNext()) {
            return null;
        }
        suffixIndex = context.getSource().indexOf(context.getPlaceHolderScheme().getSuffix(), prefixIndex);
        if (suffixIndex < 0) {
            return null;
        }
        PlaceHolder placeHolder = new PlaceHolder().setStart(prefixIndex)
                .setEnd(suffixIndex)
                .setLength(suffixIndex - prefixIndex)
                .setContentStart(prefixIndex + context.getPlaceHolderScheme().getPrefix().length())
                .setContentEnd(suffixIndex - context.getPlaceHolderScheme().getSuffix().length() + 1);
        placeHolder.setContentLength(placeHolder.getContentEnd() - placeHolder.getContentStart());

        return new PlaceHolder().setStart(prefixIndex).setEnd(suffixIndex).setLength(suffixIndex - prefixIndex).setContent(new String(context.getSourceChars(), placeHolder.getContentStart(), placeHolder.getContentLength()));
    }
}
