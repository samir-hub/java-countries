package com.samir.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
// Beans - POJOs managed by Spring
@RequestMapping("/data")
public class CountryController
{
    // localhost:2019/data/names/all
    @GetMapping(value = "/names/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        CountriesApplication.ourCouList.countryList.sort((c1, c2) -> c1.getName()
                .compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.ourCouList.countryList,
                HttpStatus.OK);
    }

    // localhost:2019/data/names/start/s
    @GetMapping(value = "/names/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(
            @PathVariable
                    char letter)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCouList.findCountries(c -> c.getName()
                .toUpperCase()
                .charAt(0) == Character.toUpperCase(letter));
        rtnCountries.sort((c1, c2) -> c1.getName()
                .compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries,
                HttpStatus.OK);
    }

    // localhost:2019/data/names/size/2
    @GetMapping(value = "/names/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByNameLength(
            @PathVariable
                    int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCouList.findCountries(c -> c.getName()
                .length() >= number);
        rtnCountries.sort((c1, c2) -> c1.getName()
                .compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries,
                HttpStatus.OK);
    }

    // localhost:2019/data/population/size/1000000000
    @GetMapping(value = "/population/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByGivenPopulation(
            @PathVariable
                    int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCouList.findCountries(c -> c.getPopulation()
                 >= number);
        rtnCountries.sort((c1, c2) -> c1.getName()
                .compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries,
                HttpStatus.OK);
    }

    // localhost:2019/data/population/min
    @GetMapping(value = "/population/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMinPopulation()
    {
        CountriesApplication.ourCouList.countryList.sort((c1, c2) -> c1.getPopulation()-c2.getPopulation());
        return new ResponseEntity<>(CountriesApplication.ourCouList.countryList.get(0),
                HttpStatus.OK);
    }

    // localhost:2019/data/population/max
    @GetMapping(value = "/population/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMaxPopulation()
    {
        CountriesApplication.ourCouList.countryList.sort((c1, c2) -> c2.getPopulation()-c1.getPopulation());
        return new ResponseEntity<>(CountriesApplication.ourCouList.countryList.get(0),
                HttpStatus.OK);
    }

    // localhost:2019/data/age/age/30
    @GetMapping(value = "/age/age/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByGivenMedAge(
            @PathVariable
                    int number)
    {
        ArrayList<Country> rtnCountries = CountriesApplication.ourCouList.findCountries(c -> c.getMedAge()
                >= number);
        rtnCountries.sort((c1, c2) -> c1.getName()
                .compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountries,
                HttpStatus.OK);
    }
    // localhost:2019/data/age/min
    @GetMapping(value = "/age/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMinMedAge()
    {
        CountriesApplication.ourCouList.countryList.sort((c1, c2) -> c1.getMedAge()-c2.getMedAge());
        return new ResponseEntity<>(CountriesApplication.ourCouList.countryList.get(0),
                HttpStatus.OK);
    }

    // localhost:2019/data/age/max
    @GetMapping(value = "/age/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByMaxMedAge()
    {
        CountriesApplication.ourCouList.countryList.sort((c1, c2) -> c2.getMedAge()-c1.getMedAge());
        return new ResponseEntity<>(CountriesApplication.ourCouList.countryList.get(0),
                HttpStatus.OK);
    }

//    // localhost:2019/data/employee/2
//    @GetMapping(value = "/employee/{empID}",
//                produces = {"application/json"})
//    public ResponseEntity<?> getEmployeeById(
//            @PathVariable
//                    long empID)
//    {
//        return new ResponseEntity<>(WebEmployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == empID)),
//                HttpStatus.OK);
//    }


}