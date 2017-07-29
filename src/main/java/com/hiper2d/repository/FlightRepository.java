package com.hiper2d.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiper2d.entity.Flight;
import com.hiper2d.entity.FlightPk;

@Transactional(propagation = Propagation.MANDATORY)
public interface FlightRepository extends JpaRepository<Flight, FlightPk> {

}
