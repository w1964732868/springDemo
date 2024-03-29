import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/9/28
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class readFileToStringTest {
    public static void main(String[] args) throws IOException {

        //FileUtils commons-io
        String fileToString = FileUtils.readFileToString(new File("D:/file/fileTest.txt"), StandardCharsets.UTF_8);
        System.out.println("读出文件内容: " + fileToString);//读出文件内容: test

        //ObjectMapper jackson-databind
        List<Map<String, Object>> orderList = new ObjectMapper().readValue(fileToString,
                new ObjectMapper().getTypeFactory().constructParametricType(List.class, new Class[]{Map.class}));


        long count = orderList.size();//总数 65
        long sum = 0, lastSum = 0;


        //Lists.partition com.google.common  65 10个一组 7组 （10 10 10 10 10 10 5）
        List<List<Map<String, Object>>> orderPartList = Lists.partition(orderList, 10);


        for (List<Map<String, Object>> partList : orderPartList) {
            //Pair commons-lang3
            List<Pair<String, Map<String, Double>>> idFeildsPairs = new ArrayList<>();
            for (Map<String, Object> partInfo : partList) {
                String orderId = (String) partInfo.get("orderId");
                Double shippedAmount = (Double) partInfo.get("shippedAmount");
                idFeildsPairs.add(Pair.of(orderId, Collections.singletonMap("shippedAmount", shippedAmount)));
            }


            lastSum += partList.size();//（10 10 10 10 10 10 5）
            System.out.println("总共{" + count + "}条数据,开始处理{" + sum + "}~{" + lastSum + "}条！");

            System.out.println(idFeildsPairs);
            sum = lastSum;
            //0~10
            //10~20
            //20~30
            //30~40
            //40~50
            //50~60
            //60~65
        }


    }
}
