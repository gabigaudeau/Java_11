package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf()
        });

        for (String statement : statements) {

            String output = helper.process(statement);
            System.out.println(output);


        }
    }

    static void useCalculateHelper() {

        CalculateHelper helper = new CalculateHelper();

        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

//        try {
//            helper.process(statement);
//            System.out.println(helper);
//
//        } catch(InvalidStatementException e) {
//            System.out.println(e.getMessage());
//                if(e.getCause() != null)
//                    System.out.println("  Original exception: " + e.getCause().getMessage());;
//        }


        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
            new Divider(100.0d, 50.0d),
            new Adder(25.0d, 92.0d),
            new Subtractor(225.0d, 17.0d),
            new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators){
        calculator.calculate();
        System.out.print("result = ");
        System.out.println(calculator.getResult());

        }

    }

}