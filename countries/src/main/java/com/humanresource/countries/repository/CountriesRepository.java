package com.humanresource.countries.repository;

import com.humanresource.countries.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Character> {

    /*Optional<Countries> findCountriesByCountryName(String country);

    @Query(
            value = "select lower(cou.countryName) from countries cou where cou.countryId=?1 and cou.countryName=?2"
    )
    Optional<Countries> findByCountryIdAndCountryName(Integer countryId, String country);

    List<Countries> findByCountryNameLike(String countryPattern);

    List<Countries> findByCountryNameContaining(String countryWord);

    List<Countries> findByCountryNameStartingWith(String countryWord);

    List<Countries> findByCountryNameEndingWith(String countryWord);

    List<Countries> findByCountryNameIgnoreCase(String countryWord);*/
}
