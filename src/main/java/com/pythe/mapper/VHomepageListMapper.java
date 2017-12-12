package com.pythe.mapper;

import com.pythe.pojo.VHomepageList;
import com.pythe.pojo.VHomepageListExample;
import com.pythe.pojo.VHomepageListWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VHomepageListMapper {
    int countByExample(VHomepageListExample example);

    int deleteByExample(VHomepageListExample example);

    int insert(VHomepageListWithBLOBs record);

    int insertSelective(VHomepageListWithBLOBs record);

    List<VHomepageListWithBLOBs> selectByExampleWithBLOBs(VHomepageListExample example);

    List<VHomepageList> selectByExample(VHomepageListExample example);

    int updateByExampleSelective(@Param("record") VHomepageListWithBLOBs record, @Param("example") VHomepageListExample example);

    int updateByExampleWithBLOBs(@Param("record") VHomepageListWithBLOBs record, @Param("example") VHomepageListExample example);

    int updateByExample(@Param("record") VHomepageList record, @Param("example") VHomepageListExample example);
    
    List<VHomepageListWithBLOBs> selectDefaultListByGradeId(Integer gradeId);

   	List<VHomepageListWithBLOBs> selectListByGradeIdAndSubject(@Param("gradeId") Integer gradeId,@Param("subjectId") Integer subjectId);

   	List<VHomepageListWithBLOBs> selectListByFeeAndLikesNum(Integer gradeId);
   	
}