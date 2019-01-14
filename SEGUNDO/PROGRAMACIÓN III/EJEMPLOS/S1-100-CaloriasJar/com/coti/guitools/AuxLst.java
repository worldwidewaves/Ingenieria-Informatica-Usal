package com.coti.tools;
/*
 *@author coti
 *@version 1.0
 *
 */
public class AuxLst {
/*
	The following methods will try to return the extreme values
	to be found within the elements of a list passed to them
	
	12/12/11 17:14
*/
	public static int findMax(float [] f) {
/*
 *@param	The findMax() method takes one list of floats, f[]
 *@return	It returns the index of an element which has the
					maximum value or -1 in case of error.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMax has received a null list");
			return -1;
		}
		float temp =  Float.NaN;
		int index = -1;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null float list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, float list empty\n");
				else
					{
						temp = f[0];
						index = -1;
						for(int i=0;i<list_length;i++)
							if (temp < f[i])
								{
									temp = f[i];
									index = i;
								}
				}
			}
		return index;
	}
	public static int findMax(double [] f) {
/*
 *@param	The findMax() method takes one list of doubles, f[]
 *@return	It returns the index of an element that has maximum value
 					or -1 in case or error.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMax has received a null list");
			return -1;
		}
		double temp =  Double.NaN;
		int index = -1;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null double list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, double list empty\n");
				else
					{
						temp = f[0];
						index = 0;
						for(int i=0;i<list_length;i++)
							if (temp < f[i])
								{
									temp = f[i];
									index = i;
								}
				}
			}
		return index;
	}
	public static int findMax(int [] f) {
/*
 *@param	The findMax() method takes one list of ints, f[]
 *@return	It returns an int, if the list contains at leas one element,
 					or Integer.MAX_VALUE otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMax has received a null list");
			return -1;
		}
		int temp =  Integer.MAX_VALUE;
		int index = -1;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null int list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, int list empty\n");
				else
					{
						temp = f[0];
						index = 0;
						for(int i=0;i<list_length;i++)
							if (temp < f[i])
								{
									temp = f[i];
									index = i;
								}
					}
			}
		return index;
	}
/*
	The following methods will try to return the minimum value
	to be found within the elements of a list passed to them
*/
	public static int findMin(float [] f) {
/*
 *@param The findMin() method takes one list of floats, f[]
 *@return It returns a float, if the list contains at leas one element, or Float.NaN otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMin has received a null list");
			return -1;
		}
		float temp =  Float.NaN;
		int list_length;
		int index = -1;
		if (null == f)
			System.err.println("\n\nSorry, null float list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, float list empty\n");
				else
					{
						temp = f[0];
						index = 0;
						for(int i=0;i<list_length;i++)
							if (temp > f[i])
								{
									temp = f[i];
									index = i;
								}
				}
			}
		return index;
	}
	public static int findMin(double [] f) {
/*
 *@param The findMin() method takes one list of doubles, f[]
 *@return It returns a double, if the list contains at leas one element, or Double.NaN otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMin has received a null list");
			return -1;
		}
		double temp =  Double.NaN;
		int list_length;
		int index = -1;
		if (null == f)
			System.err.println("\n\nSorry, null double list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, double list empty\n");
				else
					{
						temp = f[0];
						index = 0;
						for(int i=0;i<list_length;i++)
							if (temp > f[i])
								{
									temp = f[i];
									index = i;
								}
				}
			}
		return index;
	}
	public static int findMin(int [] f) {
/*
 *@param	The findMin() method takes one list of ints, f[]
 *@return	It returns an int, if the list contains at leas one element,
					or Integer.MAX_VALUE otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findMin has received a null list");
			return -1;
		}
		int temp =  Integer.MAX_VALUE;
		int list_length;
		int index = -1;
		if (null == f)
			System.err.println("\n\nSorry, null int list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, int list empty\n");
				else
					{
						temp = f[0];
						index = 0;
						for(int i=0;i<list_length;i++)
							if (temp > f[i])
								{
									temp = f[i];
									index = i;
								}
				}
			}
		return index;
	}
/*
	The following methods will try to return the average value
	of the elements that comprise the list passed to them
*/
	public static float findSum(float [] f) {
/*
 *@param The findSum() method takes one list of floats, f[]
 *@return It returns a float, if the list contains at leas one element, or Float.Nan otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findSum has received a null list");
			return -1;
		}
		float temp =  Float.NaN;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null float list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, float list empty\n");
				else
					{
						temp = 0.0F;
						for(int i=0;i<list_length;i++)
							temp+= f[i];
					}
			}
		return temp;
	}
	public static double findSum(double [] f) {
/*
 *@param	The findSum() method takes one list of doubles, f[]
 *@return	It returns a double, if the list contains at least one element,
					or Double.NaN otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findSum has received a null list");
			return -1;
		}
		double temp =  Double.NaN;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null double list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, double list empty\n");
				else
					{
						temp = 0.0;
						for(int i=0;i<list_length;i++)
							temp+= f[i];
					}
			}
		return temp;
	}
	public static int findSum(int [] f) {
/*
 *@param	The findSum() method takes one list of ints, f[]
 *@return It returns an int, if the list contains at leas one element,
 					or Integer.MAX_VALUE otherwise.
 */
	 if (null == f)
		{
			System.out.println("Sorry, findSum has received a null list");
			return -1;
		}
		int temp =  Integer.MAX_VALUE;
		int list_length;
		if (null == f)
			System.err.println("\n\nSorry, null int list\n");
		else
			{
				list_length = f.length;
				if (0 == list_length)
					System.err.println("\n\nSorry, int list empty\n");
				else
					{
						temp = 0;
						for(int i=0;i<list_length;i++)
							temp+= f[i];
					}
			}
		return temp;
	}

} /* End of AuxLst */