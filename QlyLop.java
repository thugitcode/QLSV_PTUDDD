import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QlyLop {
    class Student {
        String firstName;
        String lastName;
        String birthdate;
        String address;
        String studentClass;
        double oopGrade;
        double pmGrade;
        double mlGrade;
        double dbGrade;
        double mobileDevGrade;

        public Student(String firstName, String lastName, String birthdate, String address, String studentClass,
                       double oopGrade, double pmGrade, double mlGrade, double dbGrade, double mobileDevGrade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthdate = birthdate;
            this.address = address;
            this.studentClass = studentClass;
            this.oopGrade = oopGrade;
            this.pmGrade = pmGrade;
            this.mlGrade = mlGrade;
            this.dbGrade = dbGrade;
            this.mobileDevGrade = mobileDevGrade;
        }

        public double getAverageGrade() {
            return (oopGrade + pmGrade + mlGrade + dbGrade + mobileDevGrade) / 5;
        }

        public String getRank() {
            double avgGrade = getAverageGrade();
            if (avgGrade >= 8.5) return "A";
            else if (avgGrade >= 7) return "B";
            else if (avgGrade >= 5.5) return "C";
            else if (avgGrade >= 4) return "D";
            else return "<D";
        }
    }

    class Class {
        String className;
        List<Student> students;

        public Class(String className) {
            this.className = className;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public String getClassName() {
            return className;
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

        public int[] getGradeRanks() {
            int[] ranks = new int[5];

            for (Student student : students) {
                double avgGrade = student.getAverageGrade();

                if (avgGrade >= 8.5) ranks[0]++;
                else if (avgGrade >= 7) ranks[1]++;
                else if (avgGrade >= 5.5) ranks[2]++;
                else if (avgGrade >= 4) ranks[3]++;
                else ranks[4]++;
            }

            return ranks;
        }

        public void printStudentList() {
            System.out.println("Class: " + className);
            for (Student student : students) {
                System.out.println(student.firstName + " " + student.lastName);
            }

            int[] ranks = getGradeRanks();
            System.out.println("A: " + ranks[0]);
            System.out.println("B: " + ranks[1]);
            System.out.println("C: " + ranks[2]);
            System.out.println("D: " + ranks[3]);
            System.out.println("<D: " + ranks[4]);
        }
    }

    public static void main(String[] args) {
        QlyLop qlyLop = new QlyLop();
        List<Class> classRooms = new ArrayList<>();
        Class classA = qlyLop.new Class("CNTT1");
        Class classB = qlyLop.new Class("CNTT2");

        classA.addStudent(qlyLop.new Student("Nguyen", "Anh", "2001-01-01", "Hanoi", "CNTT1", 9.0, 8.5, 9.0, 8.0, 8.5));
        classA.addStudent(qlyLop.new Student("Tran", "Binh", "2001-02-02", "Hanoi", "CNTT1", 7.0, 7.5, 7.0, 6.5, 7.0));
        classA.addStudent(qlyLop.new Student("Le", "Cuong", "2001-03-03", "Hanoi", "CNTT1", 6.0, 5.5, 6.0, 5.0, 5.5));
        classA.addStudent(qlyLop.new Student("Pham", "Dung", "2001-04-04", "Hanoi", "CNTT1", 4.0, 4.5, 4.0, 3.5, 4.0));
        classA.addStudent(qlyLop.new Student("Do", "Hue", "2001-05-05", "Hanoi", "CNTT1", 9.0, 8.5, 9.0, 9.5, 8.0));

        classB.addStudent(qlyLop.new Student("Bui", "Khanh", "2001-06-06", "Hanoi", "CNTT2", 8.5, 8.0, 8.5, 8.0, 8.0));
        classB.addStudent(qlyLop.new Student("Nguyen", "Linh", "2001-07-07", "Hanoi", "CNTT2", 7.5, 7.0, 7.5, 7.0, 7.0));
        classB.addStudent(qlyLop.new Student("Hoang", "Minh", "2001-08-08", "Hanoi", "CNTT2", 6.5, 6.0, 6.5, 6.0, 6.0));
        classB.addStudent(qlyLop.new Student("Pham", "Nhung", "2001-09-09", "Hanoi", "CNTT2", 5.0, 5.5, 5.0, 5.5, 5.5));
        classB.addStudent(qlyLop.new Student("Le", "Oanh", "2001-10-10", "Hanoi", "CNTT2", 4.0, 3.5, 4.0, 3.5, 3.0));

        classRooms.add(classA);
        classRooms.add(classB);

        // Display the list of classes
        System.out.println("Danh sach cac lop:");
        for (int i = 0; i < classRooms.size(); i++) {
            System.out.println((i + 1) + ". " + classRooms.get(i).getClassName());
        }

        // Input class code and display student list and rank counts
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma lop: ");
        String classCode = scanner.nextLine();

        for (Class classRoom : classRooms) {
            if (classRoom.getClassName().equalsIgnoreCase(classCode)) {
                System.out.println("Danh sach sinh vien cua lop " + classCode + ":");
                for (Student student : classRoom.getStudents()) {
                    System.out.println(student.firstName + " " + student.lastName + " : " + student.getRank());
                }

                System.out.println("Tong so sinh vien theo rank:");
                System.out.println("A: " + classRoom.getStudentCountByRank("A"));
                System.out.println("B: " + classRoom.getStudentCountByRank("B"));
                System.out.println("C: " + classRoom.getStudentCountByRank("C"));
                System.out.println("D: " + classRoom.getStudentCountByRank("D"));
                System.out.println("<D: " + classRoom.getStudentCountByRank("<D"));
                break;
            }
        }

        scanner.close();
    }
}