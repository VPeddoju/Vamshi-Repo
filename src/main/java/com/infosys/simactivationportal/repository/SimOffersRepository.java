package com.infosys.simactivationportal.repository;

import com.infosys.simactivationportal.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SimOffersRepository extends JpaRepository<SimOffers,Integer> {

}
