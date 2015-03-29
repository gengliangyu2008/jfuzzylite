/*
 Author: Juan Rada-Vilela, Ph.D.
 Copyright (C) 2010-2014 FuzzyLite Limited
 All rights reserved

 This file is part of jfuzzylite.

 jfuzzylite is free software: you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation, either version 3 of the License, or (at your option)
 any later version.

 jfuzzylite is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with jfuzzylite.  If not, see <http://www.gnu.org/licenses/>.

 fuzzylite™ is a trademark of FuzzyLite Limited.
 jfuzzylite™ is a trademark of FuzzyLite Limited.

 */
package com.fuzzylite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Op {

    /*
     * Math Operations
     */
    public static boolean isEq(double a, double b) {
        return Math.abs(a - b) < FuzzyLite.getMachEps();
    }

    public static boolean isEq(double a, double b, double macheps) {
        return Math.abs(a - b) < macheps;
    }

    public static boolean isNEq(double a, double b) {
        return !isEq(a, b, FuzzyLite.getMachEps());
    }

    public static boolean isNEq(double a, double b, double macheps) {
        return !isEq(a, b, macheps);
    }

    public static boolean isLt(double a, double b) {
        return !isEq(a, b, FuzzyLite.getMachEps()) && a < b;
    }

    public static boolean isLt(double a, double b, double macheps) {
        return !isEq(a, b, macheps) && a < b;
    }

    public static boolean isLE(double a, double b) {
        return isEq(a, b, FuzzyLite.getMachEps()) || a < b;
    }

    public static boolean isLE(double a, double b, double macheps) {
        return isEq(a, b, macheps) || a < b;
    }

    public static boolean isGt(double a, double b) {
        return !isEq(a, b, FuzzyLite.getMachEps()) && a > b;
    }

    public static boolean isGt(double a, double b, double macheps) {
        return !isEq(a, b, macheps) && a > b;
    }

    public static boolean isGE(double a, double b) {
        return isEq(a, b, FuzzyLite.getMachEps()) || a > b;
    }

    public static boolean isGE(double a, double b, double macheps) {
        return isEq(a, b, macheps) || a > b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double modulo(double a, double b) {
        return a % b;
    }

    public static double logicalAnd(double a, double b) {
        return (isEq(a, 1.0) && isEq(b, 1.0)) ? 1.0 : 0.0;
    }

    public static double logicalOr(double a, double b) {
        return (isEq(a, 1.0) || isEq(b, 1.0)) ? 1.0 : 0.0;
    }

    public static double logicalNot(double a) {
        return isEq(a, 1.0) ? 0.0 : 1.0;
    }

    public static double negate(double x) {
        return -x;
    }

    public static double bound(double x, double min, double max) {
        if (isGt(x, max)) {
            return max;
        }
        if (isLt(x, min)) {
            return min;
        }
        return x;
    }

    public static boolean in(double x, double min, double max) {
        return in(x, min, max, true, true);
    }

    public static boolean in(double x, double min, double max, boolean geq, boolean leq) {
        boolean left = geq ? isGE(x, min) : isGt(x, min);
        boolean right = leq ? isLE(x, max) : isLt(x, max);
        return (left && right);
    }

    public static boolean isFinite(double x) {
        return !(Double.isNaN(x) || Double.isInfinite(x));
    }

    public static double scale(double x,
            double fromMin, double fromMax, double toMin, double toMax) {
        return (toMax - toMin) / (fromMax - fromMin) * (x - fromMin) + toMin;
    }

    public static double scale(double x,
            double fromMin, double fromMax, double toMin, double toMax, boolean bounded) {
        double result = (toMax - toMin) / (fromMax - fromMin) * (x - fromMin) + toMin;
        return bounded ? Op.bound(x, toMin, toMax) : result;
    }

    public static List<String> split(String string, String delimiter) {
        return split(string, delimiter, true);
    }

    public static List<String> split(String str, String delimiter, boolean ignoreEmpty) {
        List<String> result = new ArrayList<String>();
        if (str.isEmpty() || delimiter.isEmpty()) {
            result.add(str);
            return result;
        }
        int position = 0, next = 0;
        while (next >= 0) {
            next = str.indexOf(delimiter, position);
            String token;
            if (next < 0) {
                token = str.substring(position);
            } else {
                token = str.substring(position, next);
            }
            if (!(token.isEmpty() && ignoreEmpty)) {
                result.add(token);
            }
            if (next >= 0) {
                position = next + delimiter.length();
            }
        }
        return result;
    }

    public static double toDouble(String x, double alternative) {
        try {
            return toDouble(x);
        } catch (Exception ex) {
            return alternative;
        }
    }

    public static double toDouble(String x) throws NumberFormatException {
        if ("nan".equals(x)) {
            return Double.NaN;
        }
        if ("inf".equals(x)) {
            return Double.POSITIVE_INFINITY;
        }
        if ("-inf".equals(x)) {
            return Double.NEGATIVE_INFINITY;
        }

        return Double.parseDouble(x);
    }

    public static boolean isNumeric(String x) {
        try {
            toDouble(x);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean increment(int[] array, int[] min, int[] max) {
        return increment(array, array.length - 1, min, max);
    }

    public static boolean increment(int[] array, int position, int[] min, int[] max) {
        if (position < 0) {
            return true;
        }

        boolean overflow = false;
        if (array[position] < max[position]) {
            ++array[position];
        } else {
            overflow = (position == 0);
            array[position] = min[position];
            --position;
            if (position >= 0) {
                overflow = increment(array, position, min, max);
            }
        }
        return overflow;
    }

    /*
     * String Operations
     */
    public static <T extends Number> String str(T x) {
        String result = "";
        if (Double.isNaN(x.doubleValue())) {
            result = "nan";
        } else if (Double.isInfinite(x.doubleValue())) {
            if (isLt(x.doubleValue(), 0.0)) {
                result = "-";
            }
            result += "inf";
        } else if (isEq(x.doubleValue(), 0.0)) {
            result = FuzzyLite.getFormatter().format(0.0);
        } else {
            result = FuzzyLite.getFormatter().format(x);
        }
        return result;
    }

    public static <T> String join(Collection<T> x, String separator) {
        String result = "";
        for (Iterator<T> it = x.iterator(); it.hasNext();) {
            T item = it.next();
            if (item instanceof Number) {
                result += Op.str((Number) item);
            } else {
                result += item.toString();
            }
            if (it.hasNext()) {
                result += separator;
            }
        }
        return result;
    }

    public static String join(long[] x, String separator) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            result += str(x[i]);
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    public static String join(int[] x, String separator) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            result += str(x[i]);
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    public static String join(double[] x, String separator) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            result += str(x[i]);
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    public static String join(float[] x, String separator) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            result += str(x[i]);
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    public static String join(String[] x, String separator) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            result += x[i];
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    //@SafeVarargs
    public static <T> String join(String separator, T... x) {
        String result = "";
        for (int i = 0; i < x.length; ++i) {
            T item = x[i];
            if (item instanceof Number) {
                result += Op.str((Number) item);
            } else {
                result += item.toString();
            }
            if (i + 1 < x.length) {
                result += separator;
            }
        }
        return result;
    }

    public static String validName(String id) {
        if (id == null || id.trim().isEmpty()){
            return "unnamed";
        }
        StringBuilder result = new StringBuilder();
        for (char c : id.toCharArray()) {
            if (c == '_' || c == '.' || Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Classes
     */
    public static interface Cloneable extends java.lang.Cloneable {

        public Object clone() throws CloneNotSupportedException;
    }

    public static class Pair<Y, Z> {

        private Y first;
        private Z second;

        public Pair() {
            this(null, null);
        }

        public Pair(Y first, Z second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "{" + this.first + ":" + this.second + "}";
        }

        public Y getFirst() {
            return first;
        }

        public void setFirst(Y first) {
            this.first = first;
        }

        public Z getSecond() {
            return second;
        }

        public void setSecond(Z second) {
            this.second = second;
        }
    }

}
