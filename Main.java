import java.util.*;

class Student {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String address;
    private String className;
    private Map<String, Double> scores;

    public Student(String firstName, String lastName, String birthDate, String address, String className, Map<String, Double> scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.className = className;
        this.scores = scores;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getClassName() {
        return className;
    }

    public double getAverageScore() {
        return scores.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getGradeRank() {
        double avg = getAverageScore();
        if (avg >= 8.5) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4.0) return "D";
        else return "<D";
    }

    public void displayInfo() {
        System.out.printf("%-20s %-10s %-10.2f\n", getFullName(), getGradeRank(), getAverageScore());
    }
}

class Classroom {
    private String classId;
    private List<Student> students;

    public Classroom(String classId) {
        this.classId = classId;
        this.students = new ArrayList<>();
    }

    public String getClassId() {
        return classId;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Danh sách sinh viên lớp " + classId + ":");
        System.out.printf("%-20s %-10s %-10s\n", "Họ và Tên", "Xếp Loại", "Điểm TB");
        System.out.println("----------------------------------------");
        for (Student student : students) {
            student.displayInfo();
        }
    }

    public void summarizeRanks() {
        Map<String, Integer> rankCount = new HashMap<>();
        rankCount.put("A", 0);
        rankCount.put("B", 0);
        rankCount.put("C", 0);
        rankCount.put("D", 0);
        rankCount.put("<D", 0);

        for (Student student : students) {
            String rank = student.getGradeRank();
            rankCount.put(rank, rankCount.get(rank) + 1);
        }

        System.out.println("\nTổng kết xếp loại:");
        for (String rank : rankCount.keySet()) {
            System.out.println("Rank " + rank + ": " + rankCount.get(rank) + " sinh viên");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Classroom> classList = new ArrayList<>();

        // Tạo lớp học
        Classroom classCNTT1 = new Classroom("CNTT1");
        Classroom classCNTT2 = new Classroom("CNTT2");

        // Tạo sinh viên và thêm vào lớp
        classCNTT1.addStudent(new Student("Nguyen", "An", "2002-05-10", "Hanoi", "CNTT1",
                Map.of("OOP", 9.0, "QLDA", 8.5, "Machine Learning", 8.0, "Database", 9.0, "Mobile App", 8.5)));

        classCNTT1.addStudent(new Student("Tran", "Binh", "2003-06-15", "HCM", "CNTT1",
                Map.of("OOP", 7.0, "QLDA", 7.5, "Machine Learning", 7.0, "Database", 6.5, "Mobile App", 6.0)));

        classCNTT2.addStudent(new Student("Phuong", "", "2002-07-20", "Danang", "CNTT2",
                Map.of("OOP", 6.0, "QLDA", 8.5, "Machine Learning", 9.0, "Database", 9.5, "Mobile App", 9.0)));

        classCNTT2.addStudent(new Student("Linh", "Chi", "2003-08-30", "Hanoi", "CNTT2",
                Map.of("OOP", 4.0, "QLDA", 4.5, "Machine Learning", 3.5, "Database", 3.0, "Mobile App", 2.5)));

        classList.add(classCNTT1);
        classList.add(classCNTT2);

        // Chương trình chính
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nDanh sách lớp học:");
            for (Classroom cls : classList) {
                System.out.println("- " + cls.getClassId());
            }
            System.out.print("\nNhập lớp để xem thông tin (hoặc 'exit' để thoát): ");
            String inputClassId = scanner.nextLine().trim();

            if (inputClassId.equalsIgnoreCase("exit")) break;

            Classroom selectedClass = classList.stream()
                    .filter(cls -> cls.getClassId().equalsIgnoreCase(inputClassId))
                    .findFirst()
                    .orElse(null);

            if (selectedClass != null) {
                selectedClass.displayStudents();
                selectedClass.summarizeRanks();
            } else {
                System.out.println("Lớp không tồn tại. Vui lòng nhập lại.");
            }
        }
        scanner.close();
    }
}