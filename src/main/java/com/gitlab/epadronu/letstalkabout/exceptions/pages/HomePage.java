package com.gitlab.epadronu.letstalkabout.exceptions.pages;

import com.gitlab.epadronu.letstalkabout.exceptions.common.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage extends Page {

  private static final Logger log = LogManager.getLogger();

  public LoginPage goToLoginPage() {
    try {
      findElement("#main-menu")
       .findElements("a")
       .get(3)
       .click();
    } catch (IndexOutOfBoundsException e) {
      log.error("We didn't find the login button");

      return null;
    }

    return new LoginPage();
  }
}
