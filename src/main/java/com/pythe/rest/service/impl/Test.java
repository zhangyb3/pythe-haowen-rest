package com.pythe.rest.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println(readFileByLines("src/main/resources/resource/apiclient_cert.p12"));
	}
	
	public static List<String> readFileByLines(String fileName) {
		List<String> list = new ArrayList<String>();
		File file = new File(fileName);
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader reader = new BufferedReader(read);

			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}

			read.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
