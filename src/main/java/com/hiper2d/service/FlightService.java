package com.hiper2d.service;

import java.time.LocalDate;
import java.util.List;

import com.hiper2d.entity.Flight;

public interface FlightService {
	List<Flight> getAllFlights();
	List<Flight> getFlights(LocalDate date);
}
