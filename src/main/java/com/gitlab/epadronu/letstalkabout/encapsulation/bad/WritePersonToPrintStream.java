package com.gitlab.epadronu.letstalkabout.encapsulation.bad;

import java.io.PrintStream;

public class WritePersonToPrintStream implements CanWritePersonRecord {

  private final PrintStream stream;

  public WritePersonToPrintStream(final PrintStream stream) {
    this.stream = stream;
  }

  public PrintStream getStream() {
    return stream;
  }

  @Override
  public CanWritePersonRecord write(final PersonRecord personRecord) {
    stream.printf(
     "%s{Id: %s, Name: %s, Middle name: %s, Surname: %s, Birth date: %s, Blood type: %s}%n",
     PersonRecord.class.getSimpleName(),
     personRecord.getId(),
     personRecord.getName(),
     personRecord.getMiddleName(),
     personRecord.getSurname(),
     CanWritePersonRecord.birthDateFormat.format(personRecord.getBirthDate()),
     personRecord.getBloodType());

    return this;
  }
}
