package edu.miu.cs.cs489appsd.model;

import java.util.List;

public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private List<PhoneAddress> phoneAddresses;
    private List<EmailAddress> emailAddresses;


    public Contact () {};

    public Contact(Long id, String firstName, String lastName, List<PhoneAddress> phoneAddresses, List<EmailAddress> emailAddresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneAddresses = phoneAddresses;
        this.emailAddresses = emailAddresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<PhoneAddress> getPhoneAddresses() {
        return phoneAddresses;
    }

    public void setPhoneAddresses(List<PhoneAddress> phoneAddresses) {
        this.phoneAddresses = phoneAddresses;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
}
