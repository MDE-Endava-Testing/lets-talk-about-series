package com.gitlab.epadronu.letstalkabout.exceptions.exceptions;

public class FormNotFoundException extends Exception {

  public FormNotFoundException(final String message, final Throwable cause) {
    super(message + cause.getMessage());
  }
}
