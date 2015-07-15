/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class Contact {
    //fields
    private int contactId;
    
    @NotEmpty(message="You must supply a value for First Name")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=20, message="First name must be no more than 50 characters in length")
    private String firstName;
    
    @NotEmpty(message="You must supply a value for Last Name")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=30, message="Last name must be no more than 50 characters in length")
    private String lastName;
    
    @NotEmpty(message="You must supply a value for Company")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=50, message="Company name must be no more than 50 characters in length")
    private String company;
    
    @NotEmpty(message="You must supply a value for the phone")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=10, message="Phone number is 10 digits with no dashes, dots or other characters.")
    private String phone;
    
    @NotEmpty(message="You must supply a value for the email")    //the annotation goes with the field we want to validate--we must have a name
    @Length(max=50, message="Email address must be no more than 50 characters in length")
    private String email;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.contactId;
        hash = 31 * hash + Objects.hashCode(this.firstName);
        hash = 31 * hash + Objects.hashCode(this.lastName);
        hash = 31 * hash + Objects.hashCode(this.company);
        hash = 31 * hash + Objects.hashCode(this.phone);
        hash = 31 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.contactId != other.contactId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

 

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
