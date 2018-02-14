package com.intuit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(scopedProxy = ScopedProxyMode.TARGET_CLASS, basePackages = { "com.intuit"})
@EnableTransactionManagement(proxyTargetClass = true)
public class Application
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(Application.class, args);
	}
}
