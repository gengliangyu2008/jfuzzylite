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
package com.fuzzylite.norm;

/**
 The SNorm class is the base class for all S-Norms, and it is utilized as the
 disjunction fuzzy logic operator and as the aggregation (or `accumulation` in
 versions 5.0 and earlier) fuzzy logic operator.

 @author Juan Rada-Vilela, Ph.D.
 @see RuleBlock::getDisjunction()
 @see OutputVariable::fuzzyOutput()
 @see Aggregated::getAggregation()
 @see SNormFactory
 @see Norm
 @since 4.0
 */
public abstract class SNorm extends Norm {

    @Override
    public SNorm clone() throws CloneNotSupportedException {
        return (SNorm) super.clone();
    }
}
