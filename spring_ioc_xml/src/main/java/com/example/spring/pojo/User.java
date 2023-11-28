package com.example.spring.pojo;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
        System.out.println("生命週期1 ,實例化");
    }

    public User(Integer id, String username, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public void initMethod(){
        System.out.println("生命週期3 ,初始化");
    }
    public void destroyMethod(){
        System.out.println("生命週期4 ,銷毀");
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("生命週期2 ,依賴注入");

        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
