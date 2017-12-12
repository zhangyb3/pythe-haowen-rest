package com.pythe.mapper;

import com.pythe.pojo.TblIdentifier;
import com.pythe.pojo.TblIdentifierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblIdentifierMapper {
    int countByExample(TblIdentifierExample example);

    int deleteByExample(TblIdentifierExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblIdentifier record);

    int insertSelective(TblIdentifier record);

    List<TblIdentifier> selectByExample(TblIdentifierExample example);

    TblIdentifier selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblIdentifier record, @Param("example") TblIdentifierExample example);

    int updateByExample(@Param("record") TblIdentifier record, @Param("example") TblIdentifierExample example);

    int updateByPrimaryKeySelective(TblIdentifier record);

    int updateByPrimaryKey(TblIdentifier record);
}