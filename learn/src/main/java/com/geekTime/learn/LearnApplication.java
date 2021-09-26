package com.geekTime.learn;

import com.geekTime.learn.HttpClient.OkHttp;
import com.geekTime.learn.loadClass.MyClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
		try {
			OkHttp.main(args);
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
