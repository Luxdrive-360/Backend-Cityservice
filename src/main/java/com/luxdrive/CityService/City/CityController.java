package com.luxdrive.CityService.City;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {
	
    @Autowired
    private CityRepository cityRepo;

    @GetMapping
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    @PostMapping("/add")
    public City addCity(@RequestBody City city) {
        city.setActive(true);
        return cityRepo.save(city);
    }
    
    @PutMapping("/toggle/{id}")
    public City toggleCity(@PathVariable Long id) {
        City city = cityRepo.findById(id).orElseThrow();
        city.setActive(!city.isActive());
        return cityRepo.save(city);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityRepo.deleteById(id);
    }

}
