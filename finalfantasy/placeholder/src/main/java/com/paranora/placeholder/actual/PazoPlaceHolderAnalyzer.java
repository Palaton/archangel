package com.paranora.placeholder.actual;


import com.paranora.placeholder.*;

/**
 * Created by yangqun on 2016/11/15.
 */
public class PazoPlaceHolderAnalyzer extends AbstractPlaceHolderAnalyzer {

    public PazoPlaceHolderAnalyzer(PlaceHolderValidator placeHolderValidator, PlaceHolderFinder placeHolderFinder){
        super(placeHolderValidator,placeHolderFinder);
    }

    @Override
    public <TPlaceHolderScheme extends PlaceHolderScheme> String analyse(String source, TPlaceHolderScheme placeHolderScheme, PlaceHolderEnsurer placeHolderEnsurer) {
        StringBuilder builder = new StringBuilder();
        PlaceHolder placeHolder = null;
        PlaceHolderFinderContext placeHolderFinderContext=new PlaceHolderFinderContext().setSource(source).setPlaceHolderScheme(placeHolderScheme);
        placeHolderFinder.preare(placeHolderFinderContext);
        int index=0;
        while ((placeHolder = placeHolderFinder.next()) != null) {
            builder.append(placeHolderFinderContext.getSourceChars(),index,placeHolder.getStart()-index);
            PlaceHolderObject placeHolderObject = placeHolderEnsurer.ensure(placeHolder);
            builder.append(placeHolderObject.getName());
            index=placeHolder.getEnd()+1;
        }
        builder.append(placeHolderFinderContext.getSourceChars(),index,placeHolderFinderContext.getSourceChars().length-index);
        return builder.toString();
    }
}
