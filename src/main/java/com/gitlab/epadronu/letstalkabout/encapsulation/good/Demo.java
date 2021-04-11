package com.gitlab.epadronu.letstalkabout.encapsulation.good;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import static java.nio.file.attribute.PosixFilePermissions.asFileAttribute;
import static java.nio.file.attribute.PosixFilePermissions.fromString;

import static org.apache.logging.log4j.Level.INFO;

public final class Demo {

  private static final Logger log = LogManager.getLogger();

  public static void main(final String[] args) {
    final PersonRecord newBorn = new PersonRecord(
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

    try (final PrintWriter writer = new PrintWriter(Files.createTempFile(
     "lets-talk-about",
     "encapsulation",
     asFileAttribute(fromString("rw-------"))).toFile())) {
      newBorn.writeWith(writer);
      oldMan.writeWith(writer);
    } catch (IOException e) {
      log.error(e);
    }

    System.out.println("\nWriting to standard output");

    try (final PrintWriter writer = new PrintWriter(System.out, true)) {
      newBorn.writeWith(writer);
      oldMan.writeWith(writer);
    }

    System.err.println("\nWriting to standard error");

    try (final PrintWriter writer = new PrintWriter(System.err, true)) {
      newBorn.writeWith(writer);
      oldMan.writeWith(writer);
    }

    log.info("Writing to a logger");

    try (final PrintWriter writer = IoBuilder.forLogger(log)
                                             .setLevel(INFO)
                                             .setAutoFlush(true)
                                             .buildPrintWriter()) {
      newBorn.writeWith(writer);
      oldMan.writeWith(writer);
    }
  }
}
