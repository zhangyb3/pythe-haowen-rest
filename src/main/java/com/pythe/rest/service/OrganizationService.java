package com.pythe.rest.service;

import java.util.List;

import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.CodePacket;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblTeacher;
import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserWithBLOBs;

public interface OrganizationService  {

	PytheResult setupOrg(Long teacherId, String orgName);

	PytheResult editOrg(Long managerId, String orgName, String orgDescription, String orgAddress, Double latitude, Double longitude);

	PytheResult addOrgTeacher(Long orgId, Long teacherId);

	PytheResult deleteOrgTeacher(Long orgId, Long teacherId);

	PytheResult orgQueryTeacher(Long orgId, String teacherPhone);

	PytheResult queryInformation(Long orgId);

	PytheResult queryOrgByManager(Long managerId);

	PytheResult queryInformationTeachers(Long orgId);

	PytheResult updateAvatar(Long orgId, String avatarUrl);

	PytheResult queryNearestOrgs(double longitude, double latitude, int pageNum, int pageSize);

	PytheResult queryNearbyOrgsOnMap(double longitude, double latitude, int quantity);
    
	

	
	
}
