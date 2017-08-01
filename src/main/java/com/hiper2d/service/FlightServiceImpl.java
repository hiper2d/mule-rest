package com.hiper2d.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Override
	@Transactional(readOnly = false)
	public boolean bookSeat(Flight flight) {
		int updated = flightRepository.setSeatAvailability(flight.getFlightCode(), flight.getDepatureDate());
		return updated > 0;
	}

	@Override
	@Transactional(readOnly = false)
	public boolean changePrice(Flight flight, Double delta) {
		if (delta > 0) {
			flightRepository.setPrice(flight.getFlightCode(), flight.getDepatureDate(),  delta);
		} else if (delta < 0) {
			return updatePriceIfPossible(flight.getFlightCode(), flight.getDepatureDate(), delta);
		}
		return true;
	}

	@Override
	@Transactional(readOnly = false)
	public Flight createFlight(Flight flight) {
		if (checkIfFlightExists(flight)) {
			throw new RuntimeException("Flights with this code and depature date already exists.");
		}
		return flightRepository.save(flight);
	}

	@Override
	public boolean checkIfFlightExists(Flight flight) {
		return flightRepository.countByFlightCodeAndDepatureDate(flight.getFlightCode(), flight.getDepatureDate()) > 0;
	}
	
	private boolean updatePriceIfPossible(String flightCode, LocalDateTime depatureDate, Double delta) {
		Flight flight = flightRepository.findByFlightCodeAndDepatureDate(flightCode, depatureDate);
		if (flight.getPrice() + delta >= 0) {
			flightRepository.setPrice(flightCode, depatureDate, delta);
			return true;
		} else {
			return false;
		}
	}
}
