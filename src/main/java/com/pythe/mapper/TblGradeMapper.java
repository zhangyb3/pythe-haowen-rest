package com.pythe.mapper;

import com.pythe.pojo.TblGrade;
import com.pythe.pojo.TblGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblGradeMapper {
    int countByExample(TblGradeExample example);

    int deleteByExample(TblGradeExample example);

    int deleteByPrimaryKey(Integer gradeid);

    int insert(TblGrade record);

    int insertSelective(TblGrade record);

    List<TblGrade> selectByExample(TblGradeExample example);

    TblGrade selectByPrimaryKey(Integer gradeid);

    int updateByExampleSelective(@Param("record") TblGrade record, @Param("example") TblGradeExample example);

    int updateByExample(@Param("record") TblGrade record, @Param("example") TblGradeExample example);

    int updateByPrimaryKeySelective(TblGrade record);

    int updateByPrimaryKey(TblGrade record);

	List<TblGrade> selectByCustomer();
}