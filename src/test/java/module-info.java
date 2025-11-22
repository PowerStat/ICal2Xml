/*
 * Copyright (C) 2024 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */


/**
 * ical to xml module.
 */
open module de.powerstat.converter.ical2xml
 {
  exports de.powerstat.converter.ical2xml;

  requires ical4j.core;
  requires de.powerstat.phplib.templateengine;
  requires org.apache.logging.log4j;

  requires com.github.spotbugs.annotations;
  requires org.junit.jupiter.api;
  requires org.junit.jupiter.params;
  requires org.junit.platform.launcher;
  requires org.junit.platform.suite.api;
  // requires io.cucumber.java;
  // requires io.cucumber.junit.platform.engine;
  // requires nl.jqno.equalsverifier;

 }
