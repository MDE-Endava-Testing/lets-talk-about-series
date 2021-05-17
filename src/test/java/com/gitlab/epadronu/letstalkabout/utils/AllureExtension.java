package com.gitlab.epadronu.letstalkabout.utils;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class AllureExtension implements TestWatcher {

  @Override
  public void testFailed(final ExtensionContext context, final Throwable cause) {
    Allure.addAttachment("Exception", ExceptionUtils.getStackTrace(cause));
  }
}
