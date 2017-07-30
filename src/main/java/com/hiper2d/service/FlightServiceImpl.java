package com.hiper2d.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiper2d.entity.Flight;
import com.hiper2d.repository.FlightRepository;

@Service("flightService")
public class FlightServiceImpl extends BaseService implements FlightService {
	
	private FlightRepository flightRepository;
	
	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	
	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
	public List<Flight> getFlights(LocalDate date) {
		LocalDateTime beginningOfDay = date.atStartOfDay();
		LocalDateTime endingOfDay = date.atStartOfDay().plusDays(1).minusSeconds(1);
		return flightRepository.findByDepatureDateBetween(beginningOfDay, endingOfDay);
	}
}
