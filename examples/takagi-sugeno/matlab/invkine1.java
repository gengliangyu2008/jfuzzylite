import com.fuzzylite.*;
import com.fuzzylite.activation.*
import com.fuzzylite.defuzzifier.*;
import com.fuzzylite.factory.*;
import com.fuzzylite.hedge.*;
import com.fuzzylite.imex.*;
import com.fuzzylite.norm.*;
import com.fuzzylite.norm.s.*;
import com.fuzzylite.norm.t.*;
import com.fuzzylite.rule.*;
import com.fuzzylite.term.*;
import com.fuzzylite.variable.*;

public class invkine1{
public static void main(String[] args){
//Java code generated with jfuzzylite 6.0.

Engine engine = new Engine();
engine.setName("invkine1");

InputVariable input1 = new InputVariable();
input1.setEnabled(true);
input1.setName("input1");
input1.setRange(-6.287, 17.000);
input1.setLockValueInRange(false);
input1.addTerm(new Bell("in1mf1", -6.122, 2.259, 1.761));
input1.addTerm(new Bell("in1mf2", -2.181, 2.095, 2.232));
input1.addTerm(new Bell("in1mf3", 2.080, 2.157, 1.314));
input1.addTerm(new Bell("in1mf4", 4.962, 2.790, 2.508));
input1.addTerm(new Bell("in1mf5", 9.338, 2.506, 1.812));
input1.addTerm(new Bell("in1mf6", 13.150, 2.363, 2.267));
input1.addTerm(new Bell("in1mf7", 17.789, 1.310, 1.756));
engine.addInputVariable(input1);

InputVariable input2 = new InputVariable();
input2.setEnabled(true);
input2.setName("input2");
input2.setRange(0.000, 16.972);
input2.setLockValueInRange(false);
input2.addTerm(new Bell("in2mf1", 0.621, 1.741, 2.454));
input2.addTerm(new Bell("in2mf2", 2.406, 0.866, 1.278));
input2.addTerm(new Bell("in2mf3", 4.883, 1.814, 2.402));
input2.addTerm(new Bell("in2mf4", 8.087, 1.941, 1.929));
input2.addTerm(new Bell("in2mf5", 11.428, 2.333, 2.022));
input2.addTerm(new Bell("in2mf6", 14.579, 2.221, 1.858));
input2.addTerm(new Bell("in2mf7", 17.813, 0.820, 1.577));
engine.addInputVariable(input2);

OutputVariable output = new OutputVariable();
output.setEnabled(true);
output.setName("output");
output.setRange(0.000, 1.500);
output.setLockValueInRange(false);
output.setAggregation(null);
output.setDefuzzifier(new WeightedAverage("TakagiSugeno"));
output.setDefaultValue(Double.NaN);
output.setLockPreviousValue(false);
output.addTerm(Linear.create("out1mf1", engine, -0.912, 2.517, 0.061));
output.addTerm(Linear.create("out1mf2", engine, -2.153, -2.204, -4.037));
output.addTerm(Linear.create("out1mf3", engine, -0.107, -0.148, 1.920));
output.addTerm(Linear.create("out1mf4", engine, -0.088, -0.071, 1.593));
output.addTerm(Linear.create("out1mf5", engine, -0.098, -0.040, 1.361));
output.addTerm(Linear.create("out1mf6", engine, -0.068, -0.027, 1.617));
output.addTerm(Linear.create("out1mf7", engine, -1.901, -0.081, 0.185));
output.addTerm(Linear.create("out1mf8", engine, 16.651, 11.713, 6.803));
output.addTerm(Linear.create("out1mf9", engine, -4.152, -1.033, -4.755));
output.addTerm(Linear.create("out1mf10", engine, -0.123, 0.004, 0.861));
output.addTerm(Linear.create("out1mf11", engine, -0.102, 0.006, 0.816));
output.addTerm(Linear.create("out1mf12", engine, -0.089, 0.038, 0.515));
output.addTerm(Linear.create("out1mf13", engine, -0.074, 0.082, -0.061));
output.addTerm(Linear.create("out1mf14", engine, -0.009, -0.173, 4.841));
output.addTerm(Linear.create("out1mf15", engine, -7.995, -2.818, 17.910));
output.addTerm(Linear.create("out1mf16", engine, 0.674, 0.745, -2.167));
output.addTerm(Linear.create("out1mf17", engine, -0.130, -0.004, 0.869));
output.addTerm(Linear.create("out1mf18", engine, -0.094, 0.061, 0.366));
output.addTerm(Linear.create("out1mf19", engine, -0.087, 0.121, -0.395));
output.addTerm(Linear.create("out1mf20", engine, -0.061, 0.162, -1.312));
output.addTerm(Linear.create("out1mf21", engine, -0.163, 0.920, -13.253));
output.addTerm(Linear.create("out1mf22", engine, 1.417, 3.072, 1.881));
output.addTerm(Linear.create("out1mf23", engine, -0.950, -0.732, 3.128));
output.addTerm(Linear.create("out1mf24", engine, -0.058, 0.162, -0.530));
output.addTerm(Linear.create("out1mf25", engine, -0.044, 0.077, -0.121));
output.addTerm(Linear.create("out1mf26", engine, -0.061, 0.054, 0.273));
output.addTerm(Linear.create("out1mf27", engine, -0.068, 0.099, -0.250));
output.addTerm(Linear.create("out1mf28", engine, 0.429, 0.610, -9.118));
output.addTerm(Linear.create("out1mf29", engine, -6.661, -3.697, 0.015));
output.addTerm(Linear.create("out1mf30", engine, -3.544, 8.995, 0.396));
output.addTerm(Linear.create("out1mf31", engine, 0.210, -0.137, -1.010));
output.addTerm(Linear.create("out1mf32", engine, -0.003, 0.137, -1.210));
output.addTerm(Linear.create("out1mf33", engine, -0.030, 0.018, 0.107));
output.addTerm(Linear.create("out1mf34", engine, -0.227, -0.306, 6.550));
output.addTerm(Linear.create("out1mf35", engine, 11.005, -3.375, -1.135));
output.addTerm(Linear.create("out1mf36", engine, 0.578, 0.033, -0.104));
output.addTerm(Linear.create("out1mf37", engine, 0.895, -3.268, -0.992));
output.addTerm(Linear.create("out1mf38", engine, 0.125, 0.006, -1.733));
output.addTerm(Linear.create("out1mf39", engine, 0.044, 0.003, -0.303));
output.addTerm(Linear.create("out1mf40", engine, -0.179, -0.093, 3.458));
output.addTerm(Linear.create("out1mf41", engine, 0.222, 0.597, -10.102));
output.addTerm(Linear.create("out1mf42", engine, 9.320, 13.692, 0.858));
output.addTerm(Linear.create("out1mf43", engine, 0.161, -0.117, -1.382));
output.addTerm(Linear.create("out1mf44", engine, 0.495, -0.833, -6.564));
output.addTerm(Linear.create("out1mf45", engine, 0.465, -0.787, -5.610));
output.addTerm(Linear.create("out1mf46", engine, 1.334, -3.017, -2.871));
output.addTerm(Linear.create("out1mf47", engine, 2.561, -0.864, -0.557));
output.addTerm(Linear.create("out1mf48", engine, 17.123, 11.150, 1.006));
output.addTerm(Linear.create("out1mf49", engine, 0.220, 0.154, 0.010));
engine.addOutputVariable(output);

RuleBlock ruleBlock = new RuleBlock();
ruleBlock.setEnabled(true);
ruleBlock.setName("");
ruleBlock.setConjunction(new AlgebraicProduct());
ruleBlock.setDisjunction(null);
ruleBlock.setImplication(null);
ruleBlock.setActivation(new General());
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf1 then output is out1mf1", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf2 then output is out1mf2", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf3 then output is out1mf3", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf4 then output is out1mf4", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf5 then output is out1mf5", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf6 then output is out1mf6", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf7 then output is out1mf7", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf1 then output is out1mf8", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf2 then output is out1mf9", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf3 then output is out1mf10", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf4 then output is out1mf11", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf5 then output is out1mf12", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf6 then output is out1mf13", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf7 then output is out1mf14", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf1 then output is out1mf15", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf2 then output is out1mf16", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf3 then output is out1mf17", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf4 then output is out1mf18", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf5 then output is out1mf19", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf6 then output is out1mf20", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf7 then output is out1mf21", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf1 then output is out1mf22", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf2 then output is out1mf23", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf3 then output is out1mf24", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf4 then output is out1mf25", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf5 then output is out1mf26", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf6 then output is out1mf27", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf7 then output is out1mf28", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf1 then output is out1mf29", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf2 then output is out1mf30", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf3 then output is out1mf31", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf4 then output is out1mf32", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf5 then output is out1mf33", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf6 then output is out1mf34", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf7 then output is out1mf35", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf1 then output is out1mf36", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf2 then output is out1mf37", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf3 then output is out1mf38", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf4 then output is out1mf39", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf5 then output is out1mf40", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf6 then output is out1mf41", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf7 then output is out1mf42", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf1 then output is out1mf43", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf2 then output is out1mf44", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf3 then output is out1mf45", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf4 then output is out1mf46", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf5 then output is out1mf47", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf6 then output is out1mf48", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf7 and input2 is in2mf7 then output is out1mf49", engine));
engine.addRuleBlock(ruleBlock);


}
}
