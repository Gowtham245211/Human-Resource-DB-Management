package com.humanresource.locations.repository;

import com.humanresource.locations.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Integer> {

    /*@Query(
            value = "select p from People p where HOUR(p.time) between ?1 and ?2"
    )
    List<Location> findBornBetween(int startHour, int endHour);

    List<Location> findAllByTimeLessThan(LocalDateTime time);

    List<Location> findAllByDateGreaterThan(LocalDate desiredDateTime);*/
}
