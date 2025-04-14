package com.java8.streams.intermediate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamIntermediateExample {
    public static void main(String[] args){
        List<Student> studentList = StudentDataBase.getAllStudents();
        /*
          1. map(): Transforms elements in the stream.
        */
        List<String> namesUpperCaseString = studentList.stream()  // Stream<Student>
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String>
                .collect(toList()); // returns List // terminal operation

        System.out.println(namesUpperCaseString);

        List<Integer> numbers = List.of(1,2,3);
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println); // Output: 1, 4, 9

         /*
          2. flatMap(): used to flatten nested collections or arrays into a single stream.
         */

        List<String> activities = studentList.stream()  // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>>
                .collect(toList()); // returns List // terminal operation

        System.out.println(activities);

        /*
          3. distinct(): return stream with unique elements
        */

        List<String> activitiess = studentList.stream()  // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>>
                .distinct() //eliminate duplicates
                .collect(toList()); // returns List // terminal operation
        System.out.println(activitiess);

        /*
         4. sorted(): Sorts the elements in natural or custom order
        */
        List<String> names = Arrays.asList("Charlie", "Bob", "Alice");
        names.stream()
                .sorted()
                .forEach(System.out::println); // Output: Alice, Bob, Charlie

        /*
         5. skip(): Skips the first few elements in the stream
        */
        List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5);
        numberss.stream()
                .skip(2)
                .forEach(System.out::println); // Output: 3, 4, 5
        /*
         6. filter(): Non-matching elements are excluded
        */
        List<String> name = Arrays.asList("Alice", "Bob", "Charlie");
        name.stream()
                .filter(nam -> nam.startsWith("A"))
                .forEach(System.out::println); // Output: Alice

        /*
         7. peek(): method is mainly used for debugging purposes
        */
        List<Integer> numberes = Arrays.asList(1, 2, 3, 4, 5);
        numberes.stream()
                .peek(n -> System.out.println("Before filtering: " + n))
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

    }
}
