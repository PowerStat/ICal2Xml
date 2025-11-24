/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.converter.ical2xml;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import de.powerstat.phplib.templateengine.TemplateEngine;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.CalendarComponent;


/**
 * ICal2Xml
 */
public final class ICal2Xml
 {
  /**
   * Default constructor.
   */
  private ICal2Xml()
   {
    super();
   }


  /**
   * Main.
   *
   * @param args Commandline arguments: filename.ics
   * @throws IOException IO exception
   * @throws ParserException Parser exception
   */
  public static void main(final String[] args) throws IOException, ParserException
   {
    if (args.length != 1)
     {
      System.out.println("ical2xml filename.ics");
      return;
     }

    final FileInputStream fin = new FileInputStream(args[0]);
    final CalendarBuilder builder = new CalendarBuilder();
    final Calendar calendar = builder.build(fin);

    final TemplateEngine engine = new TemplateEngine();
    /* final boolean success = */ engine.setFile("EVENTS", new File("target/events.xml"));
    /* final boolean successBlock = */ engine.setBlock("EVENTS", "BLK_EVENTS", "BLK_EVENTS_VAR");

    String lastDTStamp = "";
    String lastSummary = "";
    boolean flag = true;
    final List<CalendarComponent> ccl = calendar.getComponents();
    for (final CalendarComponent cc : ccl)
     {
      final List<Property> pl = cc.getProperties();
      for (final Property p : pl)
       {
        final String pname = p.getName();
        final String pvalue = p.getValue();
        switch (pname)
         {
          case "DTSTAMP":
            final String dtstamp = pvalue.substring(0, 8);
            if (!lastDTStamp.equals(dtstamp))
             {
              flag = true;
              if (!lastDTStamp.isEmpty())
               {
                engine.setVar("DATE", lastDTStamp.substring(0, 4) + "-" + lastDTStamp.substring(4, 6) + "-" + lastDTStamp.substring(6));
               }
             }
            else
             {
              flag = false;
             }
            lastDTStamp = dtstamp;
            break;
          case "SUMMARY":
            final String summary = pvalue.substring(8);
            if (flag)
             {
              if (!lastSummary.isEmpty())
               {
                engine.setVar("SUMMARY", lastSummary);
                /* String parseResult = */ engine.parse("BLK_EVENTS_VAR", "BLK_EVENTS", true);
               }
              lastSummary = summary;
             }
            else
             {
              lastSummary += " / " + summary;
             }
            break;
          default:
            // ignore
         }
       }
     }
    if (!flag)
     {
      engine.setVar("DATE", lastDTStamp.substring(0, 4) + "-" + lastDTStamp.substring(4, 6) + "-" + lastDTStamp.substring(6));
      engine.setVar("SUMMARY", lastSummary);
      /* String parseResult = */ engine.parse("BLK_EVENTS_VAR", "BLK_EVENTS", true);
     }
    final String output = engine.parse("OUTPUT", "EVENTS");
    System.out.println(output);
   }

 }
