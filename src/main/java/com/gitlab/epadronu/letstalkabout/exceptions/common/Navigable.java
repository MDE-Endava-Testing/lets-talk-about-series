package com.gitlab.epadronu.letstalkabout.exceptions.common;

import java.util.List;

// This is a dummy interface. It's not the real thing.
public interface Navigable {

  Navigable findElement(final String by);

  List<Navigable> findElements(final String by);

  void sendKeys(final String string);

  void click();
}
