import java.util.Iterator;
import java.util.ListIterator;

/**
 * MyArrayList is a smart array that has the characteristics 
 * of an ArrayList.
 * @author RakeshNori
 * @version 10/14/2017
 * @param <E> the ADT of the class
 */
public class MyArrayList<E> 
{
	private int size;
	private Object[] values;  //(Java doesn't let us make an array of type E)

	/**
	 * Creates a new MyArrayList object.
	 */
	public MyArrayList()
	{
		size = 0;
		values = new Object[1];
	}

	/**
	 * Gives the values stored inside the object.
	 * @return	the elements inside values.
	 */
	public String toString()
	{
		if (size == 0)
			return "[]";

		String s = "[";
		for (int i = 0; i < size - 1; i++)
			s += values[i] + ", ";
		return s + values[size - 1] + "]";
	}

	/**
	 * doubles the capacity of the values array.
	 * @postcondition	the array is replaced with one that has
	 * 					twice the size and the same values.
	 **/
	private void doubleCapacity()
	{
		Object [] temp = new Object[values.length * 2];
		for (int i = 0; i < values.length; i++)
		{
			temp[i] = values[i];
		}
		values = temp;
	}

	/**
	 * getCapacity gives the capacity of the values array.
	 * @return	the length of values.
	 */
	public int getCapacity()
	{
		return values.length;
	}

	/**
	 * Size gives the size of values, which is the number of actual elements in it.
	 * @return the size instance variable.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Get retrieves the element at the index of values.
	 * @param index the index that is being retrieved.
	 * @return the element.
	 */
	public E get(int index)
	{
		return ((E)values[index]);

		//(You will need to promise the return value is of type E.)
	}

	/**
	 * Set modifies the element at the passed in index of values.
	 * @param index	the index that will be modified.
	 * @param obj	the object replacing the old one
	 * @return the old object at the index.
	 * @postcondition The value of the array at position index is replaced 
	 * 				  with a new obj.
	 *               
	 */
	public E set(int index, E obj)
	{
		E temp = (E)values[index];
		values[index] = obj;
		return temp;		
	}

	/**
	 * Add appends an object to the end of the array.
	 * @param obj	the object being added
	 * @return true
	 * @postcondition	obj has been appended end of list
	 */
	public boolean add(E obj)
	{
		add(size, obj);
		return true;
	}

	/**
	 * The method removes the object at the given index from the array.
	 * @param index	the index of the object being removed.
	 * @return the object that was removed.
	 * @postcondition	removes element from position index, moving elements
	 *                  at position index + 1 and higher to the left
	 *                  (subtracts 1 from their indices) and adjusts size
	 */
	public E remove(int index)
	{
		Object val = values[index];
		size--;
		for (int i = index+1; i <= size; i++)
			values[i - 1] = values[i]; 
		//(You will need to promise the return value is of type E.)
		return (E)(val);
	}
	/**
	 * creates a new iterator.
	 * @return the iterator that was created.
	 */
	public Iterator<E> iterator()
	{
		return new MyArrayListIterator();
	}

	/**
	 * Adds object to a position index and slides everything else down.
	 * @param index the index of the new object.
	 * @param obj the object being added to the array.
	 * @precondition	0 <= index <= size
	 * @postcondition	inserts obj at position index,
	 *              	moving elements at position index and higher
	 *               	to the right (adds 1 to their indices) 
	 *               	and adjusts size.
	 */
	public void add(int index, E obj)
	{
		if (size == getCapacity())
			doubleCapacity();
		for (int i = size; i > index; i--)
			values[i]  = values[i-1];
		values[index] = obj;
		size++;
	}

	/**
	 * MyArrayList Iterator is the Iterator for MyArrayList.
	 * @author Rakesh Nori
	 * @version 10/14/2017
	 */
	private class MyArrayListIterator implements Iterator<E>
	{
		//the index of the value that will be returned by next()
		private int nextIndex;

		/**
		 * The constructor creates a new iterator object and sets
		 * its nextIndex to 0.
		 */
		public MyArrayListIterator()
		{
			nextIndex = 0;
		}

		/**
		 * hasNext checks if the iterator has a next value that it can return.
		 * @return true if there is a next value; otherwise,
		 * 		   false.
		 */
		public boolean hasNext()
		{
			return nextIndex < size();
		}

		/**
		 * next gives the next value of the array and increases nextIndex by 1.
		 * @return the next value that is traversed.
		 */
		public E next()
		{
			E val = ((E)values[nextIndex]);
			nextIndex++;
			return val;	
		}

		/**
		 * The method removes the last element that was called by next from the array.
		 * @precondition next must have been called previously for this method to run.
		 * @postcondition the last element that was returned by next is removed.
		 */
		public void remove()
		{
			MyArrayList.this.remove(nextIndex - 1);
		}
	}
}