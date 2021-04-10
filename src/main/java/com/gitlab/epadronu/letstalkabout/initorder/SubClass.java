package com.gitlab.epadronu.letstalkabout.initorder;

public class SubClass extends BaseClass {

  static {
    System.out.printf("11. Static initializer in %s%n", SubClass.class.getSimpleName());
  }

  static {
    System.out.printf("15. Static initializer in %s%n", SubClass.class.getSimpleName());
  }

  {
    System.out.printf("12. Instance initializer in %s%n", SubClass.class.getSimpleName());
  }

  {
    System.out.printf("16. Instance initializer in %s%n", SubClass.class.getSimpleName());
  }

  public SubClass() {
    System.out.printf("13. Nullary constructor in %s%n", SubClass.class.getSimpleName());
  }

  public SubClass(final int value) {
    super(value);

    System.out.printf("14. Overloaded constructor in %s%n", SubClass.class.getSimpleName());
  }

  public static void main(String[] args) {
    new SubClass(6);
  }
}
