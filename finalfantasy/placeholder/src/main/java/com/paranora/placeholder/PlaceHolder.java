package com.paranora.placeholder;

/**
 * Created by yangqun on 2016/11/15.
 */
public class PlaceHolder {
    protected String content;
    protected int start;
    protected int end;
    protected int length;

    protected String contentFull;
    protected int contentStart;
    protected int contentEnd;
    protected int contentLength;

    public int getStart() {
        return start;
    }

    public PlaceHolder setStart(int start) {
        this.start = start;
        return this;
    }

    public int getEnd() {
        return end;
    }

    public PlaceHolder setEnd(int end) {
        this.end = end;
        return this;
    }

    public int getLength() {
        return length;
    }

    public PlaceHolder setLength(int length) {
        this.length = length;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PlaceHolder setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContentFull() {
        return contentFull;
    }

    public PlaceHolder setContentFull(String contentFull) {
        this.contentFull = contentFull;
        return this;
    }

    public int getContentStart() {
        return contentStart;
    }

    public PlaceHolder setContentStart(int contentStart) {
        this.contentStart = contentStart;
        return this;
    }

    public int getContentEnd() {
        return contentEnd;
    }

    public PlaceHolder setContentEnd(int contentEnd) {
        this.contentEnd = contentEnd;
        return this;
    }

    public int getContentLength() {
        return contentLength;
    }

    public PlaceHolder setContentLength(int contentLength) {
        this.contentLength = contentLength;
        return this;
    }
}
