package com.pythe.mapper;

import com.pythe.pojo.TblKnowledge;
import com.pythe.pojo.TblKnowledgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblKnowledgeMapper {
    int countByExample(TblKnowledgeExample example);

    int deleteByExample(TblKnowledgeExample example);

    int deleteByPrimaryKey(Long knowledgeid);

    int insert(TblKnowledge record);

    int insertSelective(TblKnowledge record);

    List<TblKnowledge> selectByExample(TblKnowledgeExample example);

    TblKnowledge selectByPrimaryKey(Long knowledgeid);

    int updateByExampleSelective(@Param("record") TblKnowledge record, @Param("example") TblKnowledgeExample example);

    int updateByExample(@Param("record") TblKnowledge record, @Param("example") TblKnowledgeExample example);

    int updateByPrimaryKeySelective(TblKnowledge record);

    int updateByPrimaryKey(TblKnowledge record);
    
  List<TblKnowledge> selectFirstKnowledgeList(@Param("phase")Integer phase, @Param("subjectId")Integer subjectId);
    
    List<TblKnowledge> selectSecondKnowledgeList(String level1);
}