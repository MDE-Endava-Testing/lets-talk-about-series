package com.gitlab.epadronu.letstalkabout.encapsulation.bad;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class WritePersonToLogger implements CanWritePersonRecord {

  private final Logger logger;

  private final Level level;

  public WritePersonToLogger(final Logger logger, final Level level) {
    this.logger = logger;
    this.level = level;
  }

  public Logger getLogger() {
    return logger;
  }

  public Level getLevel() {
    return level;
  }

  @Override
  public CanWritePersonRecord write(final PersonRecord personRecord) {
    logger.log(
     level,
     "{}{Id: {}, Name: {}, Middle name: {}, Surname: {}, Birth date: {}, Blood type: {}}",
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
