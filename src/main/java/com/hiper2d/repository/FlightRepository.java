package com.hiper2d.repository;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hiper2d.entity.Flight;
import com.hiper2d.entity.FlightPk;

public interface FlightRepository extends JpaRepository<Flight, FlightPk> {
	
	List<Flight> findByDepatureDateBetween(LocalDateTime start, LocalDateTime end);
	
	@Lock(LockModeType.PESSIMISTIC_READ)
	Long countByFlightCodeAndDepatureDate(String flightCode, LocalDateTime depatureDate);
	
	@Modifying
	@Query("update Flight f set f.seatAvailability = f.seatAvailability - 1 "
			+ "where f.flightCode = :flightCode "
			+ "and f.depatureDate = :depatureDate "
			+ "and f.seatAvailability > 0")
	int setSeatAvailability(
			@Param("flightCode") String flightCode, 
			@Param("depatureDate") LocalDateTime depatureDate);
	
	@Modifying
	@Query("update Flight f set f.price = f.price + :delta "
			+ "where f.flightCode = :flightCode "
			+ "and f.depatureDate = :depatureDate")
	int setPrice(
			@Param("flightCode") String flightCode, 
			@Param("depatureDate") LocalDateTime depatureDate, 
			@Param("delta") Double delta);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Flight findByFlightCodeAndDepatureDate(String flightCode, LocalDateTime depatureDate);
}
