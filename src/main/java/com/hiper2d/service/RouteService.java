package com.hiper2d.service;

import java.util.List;

import com.hiper2d.repository.projection.DestinationProjection;

public interface RouteService {
	List<DestinationProjection> getDestinationsByAirlineId(Long airlineId, int page);
	List<DestinationProjection> getDestinationsByAirlineName(String airlineName, int page);
}
