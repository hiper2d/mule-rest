package com.hiper2d.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hiper2d.entity.Route;
import com.hiper2d.repository.RouteRepository;
import com.hiper2d.repository.projection.DestinationProjection;
import com.hiper2d.util.Constants;

@Service("routeService")
public class RouteServiceImpl extends BaseService implements RouteService {
	
	private RouteRepository routeRepository;

	@Autowired
	public RouteServiceImpl(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}
	
	@Override
	public List<DestinationProjection> getDestinationsByAirlineId(Long airlineId, int page) {
		Page<DestinationProjection> routesPage = routeRepository.findByAirlineId(
				airlineId, 
				new PageRequest(page, Constants.DESTINATIONS_PAGE_SIZE)
		);
		return routesPage.getContent();
	}
	
	@Override
	public List<DestinationProjection> getDestinationsByAirlineName(String airlineName, int page) {
		Page<DestinationProjection> routesPage = routeRepository.findByAirlineName(
				airlineName, 
				new PageRequest(page, Constants.DESTINATIONS_PAGE_SIZE)
		);
		return routesPage.getContent();
	}
}
