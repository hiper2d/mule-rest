package com.hiper2d.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hiper2d.entity.Flight;
import com.hiper2d.repository.FlightRepository;
import com.hiper2d.repository.RouteRepository;

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
	
	@Override
	@Transactional(readOnly = false)
	public boolean bookSeat(String flightCode) {
		int updated = flightRepository.setSeatAvailability(flightCode);
		return updated > 0;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean changePrice(String flightCode, Double delta) {
		if (delta > 0) {
			flightRepository.setPrice(flightCode, delta);
		} else if (delta < 0) {
			return updatePriceIfPossible(flightCode, delta);
		}
		return true;
	}
	
	private boolean updatePriceIfPossible(String flightCode, Double delta) {
		Flight flight = flightRepository.findByFlightCode(flightCode);
		if (flight.getPrice() + delta >= 0) {
			flightRepository.setPrice(flightCode, delta);
			return true;
		} else {
			return false;
		}
	}
}
