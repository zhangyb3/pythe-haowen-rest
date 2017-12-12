package com.pythe.mapper;

import com.pythe.pojo.TblTransfer;
import com.pythe.pojo.TblTransferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblTransferMapper {
    int countByExample(TblTransferExample example);

    int deleteByExample(TblTransferExample example);

    int deleteByPrimaryKey(Long transferId);

    int insert(TblTransfer record);

    int insertSelective(TblTransfer record);

    List<TblTransfer> selectByExample(TblTransferExample example);

    TblTransfer selectByPrimaryKey(Long transferId);

    int updateByExampleSelective(@Param("record") TblTransfer record, @Param("example") TblTransferExample example);

    int updateByExample(@Param("record") TblTransfer record, @Param("example") TblTransferExample example);

    int updateByPrimaryKeySelective(TblTransfer record);

    int updateByPrimaryKey(TblTransfer record);
}