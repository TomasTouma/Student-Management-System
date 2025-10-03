/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.finaleProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import javax.swing.JOptionPane;
import static my.val.ValidationAndCalculationMethods.*;

/**
 * StudentForm class
 *
 * Purpose: This JFrame provides a user interface for viewing and managing
 * details of a single student. It allows displaying, updating, and interacting
 * with student information stored in the database.
 *
 * Main Responsibilities: 1. Load and display student personal information
 * including: - First name, surname, email, phone number, PPSN, gender, date of
 * birth, age - Address details: line 1, line 2, county, eircode - Course and
 * class group information 2. Calculate the age of the student based on their
 * date of birth. 3. Populate course selection dropdowns (JComboBox) dynamically
 * from the database. 4. Handle database operations to fetch student details
 * using studentID.
 *
 * Key Features: - Database connectivity using JDBC for MySQL. - Uses
 * `JDateChooser` for selecting/displaying the date of birth. - Calculates and
 * displays age automatically. - Dynamic combo boxes for courses and class
 * groups. - Handles parsing and formatting of dates from the database. -
 * Displays a message if a student with the given ID does not exist.
 *
 * Dependencies: - Relies on a MySQL database named 'finaleprojectdb'. -
 * Requires the JDBC driver for database connectivity. - Uses standard Swing
 * components and JDateChooser.
 *
 * @author Tomasz Touma
 * @version 1.0
 * @since 1.8
 */
public class StudentForm extends javax.swing.JFrame {

    private int studentID;

    Student s;
    String url = "jdbc:mysql://127.0.0.1:3306/";
    //database name
    String dbName = "finaleprojectdb";
    //not needed for now

    String userName = "root";
    //password for connecting to local host
    String password = "root";
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form StudentForm
     */
    public StudentForm() {
        initComponents();

    }

    public StudentForm(int studentID) {
        initComponents();
        this.studentID = studentID;
        jTextFieldStudentID.setText(String.valueOf(studentID));
        setJComboBoxCourseName();
        loadStudentDetails();
        jTextFieldAge.setText(Integer.toString(calculateAge(jDateChooser.getDate())));

    }

