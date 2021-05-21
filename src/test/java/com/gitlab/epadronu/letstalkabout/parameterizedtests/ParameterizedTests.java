package com.gitlab.epadronu.letstalkabout.parameterizedtests;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.gitlab.epadronu.letstalkabout.utils.AllureExtension;
import com.gitlab.epadronu.letstalkabout.utils.PascalCaseDisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayNameGeneration(PascalCaseDisplayNameGenerator.class)
@ExtendWith({AllureExtension.class})
public class ParameterizedTests {

  private static IntStream parameterizedTestWithASingleArgumentMethodSource() {
    return new Random().ints(10, 1, 100);
  }

  private static Stream<? extends Arguments> powerNumberSource() {
    return new Random().ints(10, 1, 100)
                       .mapToObj(number -> Arguments.of(number, number * number));
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void parameterizedTestWithBooleansValueSource(final boolean argument) {
    assertThat(argument).isIn(true, false);
  }

  @ParameterizedTest(name = "Checking the <{0}> string")
  @NullAndEmptySource // Same as using @NullSource and @EmptySource
  @ValueSource(strings = {
   " ",
   "\t",
   " \t\n",
   "%#$(#)!@#**%$",
   "A string"})
  public void parameterizedTestWithNullEmptyAndStringsValueSource(final String argument) {
    assertThat(argument).satisfiesAnyOf(
     string -> assertThat(string).isNullOrEmpty(),
     string -> assertThat(string).isBlank(),
     string -> assertThat(string).isNotBlank());
  }

  @ParameterizedTest
  @NullSource
  @EnumSource(IDTypes.class)
  public void parameterizedTestWithNullAndEnumSource(final IDTypes argument) {
    final IDTypes[] possibleValues = Arrays.copyOf(
     IDTypes.values(), IDTypes.values().length + 1);

    assertThat(argument).isIn(possibleValues);
  }

  @ParameterizedTest
  @CsvSource(value = {
   "0,''",
   "1,a",
   "2,bb"})
  public void parameterizedTestWithCsvSource(final int size, final String string) {
    assertThat(string).hasSize(size);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
  public void parameterizedTestWithCsvFileSource(final String country, final int reference) {
    assertSoftly(softly -> {
      softly.assertThat(country).isNotEmpty();

      softly.assertThat(reference).isGreaterThanOrEqualTo(1);
    });
  }

  @ParameterizedTest
  @MethodSource
  public void parameterizedTestWithASingleArgumentMethodSource(final int argument) {
    assertThat(argument).isBetween(1, 100);
  }

  @ParameterizedTest
  @MethodSource("powerNumberSource")
  public void parameterizedTestWithMultipleArgumentsMethodSource(
   final int number,
   final int power) {
    assertThat(power).isEqualTo(number * number);
  }

  @ParameterizedTest
  @ArgumentsSource(MyArgumentProvider.class)
  public void parameterizedTestWithAReusableArgumentProvider(final int number, final int power) {
    assertThat(power).isEqualTo(number * number);
  }
}
