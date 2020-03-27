package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Provider;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@RestController
	@ComponentScan("com.example.demo")
	class Test {


		private SingletonBean thing;

		@Autowired
		public Test(SingletonBean thing) {
			this.thing = thing;
		}


		@GetMapping("/greeting")
		public String greeting() {

			thing.sendMsg();
			PrototypeBean bean = thing.getBean();

			return thing.toString() + "\n" + bean.toString();
		}

	}

}
