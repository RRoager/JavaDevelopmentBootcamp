package org.example;

public class Exams1 {
    public static void main(String[] args) {

        // Instructions for this workbook are on Learn the Part (Workbook 6.1).
        String[] seats = {"Harry", "Neville", "Ron", "Hermione", "Seamus"};

        System.out.println("It's time to take your 5th year exams. Please, take your seats.\n");

        int seatNumber = 0;

        for (String seat : seats) {
            System.out.println(seat + ", you will take seat " + seatNumber);
            seatNumber++;
        }

        // Compare your result to what's on Learn the Part.

    }
}
