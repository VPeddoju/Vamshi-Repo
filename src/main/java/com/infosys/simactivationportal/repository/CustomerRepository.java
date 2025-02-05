package com.infosys.simactivationportal.repository;

import com.infosys.simactivationportal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Customer findByEmailAddress(String emailAddress);
}