    /**
     * calculateAge ---------------- Calculates the age of a student based on
     * their birth date.
     *
     * @param birthDate The date of birth of the student.
     * @return The age in years. Returns 0 if birthDate is null.
     */
    private int calculateAge(java.util.Date birthDate) {
        if (birthDate != null) {

            LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthLocalDate, currentDate);
            return period.getYears();
        } else {

            return 0;
        }
    }

    /**
     * setJComboBoxCourseName ---------------- Loads all course names from the
     * database and populates the JComboBox for course selection.
     */
    private void setJComboBoxCourseName() {
        try {

            Connection con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            PreparedStatement prest = null;

            String sql = "SELECT course_name FROM course";

            prest = con.prepareStatement(sql);

            ResultSet rs = prest.executeQuery();

            while (rs.next()) {
                jComboBoxCourseName.addItem(rs.getString(1));
            }

        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    }

    /**
     * loadStudentDetails ---------------- Loads the student details from the
     * database using studentID and populates the corresponding UI components.
     *
     * Populates fields such as: - First name, surname, email, phone number,
     * PPSN, gender - Date of birth, age - Address (line 1, line 2, county,
     * eircode) - Course name and class group
     *
     * Displays a JOptionPane message if no student is found.
     */
    private void loadStudentDetails() {
        try {

            Connection con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            String sql = "SELECT student.first_name,student.surname,student.email,student.phone_number,student.ppsn,student.gender,student.date_of_birth,student.age,"
                    + "student.address_line_1,student.address_line_2,student.county,student.eircode,class_group.course_name, student.class_group_code"
                    + " FROM student INNER JOIN class_group ON class_group.class_group_code=student.class_group_code WHERE student.student_id=?";

            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, studentID);

            ResultSet rs = prest.executeQuery();

            if (rs.next()) {

                jTextFieldFirstName.setText(rs.getString("first_name"));
                jTextFieldSurname.setText(rs.getString("surname"));
                jTextFieldEmail.setText(rs.getString("email"));
                jTextFieldPhoneNumber.setText(rs.getString("phone_number"));
                jTextFieldPpsn.setText(rs.getString("ppsn"));
                jComboBoxGender.setSelectedItem(rs.getString("gender"));
                String dob = rs.getString("date_of_birth");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format as needed
                try {
                    java.util.Date date = sdf.parse(dob);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    jDateChooser.setDate(date); // Assuming you are using JDateChooser
                } catch (ParseException e) {
                    e.printStackTrace(); // Handle the possible parsing error
                }
                jTextFieldAge.setText(rs.getInt("age") + "");
                jTextFieldAddress1.setText(rs.getString("address_line_1"));
                jTextFieldAddress2.setText(rs.getString("address_line_2"));
                jTextFieldCounty.setText(rs.getString("county"));
                jTextFieldEircode.setText(rs.getString("eircode"));
                jComboBoxCourseName.setSelectedItem(rs.getString("course_name"));
                jComboBoxClassGroup.setSelectedItem(rs.getString("class_group_code"));

            } else {
                // If no data found for the student ID, display a message
                JOptionPane.showMessageDialog(null, "No student found with ID: " + jTextFieldStudentID.getText());
            }
            rs.close();
            prest.close();
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtonClose = new javax.swing.JButton();
        jButtonAddStudent = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelAddress1 = new javax.swing.JLabel();
        jLabelPhoneNumber = new javax.swing.JLabel();
        jLabelStudentID = new javax.swing.JLabel();
        jTextFieldStudentID = new javax.swing.JTextField();
        jLabelAge = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jTextFieldAge = new javax.swing.JTextField();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabelSurname = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelPpsn = new javax.swing.JLabel();
        jTextFieldPpsn = new javax.swing.JTextField();
        jLabelDateOfBirth = new javax.swing.JLabel();
        jTextFieldAddress1 = new javax.swing.JTextField();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jLabelGender = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox<>();
        jLabelAddress2 = new javax.swing.JLabel();
        jTextFieldAddress2 = new javax.swing.JTextField();
        jLabelEircode = new javax.swing.JLabel();
        jTextFieldEircode = new javax.swing.JTextField();
        jLabelCounty = new javax.swing.JLabel();
        jTextFieldCounty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCourseName = new javax.swing.JComboBox<>();
        jLabelClassGroup = new javax.swing.JLabel();
        jComboBoxClassGroup = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jButtonEditAssesment = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Form");
        setResizable(false);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonAddStudent.setText("Add Student");
        jButtonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddStudentActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add, Edit or Delete entry. "));

        jLabelAddress1.setText("Address Line 1:");

        jLabelPhoneNumber.setText("Phone Number:");

        jLabelStudentID.setText("Student ID:");

        jTextFieldStudentID.setEditable(false);
        jTextFieldStudentID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldStudentID.setEnabled(false);

        jLabelAge.setText("Age:");

        jLabelFirstName.setText("First Name:");

        jTextFieldAge.setEditable(false);
        jTextFieldAge.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldAge.setEnabled(false);
        jTextFieldAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAgeKeyTyped(evt);
            }
        });

        jTextFieldFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFirstNameKeyTyped(evt);
            }
        });

        jLabelSurname.setText("Surname:");

        jLabelEmail.setText("Email:");

        jLabelPpsn.setText("PPSN:");

        jTextFieldPpsn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPpsnKeyTyped(evt);
            }
        });

        jLabelDateOfBirth.setText("Date of Birth:");

        jLabelGender.setText("Gender:");

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jComboBoxGender.setToolTipText("");

        jLabelAddress2.setText("Address Line 2:");

        jLabelEircode.setText("Eircode:");

        jLabelCounty.setText("County:");

        jTextFieldCounty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCountyKeyTyped(evt);
            }
        });

        jLabel1.setText("Course Name:");

        jComboBoxCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCourseNameActionPerformed(evt);
            }
        });

        jLabelClassGroup.setText("Class Group:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCounty)
                            .addComponent(jLabel1)
                            .addComponent(jLabelClassGroup))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxCourseName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxClassGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStudentID)
                                    .addComponent(jLabelFirstName)
                                    .addComponent(jLabelEmail)
                                    .addComponent(jLabelPpsn)
                                    .addComponent(jLabelDateOfBirth))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldPpsn)
                                    .addComponent(jTextFieldStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAddress1)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldCounty)
                                    .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddress2)
                                    .addComponent(jLabelEircode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEircode, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelSurname)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelPhoneNumber)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelGender)
                                        .addGap(75, 75, 75)
                                        .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelAge)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStudentID)
                    .addComponent(jTextFieldStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSurname)
                    .addComponent(jTextFieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPhoneNumber)
                    .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPpsn)
                    .addComponent(jTextFieldPpsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGender)
                    .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDateOfBirth)
                        .addComponent(jLabelAge)
                        .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAddress1)
                            .addComponent(jTextFieldAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelAddress2)
                        .addComponent(jTextFieldAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCounty)
                        .addComponent(jTextFieldCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEircode)
                        .addComponent(jTextFieldEircode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClassGroup)
                    .addComponent(jComboBoxClassGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButtonEditAssesment.setText("View/Edit assesment");
        jButtonEditAssesment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAssesmentActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonPrint.setText("Print");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditAssesment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrint)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditAssesment)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonAddStudent)
                    .addComponent(jButtonSearch)
                    .addComponent(jButtonPrint))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * jButtonAddStudentActionPerformed ---------------- Opens the
     * AddStudentFrame and closes the current StudentForm.
     */
    private void jButtonAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddStudentActionPerformed
        AddStudentFrame asf = new AddStudentFrame();
        asf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonAddStudentActionPerformed

    /**
     * jComboBoxCourseNameActionPerformed ---------------- Populates the
     * jComboBoxClassGroup with class group codes corresponding to the selected
     * course from jComboBoxCourseName.
     */
    private void jComboBoxCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCourseNameActionPerformed
        try {

            Connection con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            PreparedStatement prest = null;

            String sql = "SELECT class_group_code FROM class_group WHERE course_name=?";

            prest = con.prepareStatement(sql);

            String selectedCourse = (String) jComboBoxCourseName.getSelectedItem();
            prest.setString(1, selectedCourse);
            ResultSet rs = prest.executeQuery();
            jComboBoxClassGroup.removeAllItems();
            jComboBoxClassGroup.addItem("");
            while (rs.next()) {
                jComboBoxClassGroup.addItem(rs.getString(1));
            }

        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    }//GEN-LAST:event_jComboBoxCourseNameActionPerformed

    /**
     * jButtonSaveActionPerformed ---------------- Saves or updates the current
     * student's details in the database. Uses the Student object 's' populated
     * with the current form values.
     */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        s = new Student(jTextFieldAge.getText(), (String) jComboBoxClassGroup.getSelectedItem(), jTextFieldFirstName.getText(),
                jTextFieldSurname.getText(), (String) jComboBoxGender.getSelectedItem(), jTextFieldEmail.getText(),
                jTextFieldPpsn.getText(), jTextFieldAddress1.getText(), jTextFieldAddress2.getText(),
                jTextFieldCounty.getText(), jTextFieldEircode.getText(), jTextFieldPhoneNumber.getText(),
                formatter.format(jDateChooser.getDate()), (String) jComboBoxCourseName.getSelectedItem(), validateInteger(jTextFieldStudentID.getText()));

        try {

            Connection con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            PreparedStatement prest = null;

            String sql = "UPDATE student SET class_group_code=?, first_name=? ,surname=?"
                    + ",gender=?,email=?,ppsn=?,address_line_1=?,"
                    + " address_line_2=?,county=?, eircode=?, age=?"
                    + ", date_of_birth=?, phone_number=? WHERE student_id=?";

            prest = con.prepareStatement(sql);
            prest.setString(1, s.getClassGroupCode());
            prest.setString(2, s.getFirstName());
            prest.setString(3, s.getSurname());
            prest.setString(4, s.getGender());
            prest.setString(5, s.getEmail());
            prest.setString(6, s.getPpsn());
            prest.setString(7, s.getAddress1());
            prest.setString(8, s.getAddress2());
            prest.setString(9, s.getAddressCounty());
            prest.setString(10, s.getAddressEirCode());
            prest.setString(11, s.getAge());
            prest.setString(12, s.getDob());
            prest.setString(13, s.getMobileNumber());
            prest.setInt(14, s.getStudentID());
            prest.executeUpdate();

            prest.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Student has been added/updated successfully",
                    "Task complite", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException err) {

            System.out.println(err.getMessage());

        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /**
     * jButtonDeleteActionPerformed ---------------- Deletes the current student
     * from the database based on studentID. Prompts a confirmation dialog
     * before deletion.
     */
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            try {
                Connection con = (Connection) DriverManager.getConnection(url + dbName, userName, password);
                PreparedStatement prest = null;

                try {
                    String sql = "DELETE FROM student WHERE student_id = ?";
                    prest = con.prepareStatement(sql);
                    prest.setInt(1, studentID);
                    int rowsAffected = prest.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Student with studentID: " + studentID + " was deleted successfully",
                                "Successful delete", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No student found with studentID: " + studentID,
                                "Delete failed", JOptionPane.ERROR_MESSAGE);
                    }
                    con.close();
                } catch (SQLException s) {
                    System.out.println("SQL statement is not executed!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    }

    /**
     * jButtonSearchActionPerformed ---------------- Opens the StudentViewFrame
     * and closes the current StudentForm.
     */
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        StudentViewFrame svf = new StudentViewFrame();
        svf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    /**
     * jButtonCloseActionPerformed ---------------- Closes the current
     * StudentForm.
     */
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    /**
     * jTextFieldFirstNameKeyTyped ---------------- Validates that the typed
     * character is a letter.
     */
    private void jTextFieldFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameKeyTyped
        ValidateLetter(evt);
    }//GEN-LAST:event_jTextFieldFirstNameKeyTyped

    private void jTextFieldPpsnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPpsnKeyTyped
        ValidateDigitAndLetter(evt);
    }//GEN-LAST:event_jTextFieldPpsnKeyTyped

    private void jTextFieldAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAgeKeyTyped
        ValidateDigit(evt);
    }//GEN-LAST:event_jTextFieldAgeKeyTyped

    private void jTextFieldCountyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCountyKeyTyped
        ValidateLetter(evt);
    }//GEN-LAST:event_jTextFieldCountyKeyTyped

    /**
     * jButtonEditAssesmentActionPerformed ---------------- Opens the
     * StudentAssessmentFrame for the current student to view/edit assessments.
     */
    private void jButtonEditAssesmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAssesmentActionPerformed
