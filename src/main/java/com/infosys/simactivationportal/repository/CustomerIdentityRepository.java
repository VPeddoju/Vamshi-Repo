package com.infosys.simactivationportal.repository;

import com.infosys.simactivationportal.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity, Long> {
}
