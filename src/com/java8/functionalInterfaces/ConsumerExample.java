package com.java8.functionalInterfaces;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void printNames(){
        Consumer<Student> student = (stude)-> System.out.println(stude);
        List<Student> listOfStudents = StudentDataBase.getAllStudents();
        listOfStudents.forEach(student);
    }
    public static void printNamesAndActivities(){
        Consumer<Student> student = (stude)-> System.out.print(stude.getName());
        Consumer<Student> student1 = (stud)-> System.out.println(stud.getActivities());
        List<Student> listOfStudents = StudentDataBase.getAllStudents();
        listOfStudents.forEach(student.andThen(student1));
    }

    public static void main(String[] args) {
        Consumer<String> c2 = (s) -> System.out.println(s.toLowerCase());
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("");
        c2.accept("ISWar");
        printNames();
        printNamesAndActivities();
    }
}
