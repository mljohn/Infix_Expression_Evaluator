/**
 * File: ExpressionEvaluatorGui
 * Author: Michelle John
 * Date 21 January 2018
 * Purpose: Week 2 Evaluating Infix Expressions with Stacks
 */
package main;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingConstants.TRAILING;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.DivideByZeroException;
import exceptions.StackException;
import utils.ExpressionEvaluatorFrame;
import utils.ExpressionEvaluatorTextArea;

/**
 * Main class for the ExpressionEvaluator. This class builds and displays the GUI.
 */
public class ExpressionEvaluatorGui {

  /**
   * Entry point into the program. Builds the GUI.
   * 
   * @param args the arguments set at start
   */
  public static void main(String[] args) {
    
    ExpressionEvaluatorGui expressionGui = new ExpressionEvaluatorGui();
    expressionGui.buildExpressionGui();

  }
  
  /**
   * Method that builds the expression evaluator GUI.
   */
  private void buildExpressionGui() {
    
    ExpressionEvaluatorFrame frame = new ExpressionEvaluatorFrame("Evaluator", 450, 200);
    
    JPanel expressionPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JPanel guiPanel = new JPanel(new GridLayout(3, 1, 5, 5));
    
    JLabel expressionLabel = new JLabel("Enter Infix Expression:");
    JLabel resultLabel = new JLabel("Result:", TRAILING);
    ExpressionEvaluatorTextArea expressionTextArea = new ExpressionEvaluatorTextArea(true);
    ExpressionEvaluatorTextArea resultTextArea = new ExpressionEvaluatorTextArea(false);
    JButton evaluateButton = new JButton("Evaluate");
    
    evaluateButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        String expression = expressionTextArea.getText();
        if (expression.isEmpty() || expression == null) {
         showMessageDialog(frame, "Please enter a valid infix expression.");
        }
        try {
        ExpressionEvaluator evaluator = new ExpressionEvaluator(expression);
        resultTextArea.setText(evaluator.solveExpression().toString());
      } catch (StackException | NumberFormatException | DivideByZeroException ex) {
        showMessageDialog(frame, "The expression was not formatted properly. Error message is: " + ex.getMessage());
        }
      }
    });
    
    expressionPanel.add(expressionLabel);
    expressionPanel.add(expressionTextArea);
    buttonPanel.add(evaluateButton);
    resultPanel.add(resultLabel);
    resultPanel.add(resultTextArea);
    guiPanel.add(expressionPanel);
    guiPanel.add(buttonPanel);
    guiPanel.add(resultPanel);
    frame.add(guiPanel, CENTER);
    frame.add(new JPanel(), SOUTH);
    frame.add(new JPanel(), EAST);
    frame.add(new JPanel(), WEST);
    frame.add(new JPanel(), NORTH);
    frame.display();
  }
}
