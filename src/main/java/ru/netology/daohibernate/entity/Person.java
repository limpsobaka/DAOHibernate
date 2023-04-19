package ru.netology.daohibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(PersonPK.class)
public class Person {
  @Id
  private String name;
  @Id
  private String surname;
  @Id
  private int age;
  private long phoneNumber;
  private String cityOfLiving;
}
