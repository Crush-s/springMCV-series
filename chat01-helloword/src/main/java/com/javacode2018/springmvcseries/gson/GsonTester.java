package com.javacode2018.springmvcseries.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author crush
 */
public class GsonTester {

    public static void main(String[] args) {

        GsonTester tester = new GsonTester();

        Student student = new Student();
        student.setAge(10);
        student.setName("Mahesh");
        // student.set
        tester.writeJson(student);
        System.out.println(tester.readJSON());

    }

    private void writeJson(Student student) {
        Gson gson = new GsonBuilder().create();
        try (FileWriter fileWriter = new FileWriter(
                "C:\\Users\\crush\\Desktop\\fsdownload\\student.json")) {
            fileWriter.write(gson.toJson(student));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Student readJSON() {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("C:\\Users\\crush\\Desktop\\fsdownload\\student.json"))) {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(bufferedReader, Student.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class Student {

    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student [ name: " + name + ", age: " + age + " ]";
    }
}
