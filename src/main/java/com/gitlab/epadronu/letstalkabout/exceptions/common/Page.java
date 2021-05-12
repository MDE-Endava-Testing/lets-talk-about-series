package com.gitlab.epadronu.letstalkabout.exceptions.common;

import java.util.List;

/*
 * The base class for all pages which contains utility methods among other stuff.
 *
 * This class is a dummy one. It's not the real thing.
 */
public abstract class Page implements Navigable {

  @Override
  public Navigable findElement(final String by) {
    return null;
  }

  @Override
  public List<Navigable> findElements(final String by) {
    return null;
  }

  @Override
  public void sendKeys(final String string) {
  }

  @Override
  public void click() {
  }
}
