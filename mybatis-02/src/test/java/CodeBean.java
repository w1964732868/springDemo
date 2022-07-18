import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeBean {
    private String warehouseKey;
    private String declarationMode;
    private String storeCode;
    private String port;
    private String pushType;

}
