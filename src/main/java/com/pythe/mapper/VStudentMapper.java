package com.pythe.mapper;

import com.pythe.pojo.VStudent;
import com.pythe.pojo.VStudentExample;
import com.pythe.pojo.VStudentWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VStudentMapper {
    int countByExample(VStudentExample example);

    int deleteByExample(VStudentExample example);

    int insert(VStudentWithBLOBs record);

    int insertSelective(VStudentWithBLOBs record);

    List<VStudentWithBLOBs> selectByExampleWithBLOBs(VStudentExample example);

    List<VStudent> selectByExample(VStudentExample example);

    int updateByExampleSelective(@Param("record") VStudentWithBLOBs record, @Param("example") VStudentExample example);

    int updateByExampleWithBLOBs(@Param("record") VStudentWithBLOBs record, @Param("example") VStudentExample example);

    int updateByExample(@Param("record") VStudent record, @Param("example") VStudentExample example);
}