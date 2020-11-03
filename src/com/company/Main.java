package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static GuitarString[] guitar = new GuitarString[6]; // Initializing array of guitar strings
    private static Map<Integer, String> notes = new HashMap<>(); // Initializing hashmap for notes

    public static void main(String[] args) {

        guitar[0] = new GuitarString("E1", 7); // putting each string into the array (guitar) E A D G B E
        guitar[1] = new GuitarString("A", 0);
        guitar[2] = new GuitarString("D", 5);
        guitar[3] = new GuitarString("G", 10);
        guitar[4] = new GuitarString("B", 2);
        guitar[5] = new GuitarString("E2", 7);

        notes.put(0, "A"); // assigning each note to its corresponding number into the hashmap (notes) 0-11 A-G#
        notes.put(1, "A#");
        notes.put(2, "B");
        notes.put(3, "C");
        notes.put(4, "C#");
        notes.put(5, "D");
        notes.put(6, "D#");
        notes.put(7, "E");
        notes.put(8, "F");
        notes.put(9, "F#");
        notes.put(10, "G");
        notes.put(11, "G#");

        Scanner scanner = new Scanner(System.in); // creating scanner

        while(true) { // Loop for taking input
            System.out.println("Enter Guitar String Number. Enter 0 to quit"); // Prompting user for input
            int stringNum; // initializing variables
            int fret;
            if(scanner.hasNextInt()) { // checking if user put in invalid input such as words
                stringNum = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Sorry, I need you to put a number inside little ole me");
                continue;
            }
            if(stringNum == 0) { // how to quit the program. By entering 0.
                System.out.println("I hope you enjoyed the app!");
                break;
            } else if(stringNum > 6 || stringNum < 0) { // Range Verification
                System.out.println("There are only six strings on a guitar silly. Enter number between 1-6");
                continue;
            }
            System.out.println("Now enter the Fret number");
            if(scanner.hasNextInt()) {
                fret = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Let's try this again. I need only numbers inside little ole me.");
                continue;
            }
            if(fret > 17 || fret < 0) { // Range Verification
                System.out.println("There are only 17 Frets on a guitar silly goose. Enter number between 1-17.");
                continue;
            }
            String note = findNote(stringNum, fret);
            System.out.println("The note on Guitar String " + stringNum + ", Fret " + fret + " is " + note + ".");
            System.out.println();
        }
    }

    public static String findNote(int stringNum, int fret) { // method takes the guitar string and fret desired as parameters. counts up from base number by the fret number.
        int note = guitar[stringNum-1].getBaseTuning() + fret;
        if(note > 11) {
            note %= 12;
        }
        return notes.get(note); // return number corresponding to a note. 0-11 A-G#
    }
}
