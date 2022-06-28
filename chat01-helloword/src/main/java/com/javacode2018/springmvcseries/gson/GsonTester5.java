package com.javacode2018.springmvcseries.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/**
 * @author crush
 */
public class GsonTester5 {

    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Student3.class, new StudentAdapter());
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String jsonString = "{\"name\":\"Maxsu\", \"rollNo\":1}";
        Student3 student = gson.fromJson(jsonString, Student3.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}

class StudentAdapter extends TypeAdapter<Student3> {

    @Override
    public void write(JsonWriter writer, Student3 student3) throws IOException {
        writer.beginObject();
        writer.name("name");
        writer.value(student3.getName());
        writer.name("rollNo");
        writer.value(student3.getRollNo());
        writer.endObject();
    }

    @Override
    public Student3 read(JsonReader jsonReader) throws IOException {

        final Student3 student3 = new Student3();
        jsonReader.beginObject();
        String fieldname = null;

        while (jsonReader.hasNext()) {
            JsonToken token = jsonReader.peek();

            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = jsonReader.nextName();
            }
            if ("name".equals(fieldname)) {
                //move to next token
                token = jsonReader.peek();
                student3.setName(jsonReader.nextString());
            }
            if ("rollNo".equals(fieldname)) {
                //move to next token
                token = jsonReader.peek();
                student3.setRollNo(jsonReader.nextInt());
            }
        }
        jsonReader.endObject();
        return student3;
    }
}


class Student3 {

    private int rollNo;
    private String name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student[ name = " + name + ", roll no: " + rollNo + "]";
    }
}
