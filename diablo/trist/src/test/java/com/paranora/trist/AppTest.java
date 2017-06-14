package com.paranora.trist;

import com.paranora.trist.files.FileKeyGenerator;
import com.paranora.trist.files.FilePathKeyGenerator;
import com.paranora.trist.files.impl.LocalFileOperator;
import junit.framework.TestCase;
import org.apache.commons.lang3.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class AppTest extends TestCase
{
    @org.junit.Test
    public void test(){

        String relativePath="abc";
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

        System.out.println(buffer.toString());

        String localFilePath=getLocalFilePath(".jpg","abcd","ctm");


        System.out.println("hello.");
    }

    public String getLocalFilePath(String fileType,String fileId,String relativePath) {
        LocalFileOperator localFileOperator = new LocalFileOperator();
        StringBuffer filePath = new StringBuffer(new FilePathKeyGenerator().getFilePath(relativePath));
        File file = new File(localFileOperator.getLocalFilePath(filePath.toString()));
        if(!file.isDirectory()){
            file.mkdirs();
        }
        return filePath.append(fileId).append(fileType).toString();
    }
}
