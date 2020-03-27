package com.example.demo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

import javax.inject.Provider;
import java.time.LocalTime;

public class SingletonBean {

    @Autowired
    Provider<PrototypeBean> bean;

    public void sendMsg() {
        System.out.println("singleton bean");
    }

    @Lookup
    public PrototypeBean getBean() {
        System.out.println(String.valueOf(LocalTime.now()));
        return bean.get();
    }
}
