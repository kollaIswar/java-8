package com.java8.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {
    static Function<String,String> upperCase =  (name) -> name.toUpperCase();
    static Function<String,String> addSomeString =  (name) -> name.toUpperCase().concat("default");
    public static void main(String[] args){
        System.out.println("Result is : " + upperCase.apply("java8"));
        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("java8"));
    }
}
