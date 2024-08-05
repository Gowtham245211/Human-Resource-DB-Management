package com.humanresource.countries.controller;

import com.humanresource.countries.entity.Countries;
import com.humanresource.countries.repository.CountriesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
@Tag(
    name = "REST APIs for Countries entity",
    description = "REST APIs - Save Country"
)
public class CountriesController {

    @Autowired
    private CountriesRepository countriesRepository;

    @Operation(
            summary = "Save Country REST API",
            description = "To save the country object"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 SUCCESS"
    )
    @PostMapping("/saveCountry")
    public ResponseEntity<String> saveCountry(@RequestBody Countries country) {

        JSONObject json = new JSONObject();
        countriesRepository.save(country);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
