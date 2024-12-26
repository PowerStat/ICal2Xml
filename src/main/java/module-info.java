/*
 * Copyright (C) 2024 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */


/**
 * ical to xml module.
 */
module de.powerstat.converter.ical2xml
 {
  exports de.powerstat.converter.ical2xml;

  requires ical4j.core;
  requires de.powerstat.phplib.templateengine;
  requires org.apache.logging.log4j;

 }
