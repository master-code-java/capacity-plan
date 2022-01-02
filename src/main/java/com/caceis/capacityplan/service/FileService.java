	package com.caceis.capacityplan.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public boolean processFile(MultipartFile file);
	

}
