package com.gitlab.epadronu.letstalkabout.exceptions.exceptions;

// This is a dummy exception. It's not the real thing.
public class NoSuchElementException extends RuntimeException {

  public NoSuchElementException() {
  }

  public NoSuchElementException(final String message) {
    super(message);
  }

  public NoSuchElementException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public NoSuchElementException(final Throwable cause) {
    super(cause);
  }

  public NoSuchElementException(
   final String message,
   final Throwable cause,
   final boolean enableSuppression,
   final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
