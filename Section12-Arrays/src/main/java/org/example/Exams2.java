package org.example;

public class Exams2 {
    public static void main(String[] args) {
        
        // Instructions for this workbook are on Learn the Part (Workbook 6.2).
        String[] students = {"Malfoy", "Crabbe", "Goyle", "Pansy", "Dean"};

        System.out.println("It's time to take your 5th years exams. Please, take your seats.\n");


        /*
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ", you will take seat " + i);
        }
        */

        int seatNumber = 0;
        for (String student : students) {
            System.out.println(student + ", you will take seat " + seatNumber);
            seatNumber++;
        }
        
        // Compare your result to what's on Learn the Part.

    }
}
