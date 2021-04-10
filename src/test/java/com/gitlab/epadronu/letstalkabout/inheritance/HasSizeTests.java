package com.gitlab.epadronu.letstalkabout.inheritance;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayNameGeneration(com.gitlab.epadronu.letstalkaboutassertj.utils.PascalCaseDisplayNameGenerator.class)
@ExtendWith({com.gitlab.epadronu.letstalkaboutassertj.utils.AllureExtension.class})
@Severity(SeverityLevel.NORMAL)
@Tag("Demo")
public class HasSizeTests {

  @Test
  public void byDefaultAHasSizeImplementationShouldHaveNoSize() {
    final HasSize squareUnderTest = new Square();

    assertSoftly(softly -> {
      softly.assertThat(squareUnderTest)
            .hasFieldOrPropertyWithValue("size", 0);
    });
  }

  @Test
  public void aHasSizeImplementationMustHaveTheGivenSize() {
    final int desiredSize = 10;

    final HasSize squareUnderTest = new Square(desiredSize);

    assertSoftly(softly -> softly
     .assertThat(squareUnderTest)
     .hasFieldOrPropertyWithValue("size", desiredSize));
  }

  @Test
  public void aHasSizeImplementationMustUpdateItsSizeWhenItIsChanged() {
    final int initialSize = 10;

    final int newSize = 100;

    final HasSize squareUnderTest = new Square(initialSize);

    squareUnderTest.setSize(newSize);

    assertSoftly(softly -> {
      softly.assertThat(squareUnderTest)
            .extracting(HasSize::getSize)
            .isNotEqualTo(initialSize);

      softly.assertThat(squareUnderTest)
            .extracting(HasSize::getSize)
            .isEqualTo(newSize);
    });
  }
}
