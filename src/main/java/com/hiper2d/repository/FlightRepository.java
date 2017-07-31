package com.hiper2d.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiper2d.entity.Flight;
import com.hiper2d.entity.FlightPk;

public interface FlightRepository extends JpaRepository<Flight, FlightPk> {
	List<Flight> findByDepatureDateBetween(LocalDateTime start, LocalDateTime end);
}
