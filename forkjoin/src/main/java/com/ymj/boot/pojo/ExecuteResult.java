package com.ymj.boot.pojo;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.boot.pojo
 * @date 2020/11/10 9:36
 * @description
 */
@Data
public class ExecuteResult {

    /** 成功的id集合 */
    private List<String> successIdList = new ArrayList<>();

    /** 最终结果, 只要有一个失败, 即失败 */
    private Boolean result = true;

    /** 异常信息集合 */
    private List<String> errorInfoList = new ArrayList<>();

    public ExecuteResult addResult(ExecuteResult executeResult) {
        if (!executeResult.getResult()) {
            result = false;
        }
        successIdList.addAll(executeResult.getSuccessIdList());
        errorInfoList.addAll(executeResult.getErrorInfoList());
        return this;
    }

}