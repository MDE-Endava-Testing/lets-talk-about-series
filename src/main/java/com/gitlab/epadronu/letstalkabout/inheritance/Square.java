package com.gitlab.epadronu.letstalkabout.inheritance;

import java.util.StringJoiner;

public class Square implements HasSize {

  private int size = 0;

  public Square() {
  }

  public Square(final int size) {
    this.size = size;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void setSize(final int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Square.class.getSimpleName() + "[", "]")
     .add("size=" + size)
     .toString();
  }
}
