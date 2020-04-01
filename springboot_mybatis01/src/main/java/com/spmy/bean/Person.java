package com.spmy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.Map;

/**
 * @component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
 */
@Component
/**
 * @ConfigurationProperties将实体类属性和配置文件属性进行绑定
 */
@ConfigurationProperties(prefix="person")
//@Validated
public class Person {
//    @Value("${person.name}")
    private String name;
    private Integer age;
    private Map<String,Object> map;
    private List<Object> list;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", map=" + map +
                ", list=" + list +
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

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
