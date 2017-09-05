package edu.matc.entity;

// TODO Add instance variable for the date of birth - DONE
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only. - DONE

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private Date birthDate;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param birthDate the birthdate
     */
    public User(String firstName, String lastName, String userid, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.birthDate = birthDate;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets birthDate.
     *
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birthDate.
     *
     * @param birthDate the birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int calculateAge(Date birthDate) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        // LocalDate now  = LocalDate.now();
        // long age = ChronoUnit.YEARS.between(dateOfBirth, now);
        // (int) age;
        return (Integer.parseInt(formatter.format(new Date())) - Integer.parseInt(formatter.format(birthDate))) / 10000;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", brithdate='" + birthDate + '\'' +
                ", age='" + calculateAge(birthDate) + '\'' +
                '}';
    }


}