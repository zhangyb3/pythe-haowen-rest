package com.pythe.mapper;

import com.pythe.pojo.TblBlacklist;
import com.pythe.pojo.TblBlacklistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblBlacklistMapper {
    int countByExample(TblBlacklistExample example);

    int deleteByExample(TblBlacklistExample example);

    int deleteByPrimaryKey(Long blacklistid);

    int insert(TblBlacklist record);

    int insertSelective(TblBlacklist record);

    List<TblBlacklist> selectByExampleWithBLOBs(TblBlacklistExample example);

    List<TblBlacklist> selectByExample(TblBlacklistExample example);

    TblBlacklist selectByPrimaryKey(Long blacklistid);

    int updateByExampleSelective(@Param("record") TblBlacklist record, @Param("example") TblBlacklistExample example);

    int updateByExampleWithBLOBs(@Param("record") TblBlacklist record, @Param("example") TblBlacklistExample example);

    int updateByExample(@Param("record") TblBlacklist record, @Param("example") TblBlacklistExample example);

    int updateByPrimaryKeySelective(TblBlacklist record);

    int updateByPrimaryKeyWithBLOBs(TblBlacklist record);

    int updateByPrimaryKey(TblBlacklist record);
}