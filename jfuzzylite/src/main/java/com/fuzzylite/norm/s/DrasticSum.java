/*
 jfuzzylite (TM), a fuzzy logic control library in Java.
 Copyright (C) 2010-2017 FuzzyLite Limited. All rights reserved.
 Author: Juan Rada-Vilela, Ph.D. <jcrada@fuzzylite.com>

 This file is part of jfuzzylite.

 jfuzzylite is free software: you can redistribute it and/or modify it under
 the terms of the FuzzyLite License included with the software.

 You should have received a copy of the FuzzyLite License along with
 jfuzzylite. If not, see <http://www.fuzzylite.com/license/>.

 jfuzzylite is a trademark of FuzzyLite Limited.
 fuzzylite (R) is a registered trademark of FuzzyLite Limited.
 */
package com.fuzzylite.norm.s;

import com.fuzzylite.Op;
import com.fuzzylite.norm.SNorm;

/**
 The DrasticSum class is an SNorm that computes the drastic sum of any two
 values.

 @author Juan Rada-Vilela, Ph.D.
 @see DrasticProduct
 @see SNorm
 @see SNormFactory
 @see Norm
 @since 4.0
 */
public final class DrasticSum extends SNorm {

    /**
     Computes the drastic sum of two membership function values

     @param a is a membership function value
     @param b is a membership function value
     @return @f$\begin{cases} \max(a,b) & \mbox{if $\min(a,b)=0$} \cr 1 &
     \mbox{otherwise} \end{cases}@f$
     */
    @Override
    public double compute(double a, double b) {
        if (Op.isEq(Op.min(a, b), 0.0)) {
            return Op.max(a, b);
        }
        return 1.0;
    }

    @Override
    public DrasticSum clone() throws CloneNotSupportedException {
        return (DrasticSum) super.clone();
    }

}
