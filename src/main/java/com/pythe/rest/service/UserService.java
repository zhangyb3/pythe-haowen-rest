package com.pythe.rest.service;

import java.util.List;

import com.pythe.common.pojo.PytheResult;
import com.pythe.pojo.CodePacket;
import com.pythe.pojo.TblQuestion;
import com.pythe.pojo.TblUser;
import com.pythe.pojo.TblUserWithBLOBs;

public interface UserService  {
    
	/**
	 * 返回所有学科
	 * @return
	 */
	PytheResult selectAllSubject();
	
	/**
	 * 返回所有年级
	 * @return
	 */
	PytheResult selectAllGrade();
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	TblUser login(String username, String password);

	/**
	 * 注册
	 * @param url
	 * @return
	 */
	PytheResult register(String url);

	  /**
     * 编辑用户信息
     * @param username
     * @param description
	 * @param description2 
     * @return
     */
	TblUserWithBLOBs updatePersonalImformation(Long userId,String username, String description) throws Exception;
	
	
	/**
     * 收藏
	 * @param pageSize 
	 * @param pageNum 
     */
	PytheResult selectCollectQuestionByHomeId(Long userId,Integer pageNum, Integer pageSize);

	PytheResult selectCollectTeacherByTeacherId(Long userId,  Integer pageNum, Integer pageSize);

	
	String decodeUserInfo(String encryptedData, String iv, String sessionId);

	Object updateRequest(String code);


	String selectResponseByPrePayImforamtion(String url) throws Exception;

	Boolean findSessionId(String sessionId);

	PytheResult selectUserIdByOpenId(String openId);

	//PytheResult selectAnswerIsLiked(Long userId,Long answerId);

	//PytheResult selectTeacherIsLiked(Long userId, Long teacherId);
	
	PytheResult selectUserByUserId(Long userId);

	PytheResult updateAvatar(Long userId, String avatarUrl);






	
	
}
