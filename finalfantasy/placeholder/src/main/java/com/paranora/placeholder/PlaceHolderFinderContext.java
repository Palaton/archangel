package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/15.
 */
public class PlaceHolderFinderContext {
    protected String source;
    protected char[] sourceChars;
    protected PlaceHolderScheme placeHolderScheme;

    public String getSource() {
        return source;
    }

    public PlaceHolderFinderContext setSource(String source) {
        this.source = source;
        this.sourceChars=this.source.toCharArray();
        return this;
    }

    public char[] getSourceChars() {
        return sourceChars;
    }

    public PlaceHolderScheme getPlaceHolderScheme() {
        return placeHolderScheme;
    }

    public PlaceHolderFinderContext setPlaceHolderScheme(PlaceHolderScheme placeHolderScheme) {
        this.placeHolderScheme = placeHolderScheme;
        return this;
    }
}
