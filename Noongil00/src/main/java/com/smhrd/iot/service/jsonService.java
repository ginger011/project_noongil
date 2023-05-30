package com.smhrd.iot.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class jsonService {

	public String getJson(String j) {
		System.out.println("jsonService에 json이 들어옴");
		System.out.println(j);
		
		// .json 파일 경로
        String filePath = "src/main/resources/com/smhrd/iot/json/getJson.json";
        System.out.println("pathing 완료");
        // 새로운 JSON 데이터
        String newJsonData = j;
        System.out.println("json생성 완료");
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			JsonNode jsonNode = objectMapper.readTree(new File(filePath));
			
            // JSON 데이터 수정
            jsonNode = objectMapper.readTree(newJsonData);
            System.out.println("수정완료");
            
            // 수정된 JSON 데이터를 .json 파일에 저장
            objectMapper.writeValue(new File(filePath), jsonNode);
            System.out.println("data.json 파일이 수정되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return null;
	}
	
}
