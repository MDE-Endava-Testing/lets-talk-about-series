package com.gitlab.epadronu.letstalkabout.exceptions.pages;

import com.gitlab.epadronu.letstalkabout.exceptions.common.Page;
import com.gitlab.epadronu.letstalkabout.exceptions.exceptions.NoSuchElementException;
import com.gitlab.epadronu.letstalkabout.exceptions.exceptions.FormNotFoundException;

public class LoginPage extends Page {

  public void logIn() throws FormNotFoundException {
    try {
      findElement("form").findElement("#username").sendKeys("username");
      findElement("form").findElement("#password").sendKeys("password");
      findElement("form").findElement("#submit").click();
    } catch (NoSuchElementException e) {
      throw new FormNotFoundException("The form was not present", e);
    }
  }
}
