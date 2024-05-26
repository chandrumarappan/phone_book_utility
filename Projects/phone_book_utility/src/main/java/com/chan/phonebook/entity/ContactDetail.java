package com.chan.phonebook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "ContactDetail(name=" + this.getName() + ", phoneNumber=" + this.getPhoneNumber() + ", " +
                "address=" + this.getAddress() + ")";
    }
}
