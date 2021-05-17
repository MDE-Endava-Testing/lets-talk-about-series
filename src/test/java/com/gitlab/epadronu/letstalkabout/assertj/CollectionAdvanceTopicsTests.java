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
public class CollectionAdvanceTopicsTests {

  private static final List<String> actualJedis = List.of("Anakin", "Obi-Wan", "");

  @Test
  public void withoutBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedis.stream().allMatch(String::isEmpty)).isTrue();

      softly.assertThat(actualJedis.stream().map(String::length).allMatch(l -> l >= 7)).isTrue();
    });
  }

  @Test
  public void withBuiltInMethod() {
    assertSoftly(softly -> {
      softly.assertThat(actualJedis).allMatch(String::isEmpty);

      softly.assertThat(actualJedis).extracting(String::length).allMatch(l -> l >= 7);
    });
  }
}
