package com.pythe.mapper;

import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserExample;
import com.pythe.pojo.TblUserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserMapper {
    int countByExample(TblUserExample example);

    int deleteByExample(TblUserExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(TblUserWithBLOBs record);

    int insertSelective(TblUserWithBLOBs record);

    List<TblUserWithBLOBs> selectByExampleWithBLOBs(TblUserExample example);

    List<TblUser> selectByExample(TblUserExample example);

    TblUserWithBLOBs selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") TblUserWithBLOBs record, @Param("example") TblUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TblUserWithBLOBs record, @Param("example") TblUserExample example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByPrimaryKeySelective(TblUserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TblUserWithBLOBs record);

    int updateByPrimaryKey(TblUser record);
}