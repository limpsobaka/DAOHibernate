package ru.netology.daohibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Person;
import ru.netology.daohibernate.repositories.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DAOController {

  PersonRepository personrepository;

  public DAOController(PersonRepository personrepository) {
    this.personrepository = personrepository;
  }

  @Secured("ROLE_READ")
  @GetMapping("persons/by-city")
  public List<Person> getPersonsByCity(@RequestParam("city") String city) {
    return personrepository.findPersonsByCityOfLiving(city);
  }

  @RolesAllowed("WRITE")
  @GetMapping("persons/by-age-less-then")
  public List<Person> getPersonsByCity(@RequestParam("age") int age) {
    return personrepository.findPersonsByAgeLessThanAgeAndSortedByAge(age);
  }

  @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
  @GetMapping("persons/by-name-and-surname")
  public Optional<Person> getPersonsByCity(@RequestParam("name") String name, @RequestParam("surname") String surname) {
    return personrepository.findPersonsByNameAndSurname(name, surname);
  }

  @GetMapping("persons/getAllPersons")
  public List<Person> getAllPersons(@RequestParam("username") String name) {
    if (SecurityContextHolder.getContext().getAuthentication().getName().equals(name)) {
      return personrepository.getAllPersons();
    } else {
      return Collections.emptyList();
    }
  }
}
