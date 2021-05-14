package com.gitlab.epadronu.letstalkabout.exceptions.pages;

import java.util.stream.Collectors;

import com.gitlab.epadronu.letstalkabout.exceptions.common.Navigable;
import com.gitlab.epadronu.letstalkabout.exceptions.common.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends Page {

  private static final Logger log = LogManager.getLogger();

  public LoginPage goToLoginPage() {
    findElement("#main-menu")
     .findElements("a")
     .stream()
     .skip(2)
     .findFirst()
     .orElseThrow(() -> {
       log.error(findElement("#main-menu")
        .findElements("a")
        .stream()
        .map(Navigable::html)
        .collect(Collectors.toList()));

       return new IllegalStateException("There were not enough links in the page");
     })
     .click();

    return new LoginPage();
  }
}
