package my.finaleProject;

import my.finaleProject.Person;

/**
 * The {@code Student} class extends {@link Person} to represent a student
 * entity in the system. It inherits all personal attributes from {@code Person}
 * and adds student-specific academic information.
 * <p>
 * This class can be used to store and manage student details, including
 * identification, age, class group, courses, modules, assignments, exams, and
 * calculated results.
 * </p>
 *
 * * <b>Additional Fields:</b>
 * <ul>
 * <li>studentID – a unique identifier for the student</li>
 * <li>age – the student's age</li>
 * <li>classGroupCode – the code representing the student's class group</li>
 * <li>courseName – the name of the course the student is enrolled in</li>
 * <li>moduleName – the name of the module</li>
 * <li>assignment1, assignment2 – grades for assignments</li>
 * <li>exam – exam grade</li>
 * <li>results – calculated total results</li>
 * <li>assessmentID – identifier for the assessment record</li>
 * </ul>
 *
 * @author Tomasz Touma
 * @version 1.0
 * @since 1.8
 *
 * @see Person
 */
public class Student extends Person {

    private int studentID;
    private String age;
    private String classGroupCode;
    private String courseName;
    private String moduleName;
    private int assignment1;
    private int assignment2;
    private int exam;
    private int results;
    private int assessmentID;

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the classGroupCode
     */
    public String getClassGroupCode() {
        return classGroupCode;
    }

    /**
     * @param classGroupCode the classGroupCode to set
     */
    public void setClassGroupCode(String classGroupCode) {
        this.classGroupCode = classGroupCode;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the assignment1
     */
    public int getAssignment1() {
        return assignment1;
    }

    /**
     * @param assignment1 the assignment1 to set
     */
    public void setAssignment1(int assignment1) {
        this.assignment1 = assignment1;
    }

    /**
     * @return the assignment2
     */
    public int getAssignment2() {
        return assignment2;
    }

    /**
     * @param assignment2 the assignment2 to set
     */
    public void setAssignment2(int assignment2) {
        this.assignment2 = assignment2;
    }

    /**
     * @return the exam
     */
    public int getExam() {
        return exam;
    }

    /**
     * @param exam the exam to set
     */
    public void setExam(int exam) {
        this.exam = exam;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the results
     */
    public int getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(int results) {
        this.results = results;
    }

    public Student() {

    }

    public Student(String age, String classGroupCode, String firstName, String surname, String gender, String email,
            String ppsn, String address1, String address2, String addressCounty, String addressEircode, String mobileNumber, String dob, String courseName, int studentID) {
        this.age = age;
        this.classGroupCode = classGroupCode;
        super.firstName = firstName;
        super.surname = surname;
        super.gender = gender;
        super.email = email;
        super.ppsn = ppsn;
        super.address1 = address1;
        super.address2 = address2;
        super.addressCounty = addressCounty;
        super.addressEirCode = addressEircode;
        super.mobileNumber = mobileNumber;
        super.dob = dob;
        this.courseName = courseName;
        this.studentID = studentID;
    }

    public Student(int studentID, String surname, String ppsn, String gender, String classGroupCode, String courseName, String dob) {
        this.studentID = studentID;
        super.surname = surname;
        super.ppsn = ppsn;
        super.gender = gender;
        this.classGroupCode = classGroupCode;
        this.courseName = courseName;
        super.dob = dob;
    }

    public Student(int studentID) {
        this.studentID = studentID;
    }

    public Student(int assignment1, int assignment2, int exam, int results, String courseName, String moduleName, int studentID) {
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.exam = exam;
        this.results = results;
        this.courseName = courseName;
        this.moduleName = moduleName;
        this.studentID = studentID;
    }

    public Student(int assignment1, int assignment2, int exam) {
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.exam = exam;
    }

    /**
     * Calculates the average result of the student based on their two
     * assignments and exam grades. The result is stored in the {@code results}
     * field and also returned by the method.
     *
     * @return the calculated average result as an integer
     */
    public int calculateResult() {
        results = (assignment1 + assignment2 + exam) / 3;
        return results;
    }

    /**
     * Determines the final marking of the student based on their
     * {@code results} value. The marking scheme is as follows:
     * <ul>
     * <li>0–59: Fail</li>
     * <li>60–69: Pass</li>
     * <li>70–79: Merit</li>
     * <li>80–100: Distinction</li>
     * </ul>
     * If the {@code results} value is outside 0–100, it returns "Invalid
     * result".
     *
     * @return the marking as a String
     */
    public String calculateResult2() {
        String marking = "";
        if (results >= 0 && results <= 59) {
            marking = "Fail";
        } else if (results >= 60 && results <= 69) {
            marking = "Pass";
        } else if (results >= 70 && results <= 79) {
            marking = "Merit";
        } else if (results >= 80 && results <= 100) {
            marking = "Distinction";
        } else {
            marking = "Invalid result";
        }
        return marking;
    }

    /**
     * @return the assessmentID
     */
    public int getAssessmentID() {
        return assessmentID;
    }

    /**
     * @param assessmentID the assessmentID to set
     */
    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

}
