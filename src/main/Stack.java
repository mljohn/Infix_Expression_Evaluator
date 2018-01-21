/**
 * File: Stack
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package main;

import exceptions.StackException;

/**
 * Interface that defines a Stack for this application.
 *
 * @param <E> the type
 */
public interface Stack<E> {
  
  /**
   * Determines if the Stack is full.
   * 
   * @return if the stack is full
   */
  public boolean isFull();
  
  /**
   * Determines if the Stack is empty.
   * 
   * @return if the stack is empty
   */
  public boolean isEmpty();
  
  /**
   * Returns the top element of the stack without removing it.
   * 
   * @return the top element of the stack
   * @throws StackException if there is an error during this operation
   */
  public E peek() throws StackException;
  
  /**
   * Puts the item on the Stack.
   * 
   * @param item the item to push
   * @throws StackException if there is an error during this operation
   */
  public void push(E item) throws StackException;
  
  /**
   * Returns the top element of the Stack and removes it from the stack.
   * 
   * @return the top element of the stack
   * @throws StackException if there is an error during this operation
   */
  public E pop() throws StackException;
}
