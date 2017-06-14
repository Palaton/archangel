package com.paranora.trist.files;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by yangqun on 2016/12/08.
 */
public class FilePathKeyGenerator implements FileKeyGenerator {

    @Override
    public String create(String name) {
        return getUUIDPath(name);
    }

    @Override
    public String create(File file, String fileId, String relativePath) {
        return getUUIDPath(file.getName(),fileId,relativePath);
    }

    private String getUUIDPath(String fileName, String fileId,String relativePath) {
        StringBuffer buffer = new StringBuffer();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        buffer.append(cal.get(Calendar.YEAR));
        buffer.append("/").append(cal.get(Calendar.MONTH) + 1);
//        buffer.append("/").append(cal.get(Calendar.DAY_OF_MONTH));
        if(StringUtils.isNotEmpty(relativePath)){
            buffer.append(relativePath);
        }
        buffer.append("/").append(fileId);
        buffer.append(fileName.substring(fileName.lastIndexOf('.')));
        return buffer.toString();
    }
    private String getUUIDPath(String fileName) {
        String uuid = UUID.randomUUID().toString();
        return getUUIDPath(fileName,uuid,"");
    }

    @Override
    public String getFilePath(String relativePath) {
        StringBuffer buffer = new StringBuffer();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        buffer.append(cal.get(Calendar.YEAR));
        buffer.append("/").append(cal.get(Calendar.MONTH) + 1);
        buffer.append("/").append(cal.get(Calendar.DAY_OF_MONTH));
        if(StringUtils.isNotEmpty(relativePath)){
            buffer.append("/").append(relativePath);
        }
        buffer.append("/");
        return buffer.toString();
    }
}