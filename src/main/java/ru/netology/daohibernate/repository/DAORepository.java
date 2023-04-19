package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.entity.Person;

import java.util.List;
@NoArgsConstructor
@Repository
public class DAORepository {
  @PersistenceContext
  private EntityManager entityManager;

  public List<Person> getPersonsByCity(String city) {
    Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.cityOfLiving=:cityOfLiving")
            .setParameter("cityOfLiving", city);
    return query.getResultList();
  }
}
