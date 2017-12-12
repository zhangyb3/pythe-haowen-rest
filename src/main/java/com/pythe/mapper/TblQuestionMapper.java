package com.pythe.mapper;

import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblQuestionMapper {
    int countByExample(TblQuestionExample example);

    int deleteByExample(TblQuestionExample example);

    int deleteByPrimaryKey(Long questionid);

    int insert(TblQuestion record);

    int insertSelective(TblQuestion record);

    List<TblQuestion> selectByExampleWithBLOBs(TblQuestionExample example);

    List<TblQuestion> selectByExample(TblQuestionExample example);

    TblQuestion selectByPrimaryKey(Long questionid);

    int updateByExampleSelective(@Param("record") TblQuestion record, @Param("example") TblQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") TblQuestion record, @Param("example") TblQuestionExample example);

    int updateByExample(@Param("record") TblQuestion record, @Param("example") TblQuestionExample example);

    int updateByPrimaryKeySelective(TblQuestion record);

    int updateByPrimaryKeyWithBLOBs(TblQuestion record);

    int updateByPrimaryKey(TblQuestion record);
}