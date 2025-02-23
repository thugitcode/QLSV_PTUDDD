package org.example;

import java.util.Date;

public class Student {
    private final String firstName;
    private final String lastName;
    private final Date birthdate;
    private final String address;
    private final String className;
    private final double oopGrade;
    private final double projectManagementGrade;
    private final double machineLearningGrade;
    private final double databaseGrade;
    private final double mobileAppDevelopmentGrade;

    public Student(String firstName, String lastName, Date birthdate, String address, String className,
                   double oopGrade, double projectManagementGrade, double machineLearningGrade,
                   double databaseGrade, double mobileAppDevelopmentGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.oopGrade = oopGrade;
        this.projectManagementGrade = projectManagementGrade;
        this.machineLearningGrade = machineLearningGrade;
        this.databaseGrade = databaseGrade;
        this.mobileAppDevelopmentGrade = mobileAppDevelopmentGrade;
    }

    // Getter methods
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthdate() { return birthdate; }
    public String getAddress() { return address; }
    public String getClassName() { return className; }
    public double getOopGrade() { return oopGrade; }
    public double getProjectManagementGrade() { return projectManagementGrade; }
    public double getMachineLearningGrade() { return machineLearningGrade; }
    public double getDatabaseGrade() { return databaseGrade; }
    public double getMobileAppDevelopmentGrade() { return mobileAppDevelopmentGrade; }

    public double getAverageGrade() {
        return (oopGrade + projectManagementGrade + machineLearningGrade + databaseGrade + mobileAppDevelopmentGrade) / 5.0;
    }

    public String getRank() {
        double avg = getAverageGrade();
        if (avg >= 9.0) return "A";
        else if (avg >= 7.0) return "B";
        else if (avg >= 5.0) return "C";
        else if (avg >= 3.0) return "D";
        else return "<D";
    }
}
