package com.gitlab.epadronu.letstalkabout.parameterizedtests;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class MyArgumentProvider implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) {
    return new Random().ints(10, 1, 100)
                       .mapToObj(number -> Arguments.of(number, number * number));
  }
}
