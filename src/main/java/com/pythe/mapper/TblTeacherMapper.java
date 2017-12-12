package com.pythe.mapper;

import com.pythe.pojo.TblTeacher;
import com.pythe.pojo.TblTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblTeacherMapper {
    int countByExample(TblTeacherExample example);

    int deleteByExample(TblTeacherExample example);

    int deleteByPrimaryKey(Long teacherid);

    int insert(TblTeacher record);

    int insertSelective(TblTeacher record);

    List<TblTeacher> selectByExampleWithBLOBs(TblTeacherExample example);

    List<TblTeacher> selectByExample(TblTeacherExample example);

    TblTeacher selectByPrimaryKey(Long teacherid);

    int updateByExampleSelective(@Param("record") TblTeacher record, @Param("example") TblTeacherExample example);

    int updateByExampleWithBLOBs(@Param("record") TblTeacher record, @Param("example") TblTeacherExample example);

    int updateByExample(@Param("record") TblTeacher record, @Param("example") TblTeacherExample example);

    int updateByPrimaryKeySelective(TblTeacher record);

    int updateByPrimaryKeyWithBLOBs(TblTeacher record);

    int updateByPrimaryKey(TblTeacher record);
}