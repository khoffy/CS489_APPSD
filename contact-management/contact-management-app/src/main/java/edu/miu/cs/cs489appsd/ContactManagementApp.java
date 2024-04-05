package edu.miu.cs.cs489appsd;

import edu.miu.cs.cs489appsd.model.Contact;
import edu.miu.cs.cs489appsd.model.EmailAddress;
import edu.miu.cs.cs489appsd.model.PhoneAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class ContactManagementApp
{
    public static void main( String[] args ) {
        PhoneAddress phoneAddress = new PhoneAddress();
        phoneAddress.setNumber("555-555-555");
        Map<String, String> phoneLabels = new HashMap<>();
        phoneLabels.put("location", "home");
        phoneAddress.setLabels(phoneLabels);

        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setEmail("koffi.tipoh@gmail.com");
        Map<String, String> emailLabels = new HashMap<>();
        emailLabels.put("location", "Office");
        emailAddress.setLabels(emailLabels);

        Contact contact = new Contact();
        contact.setFirstName("Koffi"); contact.setLastName("Tipoh");
        contact.setEmailAddresses(List.of(emailAddress));
        contact.setPhoneAddresses(List.of(phoneAddress));


        List<Contact> contacts = List.of(contact);

        displayContact(contacts);
    }

    private static void displayContact(List<Contact> contacts) {
         StringBuilder jsonSb = new StringBuilder("[");
         jsonSb.append("\n");
         for (Contact c : contacts) {

             jsonSb.append("{");
             jsonSb.append("\"contactId\":"); jsonSb.append(c.getId()); jsonSb.append(", ");
             jsonSb.append("\"firstname\":");
             jsonSb.append("\""); jsonSb.append(c.getFirstName()); jsonSb.append("\""); jsonSb.append(", ");
             jsonSb.append("\"lastname\":");
             jsonSb.append("\""); jsonSb.append(c.getLastName()); jsonSb.append("\""); jsonSb.append(", ");
             jsonSb.append("\"phone\":");
             jsonSb.append("{");
             for (PhoneAddress p : c.getPhoneAddresses()) {
                 jsonSb.append("\"phoneId\":"); jsonSb.append(p.getId()); jsonSb.append(", ");
                 jsonSb.append("\"phoneNumber\""); jsonSb.append(":");jsonSb.append("\"");
                 jsonSb.append(p.getNumber()); jsonSb.append("\""); jsonSb.append(", ");
                 for (Map.Entry<String, String> entry: p.getLabels().entrySet()) {
                     jsonSb.append("\""); jsonSb.append(entry.getKey()); jsonSb.append("\""); jsonSb.append(":");
                     jsonSb.append("\"");
                     jsonSb.append(entry.getValue());
                     jsonSb.append("\"");
                 }
             }
             jsonSb.append("}");
             jsonSb.append(",");
             jsonSb.append("\"email\":");
             jsonSb.append("{");
             for (EmailAddress e : c.getEmailAddresses()) {
                 jsonSb.append("\"emailId\":");
                 jsonSb.append("\"");jsonSb.append(e.getId());
                 jsonSb.append("\"");jsonSb.append(", ");
                 jsonSb.append("\"emailAddress\""); jsonSb.append(":");
                 jsonSb.append("\"");
                 jsonSb.append(e.getEmail());
                 jsonSb.append("\"");
                 jsonSb.append(", ");
                 for (Map.Entry<String, String> entry: e.getLabels().entrySet()) {
                     jsonSb.append("\""); jsonSb.append(entry.getKey()); jsonSb.append("\""); jsonSb.append(":");
                     jsonSb.append("\"");
                     jsonSb.append(entry.getValue());
                     jsonSb.append("\"");
                 }
             }
             jsonSb.append("}");
             jsonSb.append("}");
             jsonSb.append("\n");
         }

        System.out.println(jsonSb);
    }
}
