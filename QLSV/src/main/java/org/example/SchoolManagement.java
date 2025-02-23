package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SchoolManagement {
    public static void main(String[] args) {
        List<ClassRoom> classRooms = new ArrayList<>();

        // Tạo một số sinh viên mẫu và lớp học
        ClassRoom class1 = new ClassRoom("IT101");
        class1.addStudent(new Student("Anh", "Thư", new Date(), "Address 1", "IT101", 9.5, 8.5, 9.0, 9.5, 8.8));
        class1.addStudent(new Student("Thu", "Trang", new Date(), "Address 2", "IT101", 7.0, 6.5, 8.0, 6.0, 7.0));
        classRooms.add(class1);

        ClassRoom class2 = new ClassRoom("IT102");
        class2.addStudent(new Student("Quý", "Mùi", new Date(), "Address 3", "IT102", 5.5, 6.0, 5.0, 7.0, 5.5));
        class2.addStudent(new Student("Thị", "Lan", new Date(), "Address 4", "IT102", 3.0, 4.5, 3.5, 2.0, 3.0));
        classRooms.add(class2);

        // Hiển thị danh sách các lớp
        System.out.println("Danh sách các lớp:");
        for (int i = 0; i < classRooms.size(); i++) {
            System.out.println((i + 1) + ". " + classRooms.get(i).getClassName());
        }

        // Nhập mã lớp và hiển thị danh sách sinh viên và số lượng sinh viên theo rank
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã lớp: ");
        String classCode = scanner.nextLine();

        for (ClassRoom classRoom : classRooms) {
            if (classRoom.getClassName().equalsIgnoreCase(classCode)) {
                System.out.println("Danh sách sinh viên của lớp " + classCode + ":");
                for (Student student : classRoom.getStudents()) {
                    System.out.println("Sinh viên: " + student.getFirstName() + " " + student.getLastName() + ", Rank: " + student.getRank());
                }

                System.out.println("Tổng kết số người theo rank:");
                System.out.println("A: " + classRoom.getStudentCountByRank("A"));
                System.out.println("B: " + classRoom.getStudentCountByRank("B"));
                System.out.println("C: " + classRoom.getStudentCountByRank("C"));
                System.out.println("D: " + classRoom.getStudentCountByRank("D"));
                System.out.println("<D: " + classRoom.getStudentCountByRank("<D"));
                break;
            }
        }
    }
}
