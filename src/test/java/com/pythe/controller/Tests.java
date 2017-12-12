package com.pythe.controller;


import com.alibaba.fastjson.JSONObject;
import com.pythe.common.utils.HttpClientUtil;
import com.pythe.common.utils.JsonUtils;

public class Tests {
	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" + "&appid=" + "wx341f13cb3e75d864"
		+"&secret=" + "dcf791c946697a7c4398cfee0b2a57f4";
		String result = HttpClientUtil.doGet(url, null);
		System.out.println(result);
		String access_token = JSONObject.parseObject(result).getString("access_token");
		System.out.println("notify===========>"+access_token);
		JSONObject json = new JSONObject();
		
		json.put("id", "AT0646");

		String xw_url = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get?access_token="+access_token;
		String str = HttpClientUtil.doPostJson(xw_url, JsonUtils.objectToJson(json));
		System.out.println(str);
	}
}
