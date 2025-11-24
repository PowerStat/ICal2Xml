/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.converter.ical2xml.test;


import java.io.IOException;

import org.junit.jupiter.api.Test;

import de.powerstat.converter.ical2xml.ICal2Xml;
import net.fortuna.ical4j.data.ParserException;


/**
 * ICal2Xml tests.
 */
final class ICal2XmlTests
 {
  /**
   * Default constructor.
   */
  /* default */ ICal2XmlTests()
   {
    super();
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain1() throws IOException, ParserException
   {
	String[] args = {};
	ICal2Xml.main(args);
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain2() throws IOException, ParserException
   {
	String[] args = {"", ""};
	ICal2Xml.main(args);
   }


  /**
   * Test main.
   */
  @Test
  /* default */ void testMain3() throws IOException, ParserException
   {
	String[] args = {"src/test/resources/test.ics"};
	ICal2Xml.main(args);
   }

 }
