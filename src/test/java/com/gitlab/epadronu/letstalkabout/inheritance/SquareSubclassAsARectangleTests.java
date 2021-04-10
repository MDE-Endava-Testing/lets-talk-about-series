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
public class SquareSubclassAsARectangleTests {

  @Test
  public void byDefaultARectangleShouldHaveNoLengthNorWidth() {
    final Rectangle rectangleUnderTest = new SquareSubclass();

    assertSoftly(softly -> {
      softly.assertThat(rectangleUnderTest)
            .hasFieldOrPropertyWithValue("length", 0);

      softly.assertThat(rectangleUnderTest)
            .hasFieldOrPropertyWithValue("width", 0);
    });
  }

  @Test
  public void aRectangleMustHaveTheGivenLengthAndWidth() {
    final int desiredSize = 10;

    final Rectangle rectangleUnderTest = new SquareSubclass(desiredSize);

    assertSoftly(softly -> {
      softly.assertThat(rectangleUnderTest)
            .hasFieldOrPropertyWithValue("length", desiredSize);

      softly.assertThat(rectangleUnderTest)
            .hasFieldOrPropertyWithValue("width", desiredSize);
    });
  }

  @Test
  public void aRectangleMustUpdateItsDimensionsWhenTheyAreChanged() {
    final int initialSize = 10;

    final int newLength = 100;

    final int newWidth = 400;

    final Rectangle rectangleUnderTest = new SquareSubclass(initialSize);

    rectangleUnderTest.setLength(newLength);

    rectangleUnderTest.setWidth(newWidth);

    assertSoftly(softly -> {
      softly.assertThat(rectangleUnderTest)
            .extracting(Rectangle::getLength)
            .isNotEqualTo(initialSize);

      softly.assertThat(rectangleUnderTest)
            .extracting(Rectangle::getLength)
            .isEqualTo(newLength);

      softly.assertThat(rectangleUnderTest)
            .extracting(Rectangle::getWidth)
            .isNotEqualTo(initialSize);

      softly.assertThat(rectangleUnderTest)
            .extracting(Rectangle::getWidth)
            .isEqualTo(newWidth);
    });
  }
}
