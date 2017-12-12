package com.pythe.mapper;

import com.pythe.pojo.VTeacher;
import com.pythe.pojo.VTeacherExample;
import com.pythe.pojo.VTeacherWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VTeacherMapper {
    int countByExample(VTeacherExample example);

    int deleteByExample(VTeacherExample example);

    int insert(VTeacherWithBLOBs record);

    int insertSelective(VTeacherWithBLOBs record);

    List<VTeacherWithBLOBs> selectByExampleWithBLOBs(VTeacherExample example);

    List<VTeacher> selectByExample(VTeacherExample example);

    int updateByExampleSelective(@Param("record") VTeacherWithBLOBs record, @Param("example") VTeacherExample example);

    int updateByExampleWithBLOBs(@Param("record") VTeacherWithBLOBs record, @Param("example") VTeacherExample example);

    int updateByExample(@Param("record") VTeacher record, @Param("example") VTeacherExample example);
}