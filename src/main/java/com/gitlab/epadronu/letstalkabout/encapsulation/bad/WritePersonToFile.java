package com.gitlab.epadronu.letstalkabout.encapsulation.bad;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WritePersonToFile implements CanWritePersonRecord {

  private static final Logger log = LogManager.getLogger();

  private final Path path;

  public WritePersonToFile(final Path path) {
    this.path = path;
  }

  public Path getPath() {
    return path;
  }

  @Override
  public CanWritePersonRecord write(final PersonRecord personRecord) {
    final String recordString = String.format(
     "%s{Id: %s, Name: %s, Middle name: %s, Surname: %s, Birth date: %s, Blood type: %s}%n",
     PersonRecord.class.getSimpleName(),
     personRecord.getId(),
     personRecord.getName(),
     personRecord.getMiddleName(),
     personRecord.getSurname(),
     CanWritePersonRecord.birthDateFormat.format(personRecord.getBirthDate()),
     personRecord.getBloodType());

    try (FileWriter writer = new FileWriter(path.toFile(), true)) {
      writer.write(recordString);
    } catch (IOException e) {
      log.error(e);
    }

    return this;
  }
}
