package com.pythe.mapper;

import com.pythe.pojo.VQuestionIsAnswers;
import com.pythe.pojo.VQuestionIsAnswersExample;
import com.pythe.pojo.VQuestionIsAnswersWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VQuestionIsAnswersMapper {
    int countByExample(VQuestionIsAnswersExample example);

    int deleteByExample(VQuestionIsAnswersExample example);

    int insert(VQuestionIsAnswersWithBLOBs record);

    int insertSelective(VQuestionIsAnswersWithBLOBs record);

    List<VQuestionIsAnswersWithBLOBs> selectByExampleWithBLOBs(VQuestionIsAnswersExample example);

    List<VQuestionIsAnswers> selectByExample(VQuestionIsAnswersExample example);

    int updateByExampleSelective(@Param("record") VQuestionIsAnswersWithBLOBs record, @Param("example") VQuestionIsAnswersExample example);

    int updateByExampleWithBLOBs(@Param("record") VQuestionIsAnswersWithBLOBs record, @Param("example") VQuestionIsAnswersExample example);

    int updateByExample(@Param("record") VQuestionIsAnswers record, @Param("example") VQuestionIsAnswersExample example);
}