package com.gitlab.epadronu.letstalkabout.inheritance;

import java.util.StringJoiner;

public class SquareSubclass extends Rectangle implements HasSize {

  private int size = 0;

  public SquareSubclass() {
  }

  public SquareSubclass(final int size) {
    super(size, size);

    this.size = size;
  }

  @Override
  public int getLength() {
    return getSize();
  }

  @Override
  public void setLength(final int length) {
    setSize(length);
  }

  @Override
  public int getWidth() {
    return getSize();
  }

  @Override
  public void setWidth(final int width) {
    setSize(width);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", SquareSubclass.class.getSimpleName() + "[", "]")
     .add("size=" + size)
     .toString();
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void setSize(final int size) {
    this.size = size;
  }
}