//        int studentID = Integer.parseInt((String) value);
        StudentAssessmentFrame saf1 = new StudentAssessmentFrame(studentID);
        saf1.setVisible(true);
    }//GEN-LAST:event_jButtonEditAssesmentActionPerformed

    /**
     * jButtonPrintActionPerformed ---------------- Prints the current student's
     * details using a PrintFrame. Details include personal info, address,
     * course, and class group.
     */
    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
        s = new Student(jTextFieldAge.getText(), (String) jComboBoxClassGroup.getSelectedItem(), jTextFieldFirstName.getText(),
                jTextFieldSurname.getText(), (String) jComboBoxGender.getSelectedItem(), jTextFieldEmail.getText(),
                jTextFieldPpsn.getText(), jTextFieldAddress1.getText(), jTextFieldAddress2.getText(),
                jTextFieldCounty.getText(), jTextFieldEircode.getText(), jTextFieldPhoneNumber.getText(),
                formatter.format(jDateChooser.getDate()), (String) jComboBoxCourseName.getSelectedItem(), validateInteger(jTextFieldStudentID.getText()));
        PrintFrame spf = new PrintFrame();
        spf.jTextAreaPrint.setText(spf.jTextAreaPrint.getText() + "StudentID: " + s.getStudentID() + "\n"
                + "Name: " + s.getFirstName() + " " + s.getSurname() + "\n"
                + "Email: " + s.getEmail() + "\t\t" + "Phone Number: " + s.getMobileNumber() + "\n"
                + "PPSN: " + s.getPpsn() + "\t\t" + "Gender: " + s.getGender() + "\n"
                + "Date of Birth: " + s.getDob() + "\t\t" + "Age: " + s.getAge() + "\n"
                + "Address 1: " + s.getAddress1() + "\t\t" + "Address 2: " + s.getAddress2() + "\n"
                + "County: " + s.getAddressCounty() + "\t\t" + "Eircode: " + s.getAddressEirCode() + "\n"
                + "Course Name: " + s.getCourseName() + "\n"
                + "Class Group: " + s.getClassGroupCode());

        spf.setVisible(true);
    }//GEN-LAST:event_jButtonPrintActionPerformed

    /**
     * jDateChooserPropertyChange ---------------- Updates the jTextFieldAge
     * when the date of birth in the JDateChooser changes.
     */
    private void jDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserPropertyChange
        jTextFieldAge.setText(Integer.toString(calculateAge(jDateChooser.getDate())));
    }//GEN-LAST:event_jDateChooserPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddStudent;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEditAssesment;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxClassGroup;
    private javax.swing.JComboBox<String> jComboBoxCourseName;
    private javax.swing.JComboBox<String> jComboBoxGender;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress1;
    private javax.swing.JLabel jLabelAddress2;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelClassGroup;
    private javax.swing.JLabel jLabelCounty;
    private javax.swing.JLabel jLabelDateOfBirth;
    private javax.swing.JLabel jLabelEircode;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelPhoneNumber;
    private javax.swing.JLabel jLabelPpsn;
    private javax.swing.JLabel jLabelStudentID;
    private javax.swing.JLabel jLabelSurname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAddress1;
    private javax.swing.JTextField jTextFieldAddress2;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldCounty;
    private javax.swing.JTextField jTextFieldEircode;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldPpsn;
    public static javax.swing.JTextField jTextFieldStudentID;
    private javax.swing.JTextField jTextFieldSurname;
    // End of variables declaration//GEN-END:variables
}
