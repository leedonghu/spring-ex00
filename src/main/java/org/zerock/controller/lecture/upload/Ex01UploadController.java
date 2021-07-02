package org.zerock.controller.lecture.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RequestMapping("/upload")
@Controller
@Log4j
public class Ex01UploadController {
	
//	https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html
	
	@RequestMapping("/sub01")
	public void method1(String fname, @RequestParam("ufile") MultipartFile file) {
		log.info(fname);
		log.info(file.getOriginalFilename());
		
		String name = "C:/myworkspace/tempFile/" + file.getOriginalFilename();
		
		//서버 입장에서 들어오는 것이니까 input
		try(
			InputStream is = file.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
		
			FileOutputStream fos = new FileOutputStream(name);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			int len = 1024;
			byte[] b = new byte[len];
			//1024바이트를 읽도록 하는 배열
			
			int cnt = 0;
			while((cnt = bis.read(b, 0, len)) != -1) {
				//1024바이트보다 크다면 cnt에 1024를 retrun
				//계속 1024바이트씩 return하다가 읽어야하는 것이 1024보다 작아지면 그 만큼을 return
				bos.write(b, 0, cnt);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@PostMapping("/sub02")
	public void method02(MultipartFile file) {
		log.info(file.getOriginalFilename());
		String localFilePath = "C:/myworkspace/tempFile/" + file.getOriginalFilename();
		
		File localFile = new File(localFilePath);
		
		try {
			//spring에서 제공해주는 방식으로
			file.transferTo(localFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
