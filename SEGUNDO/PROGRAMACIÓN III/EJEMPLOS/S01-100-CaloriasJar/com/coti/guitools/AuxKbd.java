package com.coti.tools;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class AuxKbd {
	/*
	*@author coti
   *@version 1.1
   *
   * This is a set of tools for reading from the keyboard.
   *
   12/12/11 17:14
	*/
	static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

/****************************************************************************
	The methods readLine() and readLines() read whole lines from the keyboard
	and give them back as a String or String[].
****************************************************************************/
	public static String readLine() {
	/*
	*
	*@param This method takes no parameters; it alwasy reads from the keyboard.
	*@return This method returns an instance of String, or null in case of error.
	*
	*/
		String temp;
		try
			{
				temp = br.readLine();
			}
		catch (Exception e)
			{
				System.out.println("\nReading error.\n");
				temp = null;
			}
		return temp;
	}

	public static String[] readLines() {
	/*
	*
	*@param This method takes no parameters; it alwasy reads from the keyboard.
	*@return This method returns an instance of String[], or null in case of error.
	*
	*/
		String temp;
		Vector<String> line_vector = new Vector<String>();
		String[] line_list = null;
		do {
			try
				{
					temp = br.readLine();
				}
			catch (Exception e)
				{
					System.out.println("\nReading error.\n");
					temp = null;
				}
			if (temp.length()!=0)
				line_vector.add(temp);
		} while(temp.length() != 0);
		line_list = new String[line_vector.size()];
		line_vector.toArray(line_list);
		return line_list;
	}
	
/****************************************************************************
	The following methods are overloaded. There are three versions for each
	of them: one that takes no parmeters, one that takes a String that will
	be used as a prompt, and one that takes both a String and two numbers
	that will be used as inclusive lower and upper limits. In this way, we
	can impose a measure of validity on the numbers we read. The next methods
	process integer numbers.
****************************************************************************/
	
	public static int readInt() {
	/*
	*
	*@param This method no parameters.
	*@return This method returns an int; it will ask repeatedly for an int until
	*				given a valid integer.
	*
	*/
		String temp;
		int result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					temp = br.readLine();
					result = Integer.parseInt(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading an int.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}
	public static int readInt(String prompt) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a real parameter, no prompt is shown.
	*@return This method returns an int; it will ask repeatedly for an int until
	*				given a valid integer.
	*
	*/
		String temp;
		int result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Integer.parseInt(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading an int - please enter a valid integer.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}

	public static int readInt(String prompt, int lower_limit, int upper_limit) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a real parameter, no prompt is shown.
	*			It also takes two numbers, lower_limit and upper_limit, which will
	*			be used as a validation. The method will produce a fatal error if
	*			given an upper_limit that is not bigger than the lower_limit.
	*@return This method returns an int; it will ask repeatedly for an int until
	*				given a valid integer.
	*
	*/
		if (upper_limit < lower_limit)
			{
				System.err.println("\n\nFatal error - readInt received an upper_limit bigger than lower_limit.");
				System.err.println("\n\nProgram will now exit.\n\n");
				System.exit(1);
			}
		String temp;
		int result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Integer.parseInt(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading an int - please enter a valid integer.\n\n");
					valid = false;
				}
			if (valid)
				if (result < lower_limit || result > upper_limit)
					{
						System.err.print("\n\nSorry, you must enter a number between ");
						System.err.println(lower_limit + " and " + upper_limit);
						valid = false;
					}
		} while(!valid);
		return result;
	}
/*
	We shall now build analog methods for float and double numbers. Thus we facilitate the
	construction of programs in which the validity of numerical data is easy to impose.
*/
	public static float readFloat() {
	/*
	*
	*@param This method no parameters.
	*@return This method returns an float; it will ask repeatedly for a float until
	*				given a valid real number.
	*
	*/
		String temp;
		float result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					temp = br.readLine();
					result = Float.parseFloat(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a float.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}
	public static float readFloat(String prompt) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a parameter, no prompt is shown.
	*@return This method returns a float; it will ask repeatedly for a real number until
	*				given a valid float.
	*
	*/
		String temp;
		float result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Float.parseFloat(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a float - please enter a valid float.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}

	public static float readFloat(String prompt, float lower_limit, float upper_limit) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a real parameter, no prompt is shown.
	*			It also takes two numbers, lower_limit and upper_limit, which will
	*			be used as a validation. The method will produce a fatal error if
	*			given an upper_limit that is not bigger than the lower_limit.
	*@return This method returns a float; it will ask repeatedly for a float until
	*				given a valid real number.
	*
	*/
		if (upper_limit < lower_limit)
			{
				System.err.println("\n\nFatal error - readFloat received an upper_limit bigger than lower_limit.");
				System.err.println("\n\nProgram will now exit.\n\n");
				System.exit(1);
			}
		String temp;
		float result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Float.parseFloat(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a float - please enter a valid float.\n\n");
					valid = false;
				}
			if (valid)
				if (result < lower_limit || result > upper_limit)
					{
						System.err.print("\n\nSorry, you must enter a number between ");
						System.err.println(lower_limit + " and " + upper_limit);
						valid = false;
					}
		} while(!valid);
		return result;
	}
	/*
		And these are the methods necessary to deal with double precision numbers.
	*/
	public static double readDouble() {
	/*
	*
	*@param This method no parameters.
	*@return This method returns a double; it will ask repeatedly for a double until
	*				given a valid double precision number.
	*
	*/
		String temp;
		double result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					temp = br.readLine();
					result = Double.parseDouble(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a double.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}
	public static double readDouble(String prompt) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a real parameter, no prompt is shown.
	*@return This method returns a double; it will ask repeatedly for a double until
	*				given a valid double number.
	*
	*/
		String temp;
		double result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Double.parseDouble(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a double - please enter a valid double precision number.\n\n");
					valid = false;
				}
		} while(!valid);
		return result;
	}

	public static double readDouble(String prompt, double lower_limit, double upper_limit) {
	/*
	*
	*@param This method takes a String as its parameter, which will be used as a
	*       prompt. If null is passed as a real parameter, no prompt is shown.
	*			It also takes two numbers, lower_limit and upper_limit, which will
	*			be used as a validation. The method will produce a fatal error if
	*			given an upper_limit that is not bigger than the lower_limit.
	*@return This method returns a double; it will ask repeatedly for a double until
	*				given a valid double precision number.
	*
	*/
		if (upper_limit < lower_limit)
			{
				System.err.println("\n\nFatal error - readDouble received an upper_limit bigger than lower_limit.");
				System.err.println("\n\nProgram will now exit.\n\n");
				System.exit(1);
			}
		String temp;
		double result = 0;
		boolean valid = true;
		do {
			try
				{
					valid = true;
					if (null != prompt)
						System.out.print(prompt);
					temp = br.readLine();
					result = Double.parseDouble(temp);
				}
			catch (Exception e)
				{
					System.out.println("\nError when reading a double precision number - please enter a valid double number.\n\n");
					valid = false;
				}
			if (valid)
				if (result < lower_limit || result > upper_limit)
					{
						System.err.print("\n\n a number between ");
						System.err.println(lower_limit + " and " + upper_limit);
						valid = false;
					}
		} while(!valid);
		return result;
	}

