/*
 * Copyright (C) 2024-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
