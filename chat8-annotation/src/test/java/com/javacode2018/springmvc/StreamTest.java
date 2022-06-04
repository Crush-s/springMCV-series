package com.javacode2018.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("man", 17, "宁波", 888.8));
    }

    /**
     * 按字段分组
     * 按条件分组
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(Double.NaN);
        // GROUP BY address
        Map<String, List<Person>> groupingByAddress = list.stream().collect(Collectors.groupingBy(Person::getAddress));
        System.out.println(groupingByAddress);

        // GROUP BY address, age
        Map<String, Map<Integer, List<Person>>> doubleGroupingBy = list.stream()
                .collect(Collectors.groupingBy(Person::getAddress, Collectors.groupingBy(Person::getAge)));
        System.out.println(doubleGroupingBy);

        // 简单来说，就是collect(groupingBy(xx)) 扩展为 collect(groupingBy(xx, groupingBy(yy)))，嵌套分组

        // 解决了按字段分组、按多个字段分组，我们再考虑一个问题：有时我们分组的条件不是某个字段，而是某个字段是否满足xx条件
        // 比如 年龄大于等于18的是成年人，小于18的是未成年人
        Map<Boolean, List<Person>> adultsAndTeenagers = list.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18));
        System.out.println(adultsAndTeenagers);
    }

    static class Person {
        private String name;
        private Integer age;
        private String address;
        private Double salary;

        public Person() {
        }

        public Person(String name, Integer age, String address, Double salary) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.salary = salary;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }

}
