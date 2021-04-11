package com.gitlab.epadronu.letstalkabout.encapsulation.bad;

import java.text.SimpleDateFormat;

public interface CanWritePersonRecord {

  SimpleDateFormat birthDateFormat = new SimpleDateFormat("yyyy/MM/dd");

  CanWritePersonRecord write(final PersonRecord personRecord);
}
