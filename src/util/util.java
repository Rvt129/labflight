/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author 84933
 */
public class util {

    public static String getNumber(String message, String mess, String err) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println(mess);
                    continue;
                } else if (input.length() == 5 && input.startsWith("F")) {
                    if (input.substring(1).matches("[0-9][0-9][0-9][0-9]")) {
                        return input;
                    }
                }

            } catch (Exception e) {
                System.out.println(err);
            }

        }
    }

    public static String getString(String message, String err, int op) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine();
                input = input.trim();
                if (op == 1) {
                    if (input.isEmpty()) {
                        System.out.println("You have to input a string");
                    } else {
                        break;
                    }
                } else if (op == 2) {
                    input = null;
                    break;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        }
        return input;
    }

    public static int getInt(String mess, int min, int max) {
        int number = 0;
        boolean isValid = false;
        Scanner scanner = new Scanner(System.in);
        String test = null;
        do {
            try {
                System.out.println(mess);
                test = scanner.nextLine();
                test = test.trim();
                if (test.equals("")) {
                    number = 0;
                } else {
                    number = Integer.parseInt(test);
                }

                if (number == 0) {
                    throw new Exception();
                }

                if (number >= min && number <= max) {
                    isValid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!isValid);

        return number;
    }

    public static String getDate(String message, int op) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime check = null;
        String input = "";

        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine().trim();
                if (input.isEmpty() && op == 2) {
                    input = null;
                    break;
                } else if (input.isEmpty()) {
                    continue;
                }
                check = LocalDateTime.parse(input, formatter);
                if (check.isBefore(now)) {
                    System.out.println("Please input a date after the current date!");
                }
                return check.format(formatter);

            } catch (DateTimeParseException e) {
                System.err.println("Please input a valid date !!!");
            }
        }
        return input;
    }

    public static String getDateGo(String message, int op) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        LocalDate check = null;
        String input = "";

        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine().trim();
                if (input.isEmpty() && op == 2) {
                    input = null;
                    break;
                } else if (input.isEmpty()) {
                    continue;
                }
                check = LocalDate.parse(input, formatter);
                if (check.isBefore(now)) {
                    System.out.println("Please input a date after the current date!");
                }
                return check.format(formatter);

            } catch (DateTimeParseException e) {
                System.err.println("Please input a valid date !!!");
            }
        }
        return input;
    }

    public static String getRegex(String message, String regex) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine();
                input = input.trim();
                if (input.isEmpty()) {
                    continue;
                } else {
                    if (input.matches(regex)) {
                        return input;
                    }
                }

            } catch (Exception e) {
            }
        }
    }
}
