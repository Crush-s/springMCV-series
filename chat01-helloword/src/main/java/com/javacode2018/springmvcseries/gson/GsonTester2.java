package com.javacode2018.springmvcseries.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * @author crush
 */
public class GsonTester2 {

    public static void main(String[] args) {

        Shape<Circle> circleShape = new Shape<>();

        Circle circle = new Circle(5.6);
        circleShape.setShape(circle);

        Gson gson = new Gson();
        // Define a Type shapeType of type circle.
        Type shapeType = new TypeToken<Shape<Circle>>() {
        }.getType();

        //Serialize the json as ShapeType
        String jsonString = gson.toJson(circleShape, shapeType);
        System.out.println(jsonString);
        Shape shape1 = gson.fromJson(jsonString, Shape.class);

        System.out.println(shape1.get().getClass());
        System.out.println(shape1.get().toString());
        System.out.println(shape1.getArea());
        Shape shape2 = gson.fromJson(jsonString, shapeType);
        System.out.println(shape2.get().getClass());
        System.out.println(shape2.get().toString());
        System.out.println(shape2.getArea());

    }
}

class Shape<T> {

    public T shape;

    public void setShape(T shape) {
        this.shape = shape;
    }

    public T get() {
        return shape;
    }

    public double getArea() {
        if (shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else {
            return 0.0;
        }
    }
}

class Circle {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Circle";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (radius * radius * 3.14);
    }
}

