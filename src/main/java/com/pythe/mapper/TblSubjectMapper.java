package com.pythe.mapper;

import com.pythe.pojo.TblSubject;
import com.pythe.pojo.TblSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSubjectMapper {
    int countByExample(TblSubjectExample example);

    int deleteByExample(TblSubjectExample example);

    int deleteByPrimaryKey(Integer subjectid);

    int insert(TblSubject record);

    int insertSelective(TblSubject record);

    List<TblSubject> selectByExample(TblSubjectExample example);

    TblSubject selectByPrimaryKey(Integer subjectid);

    int updateByExampleSelective(@Param("record") TblSubject record, @Param("example") TblSubjectExample example);

    int updateByExample(@Param("record") TblSubject record, @Param("example") TblSubjectExample example);

    int updateByPrimaryKeySelective(TblSubject record);

    int updateByPrimaryKey(TblSubject record);

//	List<TblSubject> selectSubjectByPhase(@Param("subjectId") Integer subjectId);
}