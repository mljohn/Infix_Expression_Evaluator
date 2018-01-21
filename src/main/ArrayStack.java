/**
 * File: ArrayStack
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package main;

import exceptions.StackException;

/**
 * Class that implements the {@link Stack} interface.
 *
 * @param <E> the type of the ArrayStack
 */
public class ArrayStack<E> implements Stack<E> {
  
  private static final String STACK_IS_FULL = "The stack is full";
  private static final String STACK_IS_EMPTY = "The stack is empty";
  private static int DEFAULT_SIZE = 10;
  private E elements[];
  private int numberOfElements = 0;
  
  /**
   * Default constructor.
   */
  public ArrayStack() {
    this(DEFAULT_SIZE);
  }
  
  /**
   * Constructor.
   * 
   * @param size the initial size of the stack
   */
  @SuppressWarnings("unchecked")
  public ArrayStack(int size) {
    elements = (E[]) new Object[size];
  }

  @Override
  public boolean isFull() {
    if (numberOfElements == elements.length) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    if (numberOfElements == 0) {
      return true;
    }
    return false;
  }

  @Override
  public E peek() throws StackException {
    if (numberOfElements == 0) {
      throw new StackException(STACK_IS_EMPTY);
    }
    return elements[numberOfElements - 1];
  }

  @Override
  public void push(E item) throws StackException {
    if (numberOfElements == elements.length) {
      throw new StackException(STACK_IS_FULL);
    }
    elements[numberOfElements] = item;
    numberOfElements++;
  }

  @Override
  public E pop() throws StackException {
    if (numberOfElements == 0) {
      throw new StackException(STACK_IS_EMPTY);
    }
    E elementToReturn = elements[numberOfElements - 1];
    numberOfElements--;
    return elementToReturn;
  }
}
