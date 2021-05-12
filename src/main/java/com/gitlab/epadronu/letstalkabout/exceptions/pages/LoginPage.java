package com.gitlab.epadronu.letstalkabout.exceptions.pages;

import com.gitlab.epadronu.letstalkabout.exceptions.common.Navigable;
import com.gitlab.epadronu.letstalkabout.exceptions.common.Page;

public class LoginPage extends Page {

  public void logIn(final String username, final String password) {
    final Navigable form = findElement("form");

    form.findElement("#username").sendKeys(username);

    form.findElement("#password").sendKeys(password);

    form.findElement("#submit").click();
  }
}
