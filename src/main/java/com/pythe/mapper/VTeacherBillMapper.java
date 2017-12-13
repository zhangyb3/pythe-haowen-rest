package com.pythe.mapper;

import com.pythe.pojo.VTeacherBill;
import com.pythe.pojo.VTeacherBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VTeacherBillMapper {
    int countByExample(VTeacherBillExample example);

    int deleteByExample(VTeacherBillExample example);

    int insert(VTeacherBill record);

    int insertSelective(VTeacherBill record);

    List<VTeacherBill> selectByExample(VTeacherBillExample example);

    int updateByExampleSelective(@Param("record") VTeacherBill record, @Param("example") VTeacherBillExample example);

    int updateByExample(@Param("record") VTeacherBill record, @Param("example") VTeacherBillExample example);
}