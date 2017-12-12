package com.pythe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args) {
//		try {
//			FileInputStream instream = new FileInputStream(new File("src/main/resources/resource/apiclient_cert.p12"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		//uploadFile
		//("139.199.212.174", 21, "ftpuser","pythe888", "/home/ftpuser/www", "/image/2019/04", "1.png", inputStream);
//		String str = "/image/2017/3/30/store_2054369272o6zAJszZtla1bslHFhnJTbWBTVik1490879237598.jpg";
////		// String basePath,String filePath, String filename
////		String basePath ="/home/ftpuser/www";
//		String filePath = str.substring(0,str.lastIndexOf("/"));
//		String fileName = str.substring(str.lastIndexOf("/")+1);
//		System.out.println(filePath);
//		System.out.println(fileName);
////		//str.substring());
//		
//		System.out.println(1500d/279d +" "+2722d/378d);
//		
//		//json转换为list
//		String json = "[1,2,3,4]";
//		List<Long> list = JSONObject.parseArray(json, Long.class);
//		list.forEach(x->System.out.println(x));
		
		 String str = "{\"biography\":\"[128,14956,14427]\",\"history\":\"[1255,1110]\"}";
//		 Pattern p = Pattern.compile("-?\\d+");
//		 Matcher m = p.matcher(str);
//		 while (m.find()) {
//			  System.out.println(m.group());
//			}
		
		str = str.replaceAll("[^-?0-9]+", " "); 
		List<Long> list = Arrays.asList(str.trim().split(" "))
				.stream().map(s->Long.parseLong(s))
				.collect(Collectors.toList());
		//.stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
		//List<String> list = Arrays.asList(str.trim().split(" "));
		
//	    
	     String a = "jí";
		 Pattern p = Pattern.compile("^[a-zA-Z]*");
		 if (p.matches("^[a-zA-Z]*", a)) {
			System.out.println("是拼音");
		}
//		 Matcher m = p.matcher(str);
//		 while (m.find()) {
//			  System.out.println(m.group());
//			}
		
//		 while (m.find()) {
//		 if (!"".equals(m.group()))
//		 System.out.println("come here:" + m.group());
//		 }
		
	}
}
