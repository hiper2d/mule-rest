package com.hiper2d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiper2d.entity.Flight;
import com.hiper2d.repository.FlightRepository;

@Service(value = "flightService")
public class FlightServiceImpl extends BaseService implements FlightService {
	
	private FlightRepository flightRepository;
	
	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}
}
