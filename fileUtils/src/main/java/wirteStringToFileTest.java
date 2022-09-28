import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/9/28
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class wirteStringToFileTest {
    public static void main(String[] str) {
        try {
            //commons-io
            String data = "test";
            FileUtils.writeStringToFile(new File("D:/file/fileTest.txt"), data, StandardCharsets.UTF_8);
            System.out.println("写入内容:" + data + ", 成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
