package com.gitlab.epadronu.letstalkabout.encapsulation.good;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class PersonRecord implements Writable {

  private static final SimpleDateFormat birthDateFormat = new SimpleDateFormat("yyyy/MM/dd");

  private final String id;

  private final String name;

  private final String middleName;

  private final String surname;

  private final Date birthDate;

  private final String bloodType;

  public PersonRecord(
   final String id,
   final String name,
   final String middleName,
   final String surname,
   final Date birthDate, final String bloodType) {
    this.id = id;
    this.name = name;
    this.middleName = middleName;
    this.surname = surname;
    this.birthDate = birthDate;
    this.bloodType = bloodType;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getSurname() {
    return surname;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public String getBloodType() {
    return bloodType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, middleName, surname, birthDate, bloodType);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final PersonRecord that = (PersonRecord) o;
    return Objects.equals(id, that.id)
           && name.equals(that.name)
           && Objects.equals(middleName, that.middleName)
           && surname.equals(that.surname)
           && birthDate.equals(that.birthDate)
           && bloodType.equals(that.bloodType);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", PersonRecord.class.getSimpleName() + "[", "]")
     .add("id='" + id + "'")
     .add("name='" + name + "'")
     .add("middleName='" + middleName + "'")
     .add("surname='" + surname + "'")
     .add("birthDate=" + birthDate)
     .add("bloodType='" + bloodType + "'")
     .toString();
  }

  @Override
  public void writeWith(final PrintWriter writer) {
    writer.format(
     "%s{Id: %s, Name: %s, Middle name: %s, Surname: %s, Birth date: %s, Blood type: %s}%n",
     PersonRecord.class.getSimpleName(),
     id,
     name,
     middleName,
     surname,
     birthDateFormat.format(birthDate),
     bloodType);
  }
}
