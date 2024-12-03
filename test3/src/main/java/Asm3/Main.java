package Asm3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack studentStack = new Stack();  // Tạo stack quản lý sinh viên
        boolean running = true;

        while (running) {
            // Hiển thị menu
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng mới sau khi nhập số
            
            switch (option) {
                case 1:
                    // Thêm sinh viên
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Đọc dòng mới sau khi nhập ID
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks (0-10): ");
                    double marks = scanner.nextDouble();
                    studentStack.push(id, name, marks);
                    break;
                
                case 2:
                    // Sửa sinh viên
                    System.out.print("Enter Student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine();  // Đọc dòng mới sau khi nhập ID
                    System.out.print("Enter new Student Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks (0-10): ");
                    double newMarks = scanner.nextDouble();
                    if (studentStack.editStudent(editId, newName, newMarks)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student with ID " + editId + " not found.");
                    }
                    break;
                
                case 3:
                    // Xóa sinh viên
                    System.out.print("Enter ID of student to delete: ");
                    int deleteId = scanner.nextInt();
                    if (studentStack.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student with ID " + deleteId + " not found.");
                    }
                    break;
                
                case 4:
                    // Tìm kiếm sinh viên theo ID
                    System.out.print("Enter ID of student to search: ");
                    int searchId = scanner.nextInt();
                    Node foundStudent = studentStack.search(searchId);
                    if (foundStudent != null) {
                        System.out.println("Found student: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;
                
                case 5:
                    // Hiển thị tất cả sinh viên
                    System.out.println("Displaying all students:");
                    studentStack.display();
                    break;
                
                case 6:
                    // Sắp xếp sinh viên theo điểm
                    studentStack.selectionSortByMarks();
                    break;
                
                case 0:
                    // Thoát chương trình
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                
                default:
                    System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        scanner.close();
    }
}
