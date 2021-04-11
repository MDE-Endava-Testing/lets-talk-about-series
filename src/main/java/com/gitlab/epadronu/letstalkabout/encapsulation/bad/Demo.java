package com.gitlab.epadronu.letstalkabout.encapsulation.bad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.nio.file.attribute.PosixFilePermissions.asFileAttribute;
import static java.nio.file.attribute.PosixFilePermissions.fromString;

import static org.apache.logging.log4j.Level.INFO;

public final class Demo {

  private static final Logger log = LogManager.getLogger();

  public static void main(final String[] args) throws IOException {
    final PersonRecord
     newBorn = new PersonRecord(
     null,
     "Camilo",
     "Andres",
     "Cifuentes",
     new Date(),
     "A+");

    final PersonRecord oldMan = new PersonRecord(
     "CC 123.456.789",
     "Javier",
     "Alejandro",
     "Romero",
     Date.from(LocalDate.of(1944, Month.DECEMBER, 10)
                        .atStartOfDay(ZoneId.systemDefault())
                        .toInstant()),
     "O-");

    System.out.println("Writing to a temporal file");

    final Path tempFile = Files.createTempFile(
     "lets-talk-about",
     "encapsulation",
     asFileAttribute(fromString("rw-------")));

    new WritePersonToFile(tempFile)
     .write(newBorn)
     .write(oldMan);

    System.out.println("\nWriting to standard output");

    new WritePersonToPrintStream(System.out)
     .write(newBorn)
     .write(oldMan);

    System.err.println("\nWriting to standard error");

    new WritePersonToPrintStream(System.err)
     .write(newBorn)
     .write(oldMan);

    log.info("Writing to a logger");

    new WritePersonToLogger(log, INFO)
     .write(newBorn)
     .write(oldMan);
  }
}
