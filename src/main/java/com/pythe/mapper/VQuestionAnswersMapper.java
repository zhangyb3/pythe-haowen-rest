package com.pythe.mapper;

import com.pythe.pojo.VQuestionAnswers;
import com.pythe.pojo.VQuestionAnswersExample;
import com.pythe.pojo.VQuestionAnswersWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VQuestionAnswersMapper {
    int countByExample(VQuestionAnswersExample example);

    int deleteByExample(VQuestionAnswersExample example);

    int insert(VQuestionAnswersWithBLOBs record);

    int insertSelective(VQuestionAnswersWithBLOBs record);

    List<VQuestionAnswersWithBLOBs> selectByExampleWithBLOBs(VQuestionAnswersExample example);

    List<VQuestionAnswers> selectByExample(VQuestionAnswersExample example);

    int updateByExampleSelective(@Param("record") VQuestionAnswersWithBLOBs record, @Param("example") VQuestionAnswersExample example);

    int updateByExampleWithBLOBs(@Param("record") VQuestionAnswersWithBLOBs record, @Param("example") VQuestionAnswersExample example);

    int updateByExample(@Param("record") VQuestionAnswers record, @Param("example") VQuestionAnswersExample example);
    
    List<VQuestionAnswersWithBLOBs> selectIsAnswerListByTeacherId(Long teacherId);

	List<VQuestionAnswersWithBLOBs> selectIsNotAnswerListByTeacherId(Long teacherId);
	
	
	List<VQuestionAnswersWithBLOBs> selectIsAnswerListByStudentId(Long studentId);

	List<VQuestionAnswersWithBLOBs> selectIsNotAnswerListByStudentId(Long studentId);
}