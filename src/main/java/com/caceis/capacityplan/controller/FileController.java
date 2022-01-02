package com.caceis.capacityplan.controller;

import com.caceis.capacityplan.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
	
	private final static String CONTEXT ="file";
	

	@Autowired
	FileService fileService;
	
	@PostMapping(CONTEXT)
	public boolean processFile(@RequestParam MultipartFile file) {
		return fileService.processFile(file);
	}
	
}
