package edu.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by sarah on 9/4/2017.
 */
public class UserTest {
    User testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new User("Test", "User", "6", createDateFromString("1991/01/01"));
    }

    @Test
    public void calculateAge() throws Exception {
        int age = testUser.calculateAge(testUser.getBirthDate());
        assertEquals("Age calculation Failed", 26, age);
    }

    public Date createDateFromString (String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date;

        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            //handle exception if date is not in "dd-MMM-yyyy" format
            date = new Date();
        }

        return date;
    }

}