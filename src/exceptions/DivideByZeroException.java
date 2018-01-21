/**
 * File: DivideByZeroException
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package exceptions;

/**
 * Custom {@link Exception} that is thrown if a division by zero is attempted.
 *
 */
public class DivideByZeroException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   */
  public DivideByZeroException() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param message the message to show
   */
  public DivideByZeroException(String message) {
    super(message);
  }
}
