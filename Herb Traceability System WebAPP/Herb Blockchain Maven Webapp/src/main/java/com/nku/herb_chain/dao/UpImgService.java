package com.nku.herb_chain.dao;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nku.herb_chain.connection.OSSClientUtil;

public class UpImgService {
	public String updateHead(MultipartFile file) throws IOException {
		System.out.println("img service");
	    if (file == null || file.getSize() <= 0) {
		      System.out.println("file²»ÄÜÎª¿Õ");
		    }
	        OSSClientUtil ossClient=new OSSClientUtil();
		    String name = ossClient.uploadImg2Oss(file);
		    String imgUrl = ossClient.getImgUrl(name);
		    String[] split = imgUrl.split("\\?");
		    System.out.println("split_url="+split[0]);
		    return split[0];
	}
}

