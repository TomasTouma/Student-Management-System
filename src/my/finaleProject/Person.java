package my.finaleProject;

/**
 * The {@code Person} class represents a generic person entity with common
 * attributes such as name, contact information, gender, and date of birth.
 * <p>
 * This class is designed as a base model and can be extended by other classes
 * (e.g., Staff or Admin) to include additional specific functionality.
 * </p>
 *
 * <b>Fields:</b>
 * <ul>
 * <li>First name and surname</li>
 * <li>Email and mobile number</li>
 * <li>Gender and date of birth</li>
 * <li>PPNS (Personal Public Service Number)</li>
 * <li>Address details (line 1, line 2, county, EirCode)</li>
 * </ul>
 *
 * @author Tomasz Touma
 * @version 1.0
 * @since 1.8
 */
public class Person {

    protected String firstName;

    protected String surname;

    protected String gender;

    protected String email;

    protected String ppsn;

    protected String address1;

    protected String address2;

    protected String addressCounty;

    protected String addressEirCode;

    protected String mobileNumber;

    protected String dob;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ppsn
     */
    public String getPpsn() {
        return ppsn;
    }

    /**
     * @param ppsn the ppsn to set
     */
    public void setPpsn(String ppsn) {
        this.ppsn = ppsn;
    }

    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the addressCounty
     */
    public String getAddressCounty() {
        return addressCounty;
    }

    /**
     * @param addressCounty the addressCounty to set
     */
    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    /**
     * @return the addressEirCode
     */
    public String getAddressEirCode() {
        return addressEirCode;
    }

    /**
     * @param addressEirCode the addressEirCode to set
     */
    public void setAddressEirCode(String addressEirCode) {
        this.addressEirCode = addressEirCode;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

}
