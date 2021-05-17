package com.gitlab.epadronu.letstalkabout.assertj;

import java.util.regex.Pattern;

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
public class StringValidationTests {

  private static final String actualJedi = "Windu";

  private static final String expectedJedi = "Luke";

  @Test
  public void withoutBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedi.isEmpty()).isTrue();

      softly.assertThat(actualJedi.length() == 10).isTrue();

      softly.assertThat(actualJedi.equals(expectedJedi)).isTrue();

      softly.assertThat(actualJedi.equalsIgnoreCase(expectedJedi)).isTrue();

      softly.assertThat(actualJedi.startsWith("L")).isTrue();

      softly.assertThat(Pattern.matches("\\d", actualJedi)).isTrue();
    });
  }

  @Test
  public void withBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedi).isEmpty();

      softly.assertThat(actualJedi).hasSize(10);

      softly.assertThat(actualJedi).isEqualTo(expectedJedi);

      softly.assertThat(actualJedi).isEqualToIgnoringCase(expectedJedi);

      softly.assertThat(actualJedi).startsWith("L");

      softly.assertThat(actualJedi).matches(Pattern.compile("\\d"));
    });
  }
}
