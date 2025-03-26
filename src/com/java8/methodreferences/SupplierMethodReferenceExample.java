package com.java8.methodreferences;

import com.java8.data.Student;

import java.util.function.Supplier;

public class SupplierMethodReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
    }
}
