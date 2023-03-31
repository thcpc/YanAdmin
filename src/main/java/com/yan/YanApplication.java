package com.yan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages = {"com.yan.dao"})
@ComponentScan(basePackages = {"com.yan"})
@EnableTransactionManagement
public class YanApplication {

	@Autowired
	private Cors cors;

	public static void main(String[] args) {
		SpringApplication.run(YanApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/yan/**")
//						.allowedOrigins("*");
//						.allowedOrigins("http://localhost:4200")
//						.allowedOrigins("http://aikidoyan.cn")
						.allowedOrigins(cors.getUrl())
						.allowedMethods("*");
			}
		};
	}
}
