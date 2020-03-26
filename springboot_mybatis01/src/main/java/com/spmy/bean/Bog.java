package com.spmy.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/**
 * PropertySource指定引用的配置文件，因为@ConfigurationProperties默认识别主配置文件
 */
@PropertySource(value = {"classpath:bog.properties"})
@ConfigurationProperties(prefix = "bog")
public class Bog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Bog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
