 package Asm3;

public class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    // Kiểm tra nếu stack rỗng
    public boolean isEmpty() {
        return top == null;
    }

    // Thêm sinh viên vào stack
    public void push(int id, String name, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Marks must be between 0 and 10. Please try again.");
            return;
        }

        Node newNode = new Node(id, name, marks);
        newNode.next = top;
        top = newNode;
        System.out.println("Student added: " + newNode);
    }

    // Xóa sinh viên khỏi stack theo ID
    public boolean deleteStudent(int id) {
        if (isEmpty()) {
            System.out.println("No students to delete.");
            return false;
        }

        // Nếu sinh viên cần xóa là sinh viên đầu tiên
        if (top.getId() == id) {
            System.out.println("Student deleted: " + top);
            top = top.next;  // Xóa sinh viên đầu tiên
            return true;
        }

        // Tìm và xóa sinh viên trong danh sách
        Node current = top;
        while (current.next != null) {
            if (current.next.getId() == id) {
                System.out.println("Student deleted: " + current.next);
                current.next = current.next.next;  // Xóa sinh viên theo ID
                return true;
            }
            current = current.next;
        }

        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    // Tìm kiếm sinh viên theo ID
    public Node search(int id) {
        Node current = top;
        while (current != null) {
            if (current.getId() == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Sửa thông tin sinh viên theo ID
    public boolean editStudent(int id, String newName, double newMarks) {
        Node student = search(id);
        if (student != null) {
            student.setName(newName);
            student.setMarks(newMarks);
            return true;
        }
        return false;
    }

    // Hiển thị tất cả sinh viên
    public void display() {
        if (isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // Sắp xếp sinh viên theo điểm bằng Selection Sort
    public void selectionSortByMarks() {
        if (top == null || top.next == null) {
            System.out.println("No students or only one student to sort.");
            return;
        }

        for (Node current = top; current != null; current = current.next) {
            Node minNode = current;
            for (Node next = current.next; next != null; next = next.next) {
                if (next.getMarks() < minNode.getMarks()) {
                    minNode = next;
                }
            }

            if (minNode != current) {
                // Hoán đổi thông tin giữa current và minNode
                int tempId = current.getId();
                String tempName = current.getName();
                double tempMarks = current.getMarks();

                current.setId(minNode.getId());
                current.setName(minNode.getName());
                current.setMarks(minNode.getMarks());

                minNode.setId(tempId);
                minNode.setName(tempName);
                minNode.setMarks(tempMarks);
            }
        }

        System.out.println("Students sorted by marks.");
        display();  // Hiển thị lại danh sách sinh viên đã được sắp xếp
    }
}

     