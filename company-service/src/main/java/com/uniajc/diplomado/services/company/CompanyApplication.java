package com.uniajc.diplomado.services.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
public class CompanyApplication
{
	/*
		Role
		UserCompanyRole
		User
		Company
		Dealing
		DocumentTransferStatus
		DocumentTranfer
		Document
	 */
	/**
	 *
	 * 	@param args
	 */
	public static void main(String[] args) {
		SpringApplication.run (CompanyApplication.class, args);
	}

}
