/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringmasterylab;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO {

    private Scanner sc = new Scanner(System.in);

    public void print(String msg) {
        System.out.println(msg);
    }

    public String readString(String prompt) {
        Scanner mySc = new Scanner(System.in);
        System.out.println(prompt);
        return mySc.nextLine();
    }

    public int readInt(String prompt) {
        boolean badInput;
        int result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextInt();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);
        return result;
    }

    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }

    public long readLong(String prompt) {
        boolean badInput;
        long result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextLong();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);

        return result;
    }

    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    public float readFloat(String prompt) {
        boolean badInput;
        float result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextFloat();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);

        return result;
    }

    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    public double readDouble(String prompt) {
        boolean badInput;
        double result = 0;
        do {
            try {
                System.out.println(prompt);
                result = sc.nextDouble();
                badInput = false;
            } catch (InputMismatchException ime) {
                badInput = true;
                sc.nextLine();
            }
        } while (badInput);

        return result;
    }

    public double readDouble(String prompt, double min, double max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    public String readYorN(String prompt) {
        Scanner newSc = new Scanner(System.in);
        boolean finished = false;
        String answer = "";
        while (!finished) {

            System.out.print(prompt);
            answer = newSc.nextLine();
            if (answer.equalsIgnoreCase("Y") || (answer.equalsIgnoreCase("N"))) {

                finished = true;
                return answer;

            } else {
                System.out.print("Please enter only \"y\" or \"n\": ");

            }

        }
        return answer;
    }

    public String readStateOHMIPAIN(String prompt) {
        Scanner stateSc = new Scanner(System.in);
        String answer = "";
        boolean fin = false;

        while (!fin) {
            answer = sc.nextLine();
            if ((answer.equalsIgnoreCase("OH")) || (answer.equalsIgnoreCase("MI")) || (answer.equalsIgnoreCase("PA")) || (answer.equalsIgnoreCase("IN"))) {

                fin = true;
            } else {
                System.out.println(prompt);
                fin = false;

            }
        }
        return answer;

    }

    public String readDateMMddyyyy(String prompt) {
        Scanner scanner = new Scanner(System.in);

//        final DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
//        final LocalDate dt = dtf.parseLocalDate(yourinput);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        boolean over = false;
        LocalDate date = null;
        String answer;
        String result;
        while (!over) {

            System.out.println(prompt);

            answer = scanner.nextLine();
            if (answer.equals("")) {
                over = true;

            } else {

                try {

                    date = LocalDate.parse(answer, formatter);
                    over = true;
                } catch (NullPointerException n) {
                    over = true;
                } catch (DateTimeParseException e) {
                    over = false;
                }
            }
        }
        if (date == null) {
            result = "";
        } else {
            result = date.toString();
            String[] parts = result.split("-");
            result = parts[1] + parts[2] + parts[0];

        }
        return result;
    }

}
//this is a copy of Ilyas ConsoleIO. This lab was about overloading methods, apparently!
