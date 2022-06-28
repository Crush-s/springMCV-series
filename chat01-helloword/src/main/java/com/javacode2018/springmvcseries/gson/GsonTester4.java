package com.javacode2018.springmvcseries.gson;

import com.google.gson.Gson;

public class GsonTester4 {

    public static void main(String[] args) {
        Student2 student = new Student2();
        student.setRollNo(1);
        Student2.Name name = new Student2.Name();

        name.firstName = "Max";
        name.lastName = "Su";
        student.setName(name);

        Gson gson = new Gson();
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
        student = gson.fromJson(jsonString, Student2.class);

        System.out.println("Roll No: "+ student.getRollNo());
        System.out.println("First Name: "+ student.getName().firstName);
        System.out.println("Last Name: "+ student.getName().lastName);
        String nameString = gson.toJson(name);
        System.out.println(nameString);

        name = gson.fromJson(nameString,Student2.Name.class);
        System.out.println(name.getClass());
        System.out.println("First Name: "+ name.firstName);
        System.out.println("Last Name: "+ name.lastName);
    }
}

class Student2 {
    private int rollNo;
    private Name name;

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    static class Name {
        public String firstName;
        public String lastName;
    }
}
