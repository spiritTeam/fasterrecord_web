package com.energylabel.fastrecord.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.OSSClient;

public class OssCommonClient {
	private Logger logger = LoggerFactory.getLogger(OssCommonClient.class);

	private OSSClient client;
	private String env;
	private String bucketName;

	public OssCommonClient() {
		addShutdownHook();
	}

	private void addShutdownHook() {
		logger.info("OSS add shutdown hook .");
		try {
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (null != client)
						client.shutdown();
				}
			});
		} catch (Exception e) {
			System.exit(1);
		}
	}

	public OSSClient getClient() {
		return client;
	}

	public void setClient(OSSClient client) {
		this.client = client;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

}
