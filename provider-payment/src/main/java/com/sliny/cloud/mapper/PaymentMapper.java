package com.sliny.cloud.mapper;

import com.sliny.cloud.entity.Payment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @date 2020/10/11 17:52
 */
@Mapper
@Repository
public interface PaymentMapper{

    @Results(id = "BaseResult",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "serial",column = "serial")
    })
    @Select("SELECT `ID`,`SERIAL` FROM PAYMENT WHERE `ID` = #{id}")
    Payment getPaymentById(@Param("id") Long id);

    @Insert("INSERT INTO PAYMENT VALUE(DEFAULT,#{serial})")
    int save(Payment payment);
}
