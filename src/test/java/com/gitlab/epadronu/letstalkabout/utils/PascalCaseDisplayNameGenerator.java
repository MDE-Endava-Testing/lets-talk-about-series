package com.gitlab.epadronu.letstalkabout.utils;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayNameGenerator;

public class PascalCaseDisplayNameGenerator implements DisplayNameGenerator {

  @Override
  public String generateDisplayNameForClass(final Class<?> aClass) {
    return pascalCaseToSpaceSeparatedPascalCase(aClass.getSimpleName());
  }

  private static String pascalCaseToSpaceSeparatedPascalCase(final String name) {
    return StringUtils.capitalize(
     String
      .join(" ", StringUtils.splitByCharacterTypeCamelCase(name))
      .toLowerCase());
  }

  @Override
  public String generateDisplayNameForNestedClass(final Class<?> aClass) {
    return pascalCaseToSpaceSeparatedPascalCase(aClass.getSimpleName());
  }

  @Override
  public String generateDisplayNameForMethod(final Class<?> aClass, final Method method) {
    return pascalCaseToSpaceSeparatedPascalCase(method.getName());
  }
}
