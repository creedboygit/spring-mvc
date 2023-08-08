package org.example.calculate;

import org.example.calculate.kind.*;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicationOperator(),
            new DivisionOperator()
    );

    public static int caculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {

//        if ("+".equals(operator)) {
//
//            return operand1 + operand2;
//
//        } else if ("-".equals(operator)) {
//
//            return operand1 - operand2;
//
//        } else if ("*".equals(operator)) {
//
//            return operand1 * operand2;
//
//        } else if ("/".equals(operator)) {
//
//            return operand1 / operand2;
//        }
//
//        return 0;

//        return ArithmeticOperator.calculate(operand1, operator, operand2);

        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
