package com.smhrd.iot.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.service.jsonService;


@RestController
@RequestMapping("/json")
public class jsonController {
	String j;
	
	@Autowired
	private jsonService service;
	
	@RequestMapping("/json")
	//json으로 넣기위해서 @RequestBody으로 파싱한다
	public String receiveJsonData(@RequestBody String j ) {
		System.out.println("컨트롤러에 들어옴!");
		System.out.println(j);
//		System.out.println(j.getGreenLightTime());
		this.j = j;
		//최종에 jsonService삭제 예정
		return null;
	}
	
	//.json파일 리턴하는 코드
//	@GetMapping("/requestjson")
//	public ResponseEntity<String> getData() throws IOException {
//        // .json 파일 경로
//        String filePath = "com/smhrd/iot/json/getjson.json";
//
//        // .json 파일을 문자열로 읽기
//        ClassPathResource resource = new ClassPathResource(filePath);
//        Path path = resource.getFile().toPath();
//        String jsonData = Files.readString(path, StandardCharsets.UTF_8);
//
//        // JSON 데이터 반환
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(j);
//    }
	
	
	@GetMapping("/requestjson")  // 요청을 받을 URL
    public String getJsonData() {
        
        return j;  // JSON 데이터 반환
    }
	
	
	
//	@RequestMapping("/json")
//	//json으로 넣기위해서 @RequestBody으로 파싱한다
//	public String receiveJsonData(@RequestParam("userID") String id ) {
//		System.out.println("들어옴!");
//		System.out.println(id);
//		System.out.println(id);
//		return null;
//	}
//	
//	@PostMapping(value ="/json", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String receiveJsonData(@RequestBody getJson j ) {
//		System.out.println("들어옴!");
//		System.out.println(j);
//		System.out.println(j.getGreenLightTime());
//		return null;
//	}
}






