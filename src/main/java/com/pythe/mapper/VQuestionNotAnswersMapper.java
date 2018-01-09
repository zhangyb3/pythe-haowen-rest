package com.pythe.mapper;

import com.pythe.pojo.VQuestionNotAnswers;
import com.pythe.pojo.VQuestionNotAnswersExample;
import com.pythe.pojo.VQuestionNotAnswersWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VQuestionNotAnswersMapper {
    int countByExample(VQuestionNotAnswersExample example);

    int deleteByExample(VQuestionNotAnswersExample example);

    int insert(VQuestionNotAnswersWithBLOBs record);

    int insertSelective(VQuestionNotAnswersWithBLOBs record);

    List<VQuestionNotAnswersWithBLOBs> selectByExampleWithBLOBs(VQuestionNotAnswersExample example);

    List<VQuestionNotAnswers> selectByExample(VQuestionNotAnswersExample example);

    int updateByExampleSelective(@Param("record") VQuestionNotAnswersWithBLOBs record, @Param("example") VQuestionNotAnswersExample example);

    int updateByExampleWithBLOBs(@Param("record") VQuestionNotAnswersWithBLOBs record, @Param("example") VQuestionNotAnswersExample example);

    int updateByExample(@Param("record") VQuestionNotAnswers record, @Param("example") VQuestionNotAnswersExample example);
}