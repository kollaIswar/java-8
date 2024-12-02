package com.java8.streams;

import com.java8.model.Employee;
import com.java8.model.EmployeeDataBase;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsApiTerminalMethods {

    public static void main (String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        /*1. forEach() */
        //employees.forEach(e -> System.out.println(e.getDept() +":" + e.getName()));
        //employees.stream().forEach(System.out::println);

        /*2. collect(Collectors.toList()) -> it is terminal stream operation produces the output
              convert to list -> result list can be modifiable
        */
        List<Employee> collectToList = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                        .collect(Collectors.toList());
       // collectToList.forEach(System.out::println);

        //.collect (Collectors.toSet)
        Set<Employee> collectToSet = employees.stream()
                .filter(e ->e.getDept().equals("Development")
                ).collect(Collectors.toSet());
        //collectToSet.forEach(System.out::println);

        //.collect (Collectors.toMap) -> fetch employee attributes as key value pairs
        Map<Integer, String> collectToMap = employees.stream()
                .filter(e -> {
                    return (e.getDept().equals("Development")
                    && e.getSalary() > 85000);
                }).collect(Collectors.toMap(Employee::getId,Employee::getName));
        //System.out.println(collectToMap);

        /* .collect(Collectors.toCollection()) ->  If we want to use a custom implementation,
            and it provided collection of our choice
        */
        LinkedList<Employee> collectToCollection = employees.stream()
                .filter(e ->e.getDept().equals("Marketing")
                ).collect(Collectors.toCollection(LinkedList::new));
        //collectToCollection.forEach(System.out::println);

        /*3. toList() -> java 16 introduces this method in directly in stream,
              the collection returned is un modifiable
         */
        List<Employee> streamToList = employees.stream()
                .filter(e -> e.getDept().equals("Sales"))
                .toList();
        //streamToList.forEach(System.out::println);

        /*4. count() -> return number of elements in collection */
        long count = employees.stream().count();
        //System.out.println(count);

        /*5. reduce() -> combines elements in a stream into single value */
        double result = employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .reduce(0, Double::sum);
        //System.out.println(result);

        /*6. anyMatch() -> checks if an element matches a given condition
             allMatch() -> checks all elements satisfy the given condition
             noneMatch()-> checks if no elements in the stream match given predicate
         */
        boolean value = employees.stream().anyMatch(e -> e.getDept().equals("Sales1"));
        //System.out.println(value);
        boolean value1 = employees.stream().allMatch(e -> e.getDept() != null);
        //System.out.println(value1);
        boolean value2 = employees.stream().noneMatch(e -> e.getDept() == null);
        //System.out.println(value2);

        /*7. findAny() -> returns any one element from stream, returns Optional object */
        Optional<Employee> findAny= employees.stream().findAny();
        //System.out.println(findAny.get());

        /*8. findFirst() ->  retrieves the first element in the stream */
        Optional<Employee> findFirst= employees.stream()
                .filter(emp -> emp.getDept().equals("Sales"))
                .findFirst();
        //System.out.println(findFirst.get());

        /*9. min() ->  returns the smallest element from the stream based on the specified comparator
             max() ->  returns the largest element from the stream based on the specified comparator
        */
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);
        Integer var = list.stream().min(Integer::compare).get();
        //System.out.println(var);
        Integer var1 = list.stream().max(Integer::compare).get();
        //System.out.println(var1);
















    }

}
