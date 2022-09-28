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

        //Lists.partition com.google.common
        List<List<Map<String, Object>>> orderPartList = Lists.partition(orderList, 100);


        for (List<Map<String, Object>> partList : orderPartList) {
            //Pair commons-lang3
            List<Pair<String, Map<String, Double>>> idFeildsPairs = new ArrayList<>();
            for (Map<String, Object> partInfo : partList) {
                String orderId = (String) partInfo.get("orderId");
                Double shippedAmount = (Double) partInfo.get("shippedAmount");
                idFeildsPairs.add(Pair.of(orderId, Collections.singletonMap("shippedAmount", shippedAmount)));
            }

            System.out.println(idFeildsPairs);
        }


    }
}
