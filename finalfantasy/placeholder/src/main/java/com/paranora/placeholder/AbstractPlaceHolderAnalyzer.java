package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/15.
 */
public abstract class  AbstractPlaceHolderAnalyzer implements PlaceHolderAnalyzer {

    protected PlaceHolderValidator placeHolderValidator;
    protected PlaceHolderFinder placeHolderFinder;

    public AbstractPlaceHolderAnalyzer(){

    }

    public AbstractPlaceHolderAnalyzer(PlaceHolderValidator placeHolderValidator,PlaceHolderFinder placeHolderFinder){
        this.placeHolderFinder=placeHolderFinder;
        this.placeHolderValidator=placeHolderValidator;
    }


    @Override
    public <TPlaceHolderScheme extends PlaceHolderScheme> String analyse(String source, TPlaceHolderScheme placeHolderScheme,PlaceHolderEnsurer placeHolderEnsurer) {
        return source;
    }

    public PlaceHolderValidator getPlaceHolderValidator() {
        return placeHolderValidator;
    }

    public PlaceHolderAnalyzer setPlaceHolderValidator(PlaceHolderValidator placeHolderValidator) {
        this.placeHolderValidator = placeHolderValidator;
        return this;
    }

    public PlaceHolderFinder getPlaceHolderFinder() {
        return placeHolderFinder;
    }

    public PlaceHolderAnalyzer setPlaceHolderFinder(PlaceHolderFinder placeHolderFinder) {
        this.placeHolderFinder = placeHolderFinder;
        return this;
    }
}
