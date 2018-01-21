/**
 * File: ExpressionEvaluator
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.DivideByZeroException;
import exceptions.StackException;

/**
 * Class that receives an infix expression, parses it into two stacks, then solves it.
 */
public class ExpressionEvaluator {

  private List<String> tokenizedExpression;
  private ArrayStack<Integer> operandStack;
  private ArrayStack<String> operatorStack;

  /**
   * Constructor.
   * 
   * @param expression the infix expression to evaluate
   */
  public ExpressionEvaluator(String expression) {
    tokenizedExpression = tokenizeExpression(expression);
  }

  /**
   * Method that takes the expression list and solves the expression.
   * 
   * @return the solution to the expression
   * @throws NumberFormatException if a number cannot be parsed from the string
   * @throws StackException if an error occurs while operating on a stack
   * @throws DivideByZeroException if an attempt is made to divide by zero
   */
  public Integer solveExpression() throws NumberFormatException, StackException, DivideByZeroException {
    operandStack = new ArrayStack<>();
    operatorStack = new ArrayStack<>();
    for (String element : tokenizedExpression) {
      if (isAnInteger(element)) {
        operandStack.push(Integer.parseInt(element));
      } else if ("(".equals(element)) {
        operatorStack.push(element);
      } else if (")".equals(element)) {
        while (!"(".equals(operatorStack.peek())) {
          doMath();
        }
        operatorStack.pop();
      } else {
        while (!operatorStack.isEmpty() 
            && isHigherOrEqualPrecedenceTo(element) 
            && !"(".equals(operatorStack.peek())) {
          doMath();
        }
        operatorStack.push(element);
      }
    }
    
    while (!operatorStack.isEmpty()) {
      doMath();
    }

    return operandStack.peek();
  }

  /**
   * Method that takes the infix expression and turns it into a {@link List} of type {@link String}.
   * 
   * @param expression the infix expression to parse
   * @return the {@link List} of {@link String}s
   */
  private List<String> tokenizeExpression(String expression) {

    List<String> output = new ArrayList<>();
    Matcher match = Pattern.compile("[/*+()-]|[0-9]+").matcher(expression);
    while (match.find()) {
      output.add(match.group().trim());
    }
    return output;
  }

  /**
   * Method that determines if the string is an integer.
   * 
   * @param integer the string that may be an integer
   * @return if the string is an integer
   */
  private boolean isAnInteger(String integer) {
    try {
      Integer.parseInt(integer);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }
  
  /**
   * Method that determines what the operator on the stack is and performs the necessary math.
   * 
   * @throws StackException if an issue occurs while performing a {@link Stack} operation
   * @throws DivideByZeroException if a division by zero is attempted
   */
  private void doMath() throws StackException, DivideByZeroException {
    int operand2 = operandStack.pop();
    int operand1 = operandStack.pop();
    String operator = operatorStack.pop();
    switch (operator) {
      case "+":
        operandStack.push(operand1 + operand2);
        break;
      case "-":
        operandStack.push(operand1 - operand2);
        break;
      case "*":
        operandStack.push(operand1 * operand2);
        break;
      case "/":
        if (operand2 == 0) {
          throw new DivideByZeroException("Division by zero occured. Invalid expression");
        }
        operandStack.push(operand1 / operand2);
        break;
      case "(":
        operatorStack.pop();
        break;
    }
    
  }
  
  /**
   * Method that determines if the next operator in the list is of equal or higher precedence to the 
   * top operator on the stack.
   * 
   * @param element the current element in the expression list
   * @return if the element is of equal or higher precedence
   * @throws StackException if an issue occurs while performing a {@link Stack} operation
   */
  private boolean isHigherOrEqualPrecedenceTo(String element) throws StackException {
    String current = operatorStack.peek();
    if (("+".equals(current) || "-".equals(current)) && ("/".equals(element) || "*".equals(element))) {
      return false;
    }
    return true;
  }
}
