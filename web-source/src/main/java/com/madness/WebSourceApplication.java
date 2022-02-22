package com.madness;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableEncryptableProperties
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WebSourceApplication {

	public static void main(String[] args) {
//		Security.addProvider(new BouncyCastleProvider());
		SpringApplication.run(WebSourceApplication.class, args);
	}
}