/*
	How about reading many ints, floats or doubles?
*/

	public static int[] readInts() {
	/*
	*
	*@param This method takes no parameters; it alwasy reads from the keyboard.
	*@return This method returns an instance of int[] or null in case of error.
	*
	*/
		String temp = null;
		int temp2 = 0;
		int list_length = 0;
		boolean correct=false, empty=false;
		Vector<String> line_vector = new Vector<String>();
		String[] line_list = null;
		int[] int_list = null;
		do {
					do
						{
							try
								{
									temp = readLine();
								}
							catch(Exception e)
								{
									e.printStackTrace();
								};
							empty = temp.length() == 0;
							correct = false;
							if (!empty)
								{
									correct = true;
									try
										{
											temp2 = Integer.parseInt(temp);
										}
									catch(Exception e)
										{
											correct = false;
											System.out.println("\n\nThis number is not valid - please try again\n\n");
										}
								}
							} while (!empty && !correct);
					if (correct)
						line_vector.add(temp);
		} while(!empty);
		line_list = new String[line_vector.size()];
		line_vector.toArray(line_list);
		list_length = line_list.length;
		int_list = new int[list_length];
		for(int i=0;i<list_length;i++)
			int_list[i] = Integer.parseInt(line_list[i]);
		return int_list;
	}
	
	public static float[] readFloats() {
	/*
	*
	*@param This method takes no parameters; it alwasy reads from the keyboard.
	*@return This method returns an instance of float[] or null in case of error.
	*
	*/
		String temp = null;
		float temp2 = 0;
		int list_length = 0;
		boolean correct=false, empty=false;
		Vector<String> line_vector = new Vector<String>();
		String[] line_list = null;
		float[] float_list = null;
		do {
					do
						{
							try
								{
									temp = readLine();
								}
							catch(Exception e)
								{
									e.printStackTrace();
								};
							empty = temp.length() == 0;
							correct = false;
							if (!empty)
								{
									correct = true;
									try
										{
											temp2 = Float.parseFloat(temp);
										}
									catch(Exception e)
										{
											correct = false;
											System.out.println("\n\nThis number is not valid - please try again\n\n");
										}
								}
							} while (!empty && !correct);
					if (correct)
						line_vector.add(temp);
		} while(!empty);
		line_list = new String[line_vector.size()];
		line_vector.toArray(line_list);
		list_length = line_list.length;
		float_list = new float[list_length];
		for(int i=0;i<list_length;i++)
			float_list[i] = Float.parseFloat(line_list[i]);
		return float_list;
	}
	
	public static double[] readDoubles() {
	/*
	*
	*@param This method takes no parameters; it always reads from the keyboard.
	*@return This method returns an instance of double[] or null in case of error.
	*
	*/
		String temp = null;
		double temp2 = 0;
		int list_length = 0;
		boolean correct=false, empty=false;
		Vector<String> line_vector = new Vector<String>();
		String[] line_list = null;
		double[] double_list = null;
		do {
					do
						{
							try
								{
									temp = readLine();
								}
							catch(Exception e)
								{
									e.printStackTrace();
								};
							empty = temp.length() == 0;
							correct = false;
							if (!empty)
								{
									correct = true;
									try
										{
											temp2 = Double.parseDouble(temp);
										}
									catch(Exception e)
										{
											correct = false;
											System.out.println("\n\nThis number is not valid - please try again\n\n");
										}
								}
							} while (!empty && !correct);
					if (correct)
						line_vector.add(temp);
		} while(!empty);
		line_list = new String[line_vector.size()];
		line_vector.toArray(line_list);
		list_length = line_list.length;
		double_list = new double[list_length];
		for(int i=0;i<list_length;i++)
			double_list[i] = Double.parseDouble(line_list[i]);
		return double_list;
	}
	

} /* This is the end of the class */