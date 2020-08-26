package com.mycompany.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(final CalculatorView theView, final CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		// Using an anonymous class instead of new CalculatorListener
		this.theView.addCalculateListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

					System.out.println(e.paramString());
					int firstNumber, secondNumber = 0;

					// Surround interactions with the view with
					// a try block in case numbers weren't
					// properly entered
					// System.out.println("Ett");

					try{

						firstNumber = theView.getFirstNumber();
						secondNumber = theView.getSecondNumber();

						theModel.addTwoNumbers(firstNumber, secondNumber);

						theView.setCalcSolution(theModel.getCalculationValue());

					}

					catch(NumberFormatException ex){

						System.out.println(ex);

						theView.displayErrorMessage("You Need to Enter 2 Integers");

					}
			}
		});
	}
	
	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			System.out.println(e.paramString());
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
      // properly entered
      // System.out.println("Ett");
			
			try{
			
				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();
				
				theModel.addTwoNumbers(firstNumber, secondNumber);
				
				theView.setCalcSolution(theModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				theView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	
}