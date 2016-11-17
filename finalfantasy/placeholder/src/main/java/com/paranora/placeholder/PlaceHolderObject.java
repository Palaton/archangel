package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/01.
 */
public class PlaceHolderObject {
    protected String name;
    protected PlaceHolder holder;
    protected int start;
    protected int end;
    protected int length;

    public String getName() {
        return name;
    }

    public PlaceHolderObject setName(String name) {
        this.name = name;
        return this;
    }

    public PlaceHolder getHolder() {
        return holder;
    }

    public PlaceHolderObject setHolder(PlaceHolder holder) {
        this.holder = holder;
        return this;
    }


}
