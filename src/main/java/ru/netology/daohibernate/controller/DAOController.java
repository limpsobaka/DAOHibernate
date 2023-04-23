package ru.netology.daohibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Person;
import ru.netology.daohibernate.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DAOController {
  @Autowired
  PersonRepository personrepository;

  @GetMapping("persons/by-city")
  public List<Person> getPersonsByCity(@RequestParam("city") String city) {
    return personrepository.findPersonsByCityOfLiving(city);
  }

  @GetMapping("persons/by-age-less-then")
  public List<Person> getPersonsByCity(@RequestParam("age") int age) {
    return personrepository.findPersonsByAgeLessThanAgeAndSortedByAge(age);
  }

  @GetMapping("persons/by-name-and-surname")
  public Optional<Person> getPersonsByCity(@RequestParam("name") String name, @RequestParam("surname") String surname) {
    return personrepository.findPersonsByNameAndSurname(name, surname);
  }
}
