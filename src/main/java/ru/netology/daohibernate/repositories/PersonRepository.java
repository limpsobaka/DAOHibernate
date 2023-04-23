package ru.netology.daohibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daohibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
  List<Person> findAllByCityOfLiving(String cityOfLiving);

  List<Person> findAllByAgeLessThanOrderByAge(int age);

  Optional<Person> findByNameAndSurname(String name, String surname);
}
