package com.paranora.placeholder.actual;

import com.paranora.placeholder.AbstractPlaceHolderParser;
import com.paranora.placeholder.PlaceHolderAnalyzer;

/**
 * Created by yangqun on 2016/11/03.
 */
public class PazoPlaceHolderParser extends AbstractPlaceHolderParser {

    protected PlaceHolderAnalyzer placeHolderAnalyzer;

    public void setPlaceHolderAnalyzer(PlaceHolderAnalyzer placeHolderAnalyzer) {
        this.placeHolderAnalyzer = placeHolderAnalyzer;
    }

    public PazoPlaceHolderParser() {
        placeHolderAnalyzer=new PazoPlaceHolderAnalyzer(new PazoPlaceHolderValidator(),new PazoPlaceHolderFinder());
    }

    public PazoPlaceHolderParser(PlaceHolderAnalyzer placeHolderAnalyzer) {
        this.placeHolderAnalyzer = placeHolderAnalyzer;
    }

    @Override
    public PlaceHolderAnalyzer getPlaceHolderAnalyzer() {
        return placeHolderAnalyzer;
    }

}
