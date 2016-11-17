package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/03.
 */
public class PlaceHolderScheme {
    protected String prefix;
    protected String suffix;
    protected String escape;
    protected String regex;

    public PlaceHolderScheme(){

    }

    public String getPrefix() {

        return prefix;
    }

    public PlaceHolderScheme setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public PlaceHolderScheme setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public String getEscape() {
        return escape;
    }

    public PlaceHolderScheme setEscape(String escape) {
        this.escape = escape;
        return this;
    }

    public String getRegex() {
        return regex;
    }

    public PlaceHolderScheme setRegex(String regex) {
        this.regex = regex;
        return this;
    }
}
