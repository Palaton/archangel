package com.paranora;

import com.paranora.placeholder.PlaceHolderEnsurer;
import com.paranora.placeholder.PlaceHolderParser;
import com.paranora.placeholder.PlaceHolderScheme;
import com.paranora.placeholder.actual.PazoPlaceHolderEnsurer;
import com.paranora.placeholder.actual.PazoPlaceHolderParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-context-test.xml")
public class AppTest {

    @Test
    public void test(){
        String str = "{\n" +
                "                  \"query\": {\n" +
                "                    \"filtered\": {\n" +
                "                      \"filter\": [\n" +
                "                        {\n" +
                "                          \"bool\": {\n" +
                "                            \"must\": [\n" +
                "                              {\"term\": {\"Status\": 1}}\n" +
                "                                    {\"term\": {\"ParentID\":#{parentID}}}\n" +
                "                                    {\"range\": {\"Levels\": {\"gt\":#{levels}}}}\n" +
                "                            ,\n" +
                "                              {\n" +
                "                                \"filterjoin\": {\n" +
                "                                  \"DeptID\": {\n" +
                "                                    \"filter\": {\n" +
                "                                      \"bool\": {\n" +
                "                                        \"must\": [\n" +
                "                                          {\n" +
                "                                            \"term\": {\"DeptName\": \"#{deptName}\"}\n" +
                "                                          }\n" +
                "                                        ]\n" +
                "                                      }\n" +
                "                                    },\n" +
                "                                    \"indices\": [\"wechatdepartment\"],\n" +
                "                                    \"path\": \"K3ID\",\n" +
                "                                    \"types\": [\"department\"]\n" +
                "                                  }\n" +
                "                                }\n" +
                "                              }\n" +
                "                            ]\n" +
                "                          }\n" +
                "                        }\n" +
                "                      ]\n" +
                "                    }\n" +
                "                  }\n" +
                "                }";
        str+=str;
        str+=str;

        int count=500;

        PlaceHolderParser placeHolderParser=new PazoPlaceHolderParser();
        PlaceHolderScheme placeHolderScheme=new PlaceHolderScheme().setPrefix("#{").setSuffix("}");
        PlaceHolderEnsurer placeHolderEnsurer=new PazoPlaceHolderEnsurer();

        Date startTime = new Date();
        String resultStr="";
        for(int i=0;i<count;i++) {
            resultStr = placeHolderParser.parse(str,placeHolderScheme,placeHolderEnsurer);
        }
        Date endTime = new Date();
        long between = (endTime.getTime() - startTime.getTime());
        System.out.println(String.format("cost time : %d , count : %d", between,count));

        System.out.println("end.");
    }
}
