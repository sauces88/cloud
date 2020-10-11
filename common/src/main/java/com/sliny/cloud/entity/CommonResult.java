package com.sliny.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date 2020/10/11 18:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Boolean status;
    private T data;
    /**
     * 成功
     */
    public static <T> CommonResult success(T data){
        return new CommonResult<>(true, data);
    }

    /**
     * 失败
     */
    public static CommonResult failed() {
        return new CommonResult<>(false, null);
    }

}
