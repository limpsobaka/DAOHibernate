package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Person;
import ru.netology.daohibernate.repository.DAORepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class DAOController {
  private final DAORepository daoRepository;

  public DAOController(DAORepository daoRepository) {
    this.daoRepository = daoRepository;
  }

  @GetMapping("persons/by-city")
  public List<Person> getPersonsByCity(@RequestParam("city") String city) {
    return daoRepository.getPersonsByCity(city);
  }
}
