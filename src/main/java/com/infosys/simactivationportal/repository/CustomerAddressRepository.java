package com.infosys.simactivationportal.repository;

import com.infosys.simactivationportal.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer> {
}
