package com.pythe.mapper;

import com.pythe.pojo.VStudentBill;
import com.pythe.pojo.VStudentBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VStudentBillMapper {
    int countByExample(VStudentBillExample example);

    int deleteByExample(VStudentBillExample example);

    int insert(VStudentBill record);

    int insertSelective(VStudentBill record);

    List<VStudentBill> selectByExample(VStudentBillExample example);

    int updateByExampleSelective(@Param("record") VStudentBill record, @Param("example") VStudentBillExample example);

    int updateByExample(@Param("record") VStudentBill record, @Param("example") VStudentBillExample example);
}