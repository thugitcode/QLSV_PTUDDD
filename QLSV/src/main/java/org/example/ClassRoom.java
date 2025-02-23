package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private final String className;
    private final List<Student> students;

    public ClassRoom(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCountByRank(String rank) {
        int count = 0;
        for (Student student : students) {
            if (student.getRank().equals(rank)) {
                count++;
            }
        }
        return count;
    }

    public String getClassName() {
        return className;
    }
}
