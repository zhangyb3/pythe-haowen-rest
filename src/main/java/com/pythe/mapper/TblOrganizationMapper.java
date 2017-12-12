package com.pythe.mapper;

import com.pythe.pojo.TblOrganization;
import com.pythe.pojo.TblOrganizationExample;
import com.pythe.pojo.TblOrganizationWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrganizationMapper {
    int countByExample(TblOrganizationExample example);

    int deleteByExample(TblOrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblOrganizationWithBLOBs record);

    int insertSelective(TblOrganizationWithBLOBs record);

    List<TblOrganizationWithBLOBs> selectByExampleWithBLOBs(TblOrganizationExample example);

    List<TblOrganization> selectByExample(TblOrganizationExample example);

    TblOrganizationWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblOrganizationWithBLOBs record, @Param("example") TblOrganizationExample example);

    int updateByExampleWithBLOBs(@Param("record") TblOrganizationWithBLOBs record, @Param("example") TblOrganizationExample example);

    int updateByExample(@Param("record") TblOrganization record, @Param("example") TblOrganizationExample example);

    int updateByPrimaryKeySelective(TblOrganizationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TblOrganizationWithBLOBs record);

    int updateByPrimaryKey(TblOrganization record);

	List<TblOrganizationWithBLOBs> queryNearestOrgs(@Param("longitude") double longitude, @Param("latitude") double latitude);

	List<TblOrganizationWithBLOBs> queryNearbyOrgsOnMap(@Param("longitude") double longitude, @Param("latitude") double latitude, @Param("quantity") int quantity);
}