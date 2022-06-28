package com.javacode2018.springmvcseries.gson;

import com.google.gson.Gson;
import com.javacode2018.springmvcseries.gson.Student1.Name;
import org.springframework.web.client.HttpClientErrorException.Gone;

/**
 * @author crush
 */
public class GsonTester3 {

    public static void main(String[] args) {
        Student1 student1 = new Student1();
        student1.setRollNo(1);
        Name name = student1.new Name();
        name.firstName = "Mahesh";
        name.lastName = "Kumar";
        student1.setName(name);
        Gson gson = new Gson();
        String s = gson.toJson(student1);
        System.out.println(s);

        Student1 student11 = gson.fromJson(s, Student1.class);
        System.out.println(student11.getRollNo());
        System.out.println(student11.getName().firstName);
        System.out.println(student11.getName().lastName);

        String s1 = gson.toJson(name);

        System.out.println(s1);

        Name name1 = gson.fromJson(s1, Name.class);

        System.out.println("name1.firstName = " + name1.firstName);
        System.out.println("name1.lastName = " + name1.lastName);


    }


}

class Student1 {

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

    class Name {

        public String firstName;
        public String lastName;
    }
}

