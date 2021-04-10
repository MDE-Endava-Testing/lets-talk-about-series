package com.gitlab.epadronu.letstalkabout.assertj;

import java.util.List;

import com.gitlab.epadronu.letstalkaboutassertj.utils.AllureExtension;
import com.gitlab.epadronu.letstalkaboutassertj.utils.PascalCaseDisplayNameGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayNameGeneration(PascalCaseDisplayNameGenerator.class)
@ExtendWith({AllureExtension.class})
@Severity(SeverityLevel.NORMAL)
@Tag("Demo")
public class AssertionTypesTest {

  private static final List<String> actualJedis = List.of("Anakin", "Obi-Wan");

  private static final List<String> expectedJedis = List.of("Luke", "Anakin", "Windu");

  @Test
  public void builtin() {
    // Java built-in | This is not the right way to use it
    assert actualJedis.equals(expectedJedis);
  }

  @Test
  public void oldStyle() {
    // What we only had years ago
    assertEquals(expectedJedis, actualJedis, "The lists are not equals");
  }

  @Test
  public void better() {
    // An improvement, but we can do even better
    assertIterableEquals(expectedJedis, actualJedis, "The lists are not equals");
  }

  @Test
  public void theBest() {
    // The best of the best
    assertThat(actualJedis)
     .as("The lists must contains the same elements")
     .containsExactlyElementsOf(expectedJedis);
  }
}
