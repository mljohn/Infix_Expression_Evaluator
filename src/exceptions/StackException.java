/**
 * File: StackException
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package exceptions;

/**
 * Custom {@link Exception} that is thrown if there is a problem with a Stack operation.
 */
public class StackException extends Exception {
  
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   */
  public StackException() {
    super();
  }
  
  /**
   * Constructor.
   * 
   * @param message the message to show
   */
  public StackException(String message) {
    super(message);
  }
}
