package com.davidlabs;

public class Person {
    
    public double height =0;

    public int age = 0;

    public String name = "";

    @Override
    public String toString() {
        return "Person [height=" + height + ", age=" + age + ", name=" + name + "]";
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Person(double height, int age) {
        this.height = height;
        this.age = age;
    }

    Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
