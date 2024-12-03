package Asm2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List studentList = new List();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("0. Exit");

            int choice = -1;
            while (choice < 0 || choice > 6) {
                System.out.print("Choose an option: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 6) {
                        System.out.println("Invalid option! Please choose a number between 0 and 6.");
                    }
                } catch (NumberFormatException e) { 
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }

            switch (choice) {
                case 1:
                    int id = validatePositiveInteger(scanner, "ID");

                    String name;
                    // Validate Name input (only letters)
                    while (true) {
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        if (name.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid Name! Please enter only letters.");
                        }
                    }

                    double marks = validateDoubleInRange(scanner, 0, 10, "Marks");

                    studentList.addStudent(id, name, marks);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter ID of student to edit: ");
                    int editId = validatePositiveInteger(scanner, "ID");

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();

                    double newMarks = validateDoubleInRange(scanner, 0, 10, "Marks");

                    if (studentList.editStudent(editId, newName, newMarks)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = validatePositiveInteger(scanner, "ID");

                    if (studentList.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID of student to search: ");
                    int searchId = validatePositiveInteger(scanner, "ID");

                    Node student = studentList.searchStudentById(searchId);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    studentList.displayStudents();
                    break;

                case 6:
                    studentList.sortStudentsByMarks();
                    System.out.println("Students sorted by marks.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static int validatePositiveInteger(Scanner scanner, String fieldName) {
        int value = -1;
        while (value <= 0) {
            System.out.print("Enter " + fieldName + ": ");
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    System.out.println("Invalid " + fieldName + "! Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for " + fieldName + ".");
            }
        }
        return value;
    }

    private static double validateDoubleInRange(Scanner scanner, double min, double max, String fieldName) {
        double value = -1;
        while (value < min || value > max) {
            System.out.print("Enter " + fieldName + ": "); // Hiển thị "Enter Marks: "
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value < min || value > max) {
                    System.out.println(fieldName + " must be between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for " + fieldName + ".");
            }
        }
        return value;
    }
}
