package ru.netology.daohibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.daohibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
  @Query("select p from Person p where p.cityOfLiving = :cityOfLiving")
  List<Person> findPersonsByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

  @Query("select p from Person p where p.age < :age order by p.age")
  List<Person> findPersonsByAgeLessThanAgeAndSortedByAge(@Param("age") int age);

  @Query("select p from Person p where p.name = :name and p.surname = :surname")
  Optional<Person> findPersonsByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

  @Query("select p from Person p")
  List<Person> getAllPersons();
}
