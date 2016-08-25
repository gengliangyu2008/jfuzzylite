/*
 Copyright (C) 2010-2016 by FuzzyLite Limited.
 All rights reserved.

 This file is part of jfuzzylite(TM).

 jfuzzylite is free software: you can redistribute it and/or modify it under
 the terms of the FuzzyLite License included with the software.

 You should have received a copy of the FuzzyLite License along with
 jfuzzylite. If not, see <http://www.fuzzylite.com/license/>.

 fuzzylite(R) is a registered trademark of FuzzyLite Limited.
 jfuzzylite(TM) is a trademark of FuzzyLite Limited.

 */
package com.fuzzylite;

import java.io.InputStream;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FuzzyLite {

    public static final String NAME = "jfuzzylite";
    public static final String VERSION = "6.0";
    public static final String LIBRARY = NAME + " " + VERSION;
    public static final String LICENSE = "FuzzyLite License";
    public static final String AUTHOR = "Juan Rada-Vilela, Ph.D.";
    public static final String COMPANY = "FuzzyLite Limited";
    public static final String WEBSITE = "http://www.fuzzylite.com/";
    private static int DECIMALS = 3;
    protected static double MACHEPS = 1e-6; //Machine epsilon to differentiate numbers
    private static boolean debugging = false;

    private static DecimalFormat DF = new DecimalFormat("0.000");

    static {
        //To get the same results as fuzzylite C++
        DF.setRoundingMode(RoundingMode.HALF_UP);
    }

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private static Logger LOGGER = Logger.getLogger("com.fuzzylite");

    static {
        String configurationFile = "/logging.properties";
        final InputStream inputStream = FuzzyLite.class.getResourceAsStream(configurationFile);
        try {
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (Exception ex) {
            System.out.println(String.format("WARNING: Could not load default %s file", configurationFile));
            System.out.println(ex);
        } finally {
            try {
                inputStream.close();
            } catch (Exception ex) {

            }
        }
//        FuzzyLite.logger().info("info");
//        FuzzyLite.logger().warning("warning");
//        FuzzyLite.logger().severe("severe");
//        FuzzyLite.logger().fine("fine");
//        FuzzyLite.logger().finer("finer");
//        FuzzyLite.logger().finest("finest");
    }

    /**
     Gets the default logger of the jfuzzylite library

     @return the default logger of the jfuzzylite library
     */
    public static Logger logger() {
        return LOGGER;
    }

    /**
     Sets the default logger of the jfuzzylite library

     @param logger is the default logger of the jfuzzylite library
     */
    public static void setLogger(Logger logger) {
        LOGGER = logger;
    }

    /**
     Gets the default formatter that is utilized when formatting any
     floating-point value using Op.str().

     @return the default formatter that is utilized when formatting any
     floating-point value using Op.str().
     */
    public static java.text.DecimalFormat getFormatter() {
        return DF;
    }

    /**
     Returns the number of decimals utilized when formatting scalar values

     @return the number of decimals utilized when formatting scalar values
     (default is 3)
     */
    public static int getDecimals() {
        return DECIMALS;
    }

    /**
     Sets the number of decimals utilized when formatting scalar values

     @param decimals is the number of decimals utilized when formatting scalar
     values
     */
    public static void setDecimals(int decimals) {
        DECIMALS = decimals;
        StringBuilder pattern = new StringBuilder("0.".length() + decimals);
        pattern.append("0.");
        for (int i = 0; i < decimals; ++i) {
            pattern.append('0');
        }
        DF = new DecimalFormat(pattern.toString());
        DF.setRoundingMode(RoundingMode.HALF_UP);
    }

    /**
     Returns the minimum difference at which two floating-point values are
     considered equivalent

     @return the minimum difference at which two floating-point values are
     considered equivalent (default is 1e-6)
     */
    public static double getMachEps() {
        return MACHEPS;
    }

    /**
     Sets the minimum difference at which two floating-point values are
     considered equivalent

     @param macheps is the minimum difference at which two floating-point values
     are considered equivalent (default is 1e-6)
     */
    public static void setMachEps(double macheps) {
        MACHEPS = macheps;
    }

    /**
     Sets whether the library is set to log information

     @param logging indicates whether the library is set to log information
     */
    public static void setLogging(boolean logging) {
        if (logging) {
            LOGGER.setLevel(debugging ? Level.FINE : Level.INFO);
        } else {
            LOGGER.setLevel(Level.OFF);
        }
    }

    /**
     Returns whether the library is logging information

     @return whether the library is logging information
     */
    public static boolean isLogging() {
        return LOGGER.getLevel() != null && !LOGGER.getLevel().equals(Level.OFF);
    }

    /**
     Sets whether the library is set to run in debug mode

     @param debugging indicates whether the library is set to run in debug mode
     */
    public static void setDebugging(boolean debugging) {
        FuzzyLite.debugging = debugging;
        if (isLogging()) {
            LOGGER.setLevel(debugging ? Level.FINE : Level.INFO);
        }
    }

    /**
     Indicates whether the library is running in debug mode

     @return `true` if the library is running in debug mode, and `false` if it
     is running in release mode
     */
    public static boolean isDebugging() {
        return FuzzyLite.debugging;
    }

}
