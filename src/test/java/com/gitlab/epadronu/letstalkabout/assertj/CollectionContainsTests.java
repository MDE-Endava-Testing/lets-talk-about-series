package com.gitlab.epadronu.letstalkabout.assertj;

import java.util.List;

import com.gitlab.epadronu.letstalkabout.utils.AllureExtension;
import com.gitlab.epadronu.letstalkabout.utils.PascalCaseDisplayNameGenerator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayNameGeneration(PascalCaseDisplayNameGenerator.class)
@ExtendWith({AllureExtension.class})
@Severity(SeverityLevel.NORMAL)
@Tag("Demo")
public class CollectionContainsTests {

  private static final List<String> actualJedis = List.of("Anakin", "Obi-Wan");

  private static final List<String> expectedJedis = List.of("Luke", "Anakin", "Windu");

  private static final String expectedJedi = "Luke";

  @Test
  public void withoutBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedis.contains(expectedJedi)).isTrue();

      softly.assertThat(actualJedis.containsAll(expectedJedis)).isTrue();
    });
  }

  @Test
  public void withBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedis).contains(expectedJedi);

      softly.assertThat(actualJedis).containsAll(expectedJedis);
    });
  }
}
