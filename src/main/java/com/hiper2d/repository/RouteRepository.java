package com.hiper2d.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hiper2d.entity.Route;
import com.hiper2d.entity.RoutePk;
import com.hiper2d.repository.projection.DestinationProjection;

public interface RouteRepository extends JpaRepository<Route, RoutePk> {
	
	@Query("select d.name, d.city, d.country from Route r join r.destinationAirport d where r.airlineId = :airlineId")
	Page<DestinationProjection> findByAirlineId(@Param("airlineId") Long airlineId, Pageable pageable);
	
	@Query("select d.name, d.city, d.country from Route r join r.destinationAirport d where r.airlineName = :name")
	Page<DestinationProjection> findByAirlineName(@Param("name") String name, Pageable pageable);
}
