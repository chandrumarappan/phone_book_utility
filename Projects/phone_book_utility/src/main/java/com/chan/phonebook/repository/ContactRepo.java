package com.chan.phonebook.repository;

import com.chan.phonebook.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends JpaRepository<ContactDetail, Long> {

    @Query("SELECT c FROM ContactDetail c WHERE LOWER(c.name) LIKE LOWER(CONCAT(?1, '%')) ORDER BY LOWER(c.name) ASC")
    List<ContactDetail> findByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

    @Query("SELECT c FROM ContactDetail c WHERE c.phoneNumber = ?1 ORDER BY LOWER(c.name) ASC")
    List<ContactDetail> findByPhoneNumberOrderByNameAsc(long phoneNumber);

    @Query("SELECT c FROM ContactDetail c ORDER BY LOWER(c.name) ASC")
    List<ContactDetail> findAllByOrderByNameAsc();

    Optional<ContactDetail> findByNameIgnoreCaseAndPhoneNumberAndAddressIgnoreCase(
            String name, long phoneNumber, String address);
}
