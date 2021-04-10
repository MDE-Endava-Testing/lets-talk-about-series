package com.gitlab.epadronu.letstalkabout.initorder;

public class BaseClass {

  private static int attribute = 1;

  static {
    System.out.printf("01. Static initializer in %s%n", BaseClass.class.getSimpleName());

    attribute++;
  }

  static {
    System.out.printf("05. Static initializer in %s%n", BaseClass.class.getSimpleName());

    attribute++;
  }

  {
    System.out.printf("02. Instance initializer in %s%n", BaseClass.class.getSimpleName());

    attribute += 2;
  }

  {
    System.out.printf("06. Instance initializer in %s%n", BaseClass.class.getSimpleName());

    attribute += 2;
  }

  public BaseClass(final int value) {
    this();

    System.out.printf("04. Overloaded constructor in %s%n", BaseClass.class.getSimpleName());

    attribute /= (4 + value);
  }

  public BaseClass() {
    System.out.printf("03. Nullary constructor in %s%n", BaseClass.class.getSimpleName());

    attribute *= 3;
  }

  public static void main(String[] args) {
    new BaseClass(0);

    System.out.println(BaseClass.attribute);
  }
}
