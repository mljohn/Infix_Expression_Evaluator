/**
 * File: ExpressionEvaluatorFrame
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package utils;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Custom implementation of {@link JFrame} for this application.
 */
public class ExpressionEvaluatorFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param title the title of the frame
   * @param width the width of the frame
   * @param height the height of the frame
   */
  public ExpressionEvaluatorFrame(String title, int width, int height) {
    super(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(5, 5));
  }
  
  /**
   * Displays the GUI.
   */
  public void display() {
    setVisible(true);
  }

}
