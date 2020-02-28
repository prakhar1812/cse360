package cse360assign2;

/**
 * @author Prakhar Bajpayee
 * Class: CSE 360
 * Class ID: 215
 * Assignment Number: 2
 * Description: Basic array operations to declare, add (increase size dynamically), remove (decrease size dynamically), keep count, search, append, first and last element of the array and return values.
 * */

public class SimpleList {
	private int[] list;  //declaring array
	private int count;
	public int size;
	public int[] temp;


	/**
	 * Constructor to initialize size as 10, declare list an int array of size "size".
	 * 
	 * 
	 * */
	public SimpleList() { // as per method requirement
		size = 10;
		list = new int[size];  // allocating required memory to array
		count = 0;
	}

	
	/**
	 * add(int number) adds a number to the array in the first position of the array. If the array is 
	 * full it dynamically reallocates and resizes the array.
	 * <p>
	 * @param (int) number: takes in the number to add into the array.
	 * */
	
	public void add(int number) {// as per method requirement
		if(count == 0)
		{
			list[0] = number;
			count++;
		}

		else if (count < 10)
		{
			for(int i = count-1; i >= 0; i--)
			{
				list[i+1]=list[i];
			}
			list[0] = number;
			count++;
		}
		else
		{
			size = (int) Math.ceil(size*1.5);
			temp = new int[size];
			for(int i  = 0; i < list.length; i++)
			{
				temp[i] = list [i];
			}
			list = new int[size];
			for(int i = 0; i < size; i++)
			{
				list[i+1] = temp[i];
			}
			list[0] = number;

			count++;




//			for(int i = 8; i >= 0; i--) {
//				list[i+1]=list[i];
//			}
//			list[0] = number;
//			count = 10;
		}
	}

	/**
	 * int count(): returns count of numbers in the array.
	 * */
	
	public int count() { // as per method requirement
		return count; //returns current count.
	}

	/**
	 * String toString(): returns a string of all elements in the array as a string seperated by a " "
	 * Trims the ends and the beginning of the array to remove extra spaces in the beginning or the end.
	 * */
	
	public String toString() { // as per method requirement
		String toReturn = "";
		for(int i = 0; i < count; i++)
		{
			toReturn += " " + list[i];
		}
		return toReturn.trim(); //to eliminate unnecessary white spaces
	}

	/**
	 * int search(int find)
	 * basic search traverses the entire array and returns index if found, otherwise returns -1.
	 * 
	 *<p>
	 *@param (int) find: the number to be found in the link.
	 * */
	
	public int search(int find) // as per method requirement
	{ //basic search traverses the entire array and returns index if found, otherwise returns -1.
		int i = 0;
		int j = -1;
		for (i = 0; i < count; i++)
		{
			if(list[i] == find)
			{
				j = i;
			}
		}

		return j;
	}

	
	/**
	 * void remove(int remove):
	 * 
	 * uses the search method to find the index of the element to remove and then shifts the array by element to remove the element.
	 * <p>
	 * It also dynamically resizes the list if 25% of the list is empty
	 * @param (int) remove: the element to be removed.
	 * */
	public void remove(int remove) // as per method requirement
	{
		int i = search(remove); // to get the element index of the element to be removed.

		if(i != -1 && i >= 0 && i < 10) // when and only when the element is present the loop is executed.
		{
			for(int k = i; k < count-1; k++) //we go one less that count to avoid arrayIndexOutOfBounds error
			{
				list[k] = list[k+1];
			}
			count--;
		}


		size = (int) Math.ceil(size*0.75);
		temp = new int[size];
		for( int k = 0; k < size; k++)
		{
			temp[k] = list[k];
		}
		list = new int[size];
		for(int k = 0; k < size; k++)
		{
			list[k] = temp[k];
		}

		count--;

		if(count < 0)
			count = 0;
	}

	
	/**
	 * void append(int number): appends a number at the end of the list. if the list is full, dynamically increases the size of the array.
	 * <p>
	 * @param (int) number: number to add at the end.
	 * */
	
	public void append(int number)
	{
		if(count == size)
		{
			size = (int) Math.ceil(size*1.5);
			temp = new int[size];
			for(int i  = 0; i < list.length; i++)
			{
				temp[i] = list [i];
			}
			list = new int[size];
			for(int i = 0; i<size; i++)
			{
				list[i] = temp[i];
			}
		}
		count++;
		list[count] = number;

	}

	/**
	 * int first(): returns the first element of the list.
	 * */
	
	public int first()
	{
		if(count == 0)
			return -1;

		else
			return list[0];
	}

	/**
	 * int last(): returns the last element of the list.
	 * */
	public int last()
	{
		if(count == 0)
			return -1;

		else
			return list[count];
	}
	/**
	 * int size(): returns the size of the list.
	 * */
	public int size()
	{
		return list.length;
	}
}