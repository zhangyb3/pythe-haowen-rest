package com.pythe.mapper;

import com.pythe.pojo.TblAnswer;
import com.pythe.pojo.TblAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAnswerMapper {
    int countByExample(TblAnswerExample example);

    int deleteByExample(TblAnswerExample example);

    int deleteByPrimaryKey(Long answerid);

    int insert(TblAnswer record);

    int insertSelective(TblAnswer record);

    List<TblAnswer> selectByExampleWithBLOBs(TblAnswerExample example);

    List<TblAnswer> selectByExample(TblAnswerExample example);

    TblAnswer selectByPrimaryKey(Long answerid);

    int updateByExampleSelective(@Param("record") TblAnswer record, @Param("example") TblAnswerExample example);

    int updateByExampleWithBLOBs(@Param("record") TblAnswer record, @Param("example") TblAnswerExample example);

    int updateByExample(@Param("record") TblAnswer record, @Param("example") TblAnswerExample example);

    int updateByPrimaryKeySelective(TblAnswer record);

    int updateByPrimaryKeyWithBLOBs(TblAnswer record);

    int updateByPrimaryKey(TblAnswer record);
    
    Double selectSumByTeacherId(@Param("teacherId") Long teacherId);
}