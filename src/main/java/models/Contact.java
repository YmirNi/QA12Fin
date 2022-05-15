package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@Builder
@ToString

public class Contact {

    String Name;
    String LastName;
    String Phone;
    String email;
    String Address;
    String description;

    public Contact withName(String name) {
        this.Name = name;
        return this;
    }

    public Contact withLastName(String lastName) {
        this.LastName = lastName;
        return this;
    }

    public Contact withPhone(String phone) {
        this.Phone = phone;
        return this;
    }

    public Contact withEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact withAddress(String address) {
        this.Address = address;
        return this;
    }

    public Contact withDescription(String description) {
        this.description = description;
        return this;
    }
    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return Address;
    }

    public String getDescription() {
        return description;
    }

}
