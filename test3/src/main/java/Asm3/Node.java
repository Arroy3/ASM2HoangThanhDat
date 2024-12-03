package Asm3;

public class Node {
    private int id;
    private String name;
    private double marks;
    private String rank; // Thêm trường để lưu xếp hạng
    Node next;

    public Node(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = determineRank(marks); // Xác định xếp hạng khi tạo đối tượng
        this.next = null;
    }

    // Phương thức xác định xếp hạng dựa trên điểm số
    private String determineRank(double marks) {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = determineRank(marks); // Cập nhật xếp hạng nếu điểm thay đổi
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}
