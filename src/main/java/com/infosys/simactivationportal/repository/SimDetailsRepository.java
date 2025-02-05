package com.infosys.simactivationportal.repository;

import com.infosys.simactivationportal.entity.SimDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimDetailsRepository extends JpaRepository<SimDetails,Long> {

    public SimDetails findBySimNumberAndServiceNumber(Long simNumber, Long serviceNumber);
}
