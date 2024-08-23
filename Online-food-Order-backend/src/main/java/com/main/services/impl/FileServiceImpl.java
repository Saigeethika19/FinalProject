package com.main.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.main.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
	    String name = file.getOriginalFilename();
	    if (name == null || name.isEmpty()) {
	        throw new IllegalArgumentException("Filename must not be empty");
	    }

	    // Extract the file extension or set a default extension
	    String fileExtension = "";
	    int lastDotIndex = name.lastIndexOf(".");
	    if (lastDotIndex != -1 && lastDotIndex < name.length() - 1) {
	        fileExtension = name.substring(lastDotIndex);
	    } else {
	        fileExtension = ".jpg"; // Default extension if none is found
	    }

	    // Generate a random name
	    String randomID = UUID.randomUUID().toString();
	    String fileName1 = randomID.concat(fileExtension);

	    // Full path
	    String filepath = path + File.separator + fileName1;

	    // Create folder if not created
	    File f = new File(path);
	    if (!f.exists()) {
	        f.mkdir();
	    }

	    // File copy
	    Files.copy(file.getInputStream(), Paths.get(filepath));
	    return fileName1;
	}


	@Override
	public InputStream getResources(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+File.separator+fileName;
		InputStream InputStream = new FileInputStream(fullPath);
//		db logic to return inputStream
		return InputStream;
	}

}