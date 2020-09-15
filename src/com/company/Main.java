package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(12, 32, 41, 51, 66, 75, 85, 95, 123, 134, 145)
        );
        for (Integer element : list) {
            System.out.println(element);
        }
        Integer summa = 0;
        for (Integer element2 : list) {
            //summa = summa + element2;
            summa += element2;
        }
        System.out.println(summa);
        summa = list.stream().mapToInt(Integer::intValue).sum();
        list.stream().forEach(System.out::println);
        list.stream().forEach(item -> System.out.print(item + ", "));
        System.out.println();
        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(avg);
        Integer minNum = list.stream().mapToInt(Integer::intValue).min().orElse(0);
        System.out.println(minNum);
        Integer maxNum = list.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println(maxNum);

        List<Integer> List2 = list.stream().filter(item -> item < 20).collect(Collectors.toList());
        System.out.println(List2);

        Student ivanov = new Student("Ivanov", 25);
        Student petrov = new Student("Petrov", 42);
        Student galitskiy = new Student("Galitskiy", 95);
        Student frolov = new Student("Frolov", 100);
        Student slimakov = new Student("Slimakov", 75);
        Student davnitskiy = new Student("Davnitskiy", 80);
        Student prolisok = new Student("Prolisok", 70);
        Student bugay = new Student("Bugay", 55);

        List<Student>students = new ArrayList<>(Arrays.asList(ivanov,petrov,
                galitskiy,frolov,slimakov,davnitskiy,prolisok,bugay));

        List<Student> students2 = students.stream()
                .filter(student -> student.getMark() < 50).collect(Collectors.toList());

        List<Student> students3 = students.stream()
                .filter(student -> student.getMark() >= 50)
                .filter(student -> student.getMark() < 70)
                .collect(Collectors.toList());

        System.out.println(students2);
        System.out.println(students3);

                Student zadrot = students.stream().max(Comparator.comparing(Student::getMark)).orElse(null);
        System.out.println();

        double avgMarkStudent = students.stream().mapToInt(student -> student.getMark()).average().orElse(0);
        System.out.println();
        System.out.println(avgMarkStudent = students.stream().filter(student -> student.getMark() >= 90)
                .mapToInt(student -> student.getMark()).average().orElse(0));

        Integer avgMarkStudent1 = (int) students.stream().filter(student -> student.getMark()>=90)
                .mapToInt(student -> student.getMark()).count();

        System.out.println(avgMarkStudent1);

        Student lucky = students.stream()
                .filter(student -> student.getMark()<90)
                .max(Comparator.comparing(student -> student.getMark())).orElse(null);
        System.out.println(lucky);


        }

    }
