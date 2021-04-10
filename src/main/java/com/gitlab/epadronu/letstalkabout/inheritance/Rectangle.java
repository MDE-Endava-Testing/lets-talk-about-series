package com.gitlab.epadronu.letstalkabout.inheritance;

import java.util.StringJoiner;

public class Rectangle {

  private int length = 0;

  private int width = 0;

  public Rectangle() {
  }

  public Rectangle(final int length, final int width) {
    this.length = length;
    this.width = width;
  }

  public int getLength() {
    return length;
  }

  public void setLength(final int length) {
    this.length = length;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(final int width) {
    this.width = width;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Rectangle.class.getSimpleName() + "[", "]")
     .add("length=" + length)
     .add("width=" + width)
     .toString();
  }
}
