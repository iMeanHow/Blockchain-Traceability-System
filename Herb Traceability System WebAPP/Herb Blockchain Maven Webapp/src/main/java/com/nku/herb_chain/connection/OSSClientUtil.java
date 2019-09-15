package com.nku.herb_chain.connection;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
 
 
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
 
/**
 * ������ OSS������
 * 
 * @author Reflux
 * @date 2018��9��30������10:38:09
 * @version 1.0
 */
@Controller
public class OSSClientUtil {
 
	public static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);
	// endpoint
	private String endpoint = "http://oss-cn-beijing.aliyuncs.com";
	// accessKey
	private String accessKeyId = "LTAIitMHa8JFvjAw";
	private String accessKeySecret = "mR7EaMjO0qdf2V8j2fPV2lF9mzex3m";
	// �ռ�
	private String bucketName = "nkbc";
	// �ļ��洢Ŀ¼
	private String filedir = "Sanqi";
 
	private OSSClient ossClient;
 
	public OSSClientUtil() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
 
	/**
	 * ��ʼ��
	 */
	public void init() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
 
	/**
	 * ����
	 */
	public void destory() {
		ossClient.shutdown();
	}
 
	/**
	 * �ϴ�ͼƬ
	 *
	 * @param url
	 * @throws IOException
	 */
	public void uploadImg2Oss(String url) throws IOException {
		File fileOnServer = new File(url);
		FileInputStream fin;
		try {
			fin = new FileInputStream(fileOnServer);
			String[] split = url.split("/");
			this.uploadFile2OSS(fin, split[split.length - 1]);
		} catch (FileNotFoundException e) {
			throw new IOException("ͼƬ�ϴ�ʧ��");
		}
	}
 
	public String uploadImg2Oss(MultipartFile file) throws IOException {
		if (file.getSize() > 10 * 1024 * 1024) {
			throw new IOException("�ϴ�ͼƬ��С���ܳ���10M��");
		}
		String originalFilename = file.getOriginalFilename();
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = file.getInputStream();
			this.uploadFile2OSS(inputStream, name);
			return name;
		} catch (Exception e) {
			throw new IOException("ͼƬ�ϴ�ʧ��");
		}
	}
 
	/**
	 * ���ͼƬ·��
	 *
	 * @param fileUrl
	 * @return
	 */
	public String getImgUrl(String fileUrl) {
		System.out.println(fileUrl);
		if (!StringUtils.isEmpty(fileUrl)) {
			String[] split = fileUrl.split("/");
			return this.getUrl(this.filedir + split[split.length - 1]);
		}
		return null;
	}
 
	/**
	 * �ϴ���OSS������ ���ͬ���ļ��Ḳ�Ƿ������ϵ�
	 *
	 * @param instream
	 *            �ļ���
	 * @param fileName
	 *            �ļ����� ������׺��
	 * @return ������"" ,ΨһMD5����ǩ��
	 */
	public String uploadFile2OSS(InputStream instream, String fileName) {
		String ret = "";
		try {
			// �����ϴ�Object��Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// �ϴ��ļ�
			PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
 
	/**
	 * Description: �ж�OSS�����ļ��ϴ�ʱ�ļ���contentType
	 *
	 * @param FilenameExtension
	 *            �ļ���׺
	 * @return String
	 */
	public static String getcontentType(String filenameExtension) {
		if (filenameExtension.equalsIgnoreCase("bmp")) {
			return "image/bmp";
		}
		if (filenameExtension.equalsIgnoreCase("gif")) {
			return "image/gif";
		}
		if (filenameExtension.equalsIgnoreCase("jpeg") || filenameExtension.equalsIgnoreCase("jpg")
				|| filenameExtension.equalsIgnoreCase("png")) {
			return "image/jpeg";
		}
		if (filenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (filenameExtension.equalsIgnoreCase("txt")) {
			return "text/plain";
		}
		if (filenameExtension.equalsIgnoreCase("vsd")) {
			return "application/vnd.visio";
		}
		if (filenameExtension.equalsIgnoreCase("pptx") || filenameExtension.equalsIgnoreCase("ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (filenameExtension.equalsIgnoreCase("docx") || filenameExtension.equalsIgnoreCase("doc")) {
			return "application/msword";
		}
		if (filenameExtension.equalsIgnoreCase("xml")) {
			return "text/xml";
		}
		return "image/jpeg";
	}
 
	/**
	 * ���url����
	 *
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		// ����URL����ʱ��Ϊ10�� 3600l* 1000*24*365*10
 
		Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
		// ����URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}
}
