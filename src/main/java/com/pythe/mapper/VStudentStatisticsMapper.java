package com.pythe.mapper;

import com.pythe.pojo.VStudentStatistics;
import com.pythe.pojo.VStudentStatisticsExample;
import com.pythe.pojo.VStudentStatisticsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VStudentStatisticsMapper {
    int countByExample(VStudentStatisticsExample example);

    int deleteByExample(VStudentStatisticsExample example);

    int insert(VStudentStatisticsWithBLOBs record);

    int insertSelective(VStudentStatisticsWithBLOBs record);

    List<VStudentStatisticsWithBLOBs> selectByExampleWithBLOBs(VStudentStatisticsExample example);

    List<VStudentStatistics> selectByExample(VStudentStatisticsExample example);

    int updateByExampleSelective(@Param("record") VStudentStatisticsWithBLOBs record, @Param("example") VStudentStatisticsExample example);

    int updateByExampleWithBLOBs(@Param("record") VStudentStatisticsWithBLOBs record, @Param("example") VStudentStatisticsExample example);

    int updateByExample(@Param("record") VStudentStatistics record, @Param("example") VStudentStatisticsExample example);
}