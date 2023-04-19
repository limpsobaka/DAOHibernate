package ru.netology.daohibernate.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonPK implements Serializable {
  protected String name;
  protected String surname;
  protected int age;
}
