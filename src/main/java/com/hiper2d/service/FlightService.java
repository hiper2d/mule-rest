package com.hiper2d.service;

import java.time.LocalDate;
import java.util.List;

import com.hiper2d.dto.RouteDto;
import com.hiper2d.entity.Flight;

public interface FlightService {
	List<Flight> getAllFlights();
	List<Flight> getFlights(LocalDate date);
	boolean bookSeat(Flight flight);
	boolean changePrice(Flight flight, Double delta);
	Flight createFlight(Flight flight);
	boolean checkIfFlightExists(Flight flight);
}
