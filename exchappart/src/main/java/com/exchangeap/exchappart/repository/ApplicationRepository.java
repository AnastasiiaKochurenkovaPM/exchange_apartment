package com.exchangeap.exchappart.repository;

import com.exchangeap.exchappart.models.Application;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findByRoomsAndRegionAndFloorBetween(int searchrooms, String searchregion, String fromsearchfloor, String tosearchfloor);
}
