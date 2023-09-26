package edu.trinity;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
    /**
     *
     * @param expression expression in String format
     * @return  value of the expression after evaluation
     */
    public static double evaluate(String expr) {
        if (expr == null || expr.isEmpty()) {
            throw new IllegalArgumentException("Expression is empty or null");
        }

        String[] tokens = expr.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                // If the token is a number, push it onto the stack.
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // If the token is an operator, pop the top two numbers from the stack,
                // perform the operation, and push the result back onto the stack.
                if (stack.size() < 2) {
                    throw new EmptyStackException();
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            stack.pop();
        }

        return stack.pop(); // top element is the result

    }
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static boolean isOperator(String str) {
        return str.matches("[+\\-*/]");
    }
    /**
     *
     * @param op operator in string format
     * @param n1 operand
     * @param n2 operand
     * @return  value of an expression (or a part of expression)
     */
    public static double applyOperator (String op,double n1, double n2){
        double temp_value = 0;  //stores temporary values
        if (!isOperator(op)){
            throw new IllegalArgumentException("Unrecognized operator: " + op);
        }
        else if (op.equals("+")) {                                               //cases 1-4
            temp_value = n1 + n2;
        } else if (op.equals("-")) {
            temp_value = n1 - n2;
        } else if (op.equals("*")) {
            temp_value = n1 * n2;
        } else if(op.equals("/")){
            if (n2 == 0){
                throw new IllegalArgumentException("Division by zero disallowed");
            }
            temp_value = n1 / n2;
        }
        return temp_value;
    }

}
