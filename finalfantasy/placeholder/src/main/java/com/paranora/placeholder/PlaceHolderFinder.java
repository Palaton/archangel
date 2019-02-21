package com.paranora.placeholder;

import java.util.Iterator;

/**
 * Created by yangqun on 2016/11/15.
 */
public interface PlaceHolderFinder extends Iterator<PlaceHolder> {
    void preare(PlaceHolderFinderContext context);
}
