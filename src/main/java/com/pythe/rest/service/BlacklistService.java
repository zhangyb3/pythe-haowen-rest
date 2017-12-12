package com.pythe.rest.service;

import com.pythe.common.pojo.PytheResult;

public interface BlacklistService {



	/**
	 * @param userId
	 * @param complainedId
	 * @param answerId 
	 * @return 黑名单条数
	 */
	Long insertBlacklistRecord(Long userId, Long complainedId, Long answerId);

	PytheResult deleteBlacklistRecord(Long userId, Long answerId);


	
}
