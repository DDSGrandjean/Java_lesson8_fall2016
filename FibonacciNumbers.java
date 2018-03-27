/**
 * COMI2510 - Advanced Java Programming
 * 
 * Program which get the fibonacci number requested
 * by the user and shows the time it took for the computer to get
 * to that number.
 * 
 * @author Dylan Grandjean
 *
 */
import javax.swing.JOptionPane;

public class FibonacciNumbers
{
	//Fields
	static int num;
	static String numberList;
	
	/**
	 * main method - get user input and
	 * call on other methods to process
	 * input.
	 * @param args - Array of String
	 */
	public static void main(String[] args)
	{
		String input;
		boolean keepGoing = true;
		int num1;
		int num2;
		double fibo1Time;
		double fibo2Time;
		long startTime;
		long endTime;
		
		do
		{
			//Reset the list
			numberList = "";
				
			//Prompt user for input
			input = JOptionPane.showInputDialog(null, "Enter the amount of fibonacci\nnumbers you would like me to add up together", "Fibonacci's", JOptionPane.QUESTION_MESSAGE);
		
			//Test for valid input
			while(!checkString(input))
				input = JOptionPane.showInputDialog(null, "Please enter a valid NUMBER", "Error");
			
			startTime = System.nanoTime();
			num1 = fibNumbers(num);
			endTime = System.nanoTime();
			fibo1Time = (endTime - startTime);
			
			startTime = System.nanoTime();
			num2 = myFib(num);
			endTime = System.nanoTime();
			fibo2Time = (endTime - startTime);
			
			JOptionPane.showMessageDialog(null,  String.format("Fibonacci number found: %d\n\nRecursive time:\n%,.10f seconds\n%,.10f milliseconds\n\nIterative time:\n%,.10f seconds\n%,.10f milliseconds", num1, fibo1Time/1000000000, fibo1Time/1000000, fibo2Time/1000000000, fibo2Time/1000000));
			num1 = JOptionPane.showConfirmDialog(null, "Would you like to enter a different number?");
			if(num1 == 1 || num1 == 2)
				System.exit(0);	
		} while(keepGoing);
	}
	
	/**
	 * checkString method - checks a string to assess its 
	 * content and whether it can be converted to an int or not.
	 * @param in - user input.
	 * @return Whether the string can be converted or not.
	 */
	public static boolean checkString(String in)
	{
		try
		{
			//Handle closing or canceling
			if(in == null)
				System.exit(0);
			
			//Attempts to convert String to int
			num = Integer.parseInt(in);
			
			if(num < 0)
				return false;
			else
				return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * Calculates the nth number in 
	 * the fibonacci series.
	 * @param n - The nth number to calculate.
	 * @return - The nth number.
	 */
	public static int fibNumbers(int n)
	{
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibNumbers(n - 1) + fibNumbers(n - 2);
	}
	
	/**
	 * Calculate the nth number in
	 * the fibonacci series.
	 * @param n - The nth number to calculate.
	 * @return - The nth number.
	 */
	public static int myFib(int n)
	{
		int sum = 0;
		int last = 1;
		int current = 2;
		
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		else
			for(int i = 0; i < n; i++)
			{
				sum += last + current;
				last = current;
				current = sum;
			}
			return sum;
	}
}
