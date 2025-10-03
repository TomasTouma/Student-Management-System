package my.finaleProject;

import my.finaleProject.Person;

/**
 * The {@code Staff} class extends {@link Person} to represent staff members in
 * the system. It inherits all common personal details from the {@code Person}
 * class and adds staff-specific attributes such as staff ID and
 * specializations.
 * <p>
 * This class can be used to create and manage staff objects, including their
 * personal details and work-related information.
 * </p>
 *
 * <b>Additional Fields:</b>
 * <ul>
 * <li>staffID – a unique identifier for the staff member</li>
 * <li>specializations – the staff member's area(s) of expertise</li>
 * </ul>
 *
 * @author Tomasz Touma
 * @version 1.0
 * @since 1.8
 *
 * @see Person
 */
public class Staff extends Person {

    private int staffID;
    private String specializations;

    /**
     * @return the staffID
     */
    public int getStaffID() {
        return staffID;
    }

    /**
     * @param staffID the staffID to set
     */
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    /**
     * @return the specialization
     */
    public String getSpecializations() {
        return specializations;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public Staff() {

    }

    public Staff(String firstName, String surname, String gender, String email, String ppsn, String address1,
            String address2, String addressCounty, String addressEircode, String mobileNumber, String dob, int staffID, String specializations) {
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
        this.staffID = staffID;
        this.specializations = specializations;
    }

}
