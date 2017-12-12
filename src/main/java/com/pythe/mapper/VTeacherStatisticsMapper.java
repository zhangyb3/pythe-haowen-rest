package com.pythe.mapper;

import com.pythe.pojo.VTeacherStatistics;
import com.pythe.pojo.VTeacherStatisticsExample;
import com.pythe.pojo.VTeacherStatisticsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VTeacherStatisticsMapper {
    int countByExample(VTeacherStatisticsExample example);

    int deleteByExample(VTeacherStatisticsExample example);

    int insert(VTeacherStatisticsWithBLOBs record);

    int insertSelective(VTeacherStatisticsWithBLOBs record);

    List<VTeacherStatisticsWithBLOBs> selectByExampleWithBLOBs(VTeacherStatisticsExample example);

    List<VTeacherStatistics> selectByExample(VTeacherStatisticsExample example);

    int updateByExampleSelective(@Param("record") VTeacherStatisticsWithBLOBs record, @Param("example") VTeacherStatisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") VTeacherStatisticsWithBLOBs record, @Param("example") VTeacherStatisticsExample example);

    int updateByExample(@Param("record") VTeacherStatistics record, @Param("example") VTeacherStatisticsExample example);
}