import java.util.Iterator;
import java.util.ListIterator;

/**
 * MyLinkedList is a DoublyLinkedList that uses DoubleNodes 
 * to store data items.
 * @author Rakesh Nori
 * @version 10/23/2017
 *
 * @param <E>	the ADT(Abstract Data Type) for the LinkedList, which
 * 			    the user can choose when creating a MyLinkedList object.
 */
public class MyLinkedList<E>
{
	private DoubleNode first;
	private DoubleNode last;
	private int size;

	/**
	 * Constructor for MyLinkedList sets the first node and last node to 
	 * null. Also initializes the size to 0 since the LinkedList begins 
	 * empty.
	 */
	public MyLinkedList()
	{
		first = null;
		last = null;
		size = 0;
	}

	/**
	 * Outputs the values stored inside the object when called.
	 * @return	the values inside each DoubleNode of the LinkedList.
	 */
	public String toString()
	{
		DoubleNode node = first;
		if (node == null)
			return "[]";
		String s = "[";
		while (node.getNext() != null)
		{
			s += node.getValue() + ", ";
			node = node.getNext();
		}
		return s + node.getValue() + "]";
	}

	/**
	 * Retrieves a node starting from the first node.
	 * @param	index	The index of the node you want.
	 * @return	the node located at the given index.
	 * @precondition	0 <= index <= size / 2
	 * @postcondition	starting from first, returns the node
	 *                  with given index (where index 0
	 *                  returns first).
	 */
	private DoubleNode getNodeFromFirst(int index)
	{
		DoubleNode node = first;
		for (int i = 0; i < index; i++)
			node = node.getNext();
		return node;
	}

	/**
	 * Retrieves a node starting from the last node.
	 * @param	index	the index of the node you want.
	 * @return	the node located at the index.
	 * @precondition	size / 2 <= index < size
	 * @postcondition	starting from last, returns the node
	 *               	with given index (where index size-1
	 *              	returns last).
	 */
	private DoubleNode getNodeFromLast(int index)
	{
		DoubleNode node = last;
		for (int i = size - 1; i > index; i--)
			node = node.getPrevious();
		return node;
	}

	/**
	 * Gets the node given a specific index. 
	 * @param	index	the index of the node you want.
	 * @return	the node you want.
	 * @precondition	0 <= index < size
	 * @postcondition	starting from first or last (whichever
	 *               	is closer), returns the node with given
	 *              	index.	
	 */
	private DoubleNode getNode(int index)
	{
		if (size - index <= index)
			return getNodeFromLast(index);
		else
			return getNodeFromFirst(index);
	}
	
	/**
	 * Gives size of the MyLinkedList object.
	 * @return	the number of DoubleNodes present in the 
	 * MyLinkedList object.
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Gets the value stored inside the node at a given index.
	 * @param index	the index of the node you want.
	 * @return	the value the node contains. 
	 */
	public E get(int index)
	{
		return (E)getNode(index).getValue();

		//(You will need to promise the return value is of type E.)
	}

	/**
	 * Changes the value stored inside the DoubleNode located at a
	 * given index.
	 * @param index	the index of the DoubleNode
	 * @param obj	the object that will replace the old object.
	 * @return	the old object that was stored.
	 * @postcondition	replaces the element at position index with obj
	 *                  returns the element formerly at the 
	 * 					specified position.
	 */
	public E set(int index, E obj)
	{
		DoubleNode curr = getNode(index);
		E prev = (E)curr.getValue();
		curr.setValue(obj);
		return prev;
		
		//(You will need to promise the return value is of type E.)
	}

	/**
	 * Adds a new DoubleNode that has a given obj inside of it 
	 * to the end of the MyLinkedList object.
	 * @param obj	the value that will be added to the end.
	 * @return	true
	 * @postcondition	appends obj to the end of the list; returns true
	 */
	public boolean add(E obj)
	{
		DoubleNode newLast = new DoubleNode(obj);
		if (last != null)
		{
			last.setNext(newLast);
			last.getNext().setPrevious(last);
		}
		else
		{
			first = newLast;
		}
		last = newLast;
		size++;
		return true;
	}

	/**
	 * Removes a node at a given index.
	 * @param index	the index of the node that will be removed.
	 * @return	the element inside the node that was removed.
	 * @postcondition removes element from position index, moving 
	 * 				  elements at position index + 1 and higher 
	 * 				  to the left (subtracts 1 from their indices) 
	 * 				  and adjusts size returns the element formerly at 
	 *                the specified position.
	 */
	public E remove(int index)
	{
		DoubleNode rem = getNode(index);
		if (size == 1)
		{
			first = null;
			last = null;
		}
		else if (index == size - 1)
		{
			rem.getPrevious().setNext(null);
			last = rem.getPrevious();
			rem.setPrevious(null);
		}
		else if (index == 0)
		{
			rem.getNext().setPrevious(null);
			first = rem.getNext();
			rem.setNext(null);
		}
		else
		{
			rem.getNext().setPrevious(rem.getPrevious());
			rem.getPrevious().setNext(rem.getNext());
			rem.setPrevious(null);
			rem.setNext(null);	
		}
		size--;
		return (E)rem.getValue();
	}

	/**
	 * Adds a new node to the end of the MyLinkedList object.
	 * @param index	the index of the node that will be added.
	 * @param obj	the value stored inside the DoubleNode.
	 * @precondition	0 <= index <= size
	 * @postcondition	inserts obj at position index,
	 *             	    moving elements at position index and higher
	 *                  to the right (adds 1 to their indices)
	 * 					 and adjusts size.
	 */
	public void add(int index, E obj)
	{
		if (index == 0)
			addFirst(obj);
		else if (index == size)
			addLast(obj);
		else
		{
			DoubleNode old = getNode(index);
			DoubleNode add = new DoubleNode(obj);
			add.setNext(old);
			add.setPrevious(old.getPrevious());
			if (old.getPrevious() != null)
				old.getPrevious().setNext(add);
			old.setPrevious(add);
			size++;
		}
	}

	/**
	 * Adds to the beginning of the LinkedList.
	 * @param obj	the value inside the DoubleNode being added.
	 */
	public void addFirst(E obj)
	{
		DoubleNode add = new DoubleNode(obj);
		DoubleNode old = first;
		if (old != null)
		{
			add.setNext(old);
			old.setPrevious(add);
		}
		else
			last = add;
		first = add;
		size++;
	}

	/**
	 * 
	 * Adds to the end of the LinkedList.
	 * @param obj	the value inside the DoubleNode being added.
	 */
	public void addLast(E obj)
	{
		add(obj);
	}

	/**
	 * gets the first value in the LinkedList.
	 * @return	the value inside the first DoubleNode.
	 */
	public E getFirst()
	{
		return get(0);
	}

	/**
	 * gets the last value in the LinkedList.
	 * @return	the value inside the last DoubleNode.
	 */
	public E getLast()
	{
		return get(size - 1);
	}

	/**
	 * Removes the first node in the LinkedList.
	 * @return	the value that was in the old first node.
	 */
	public E removeFirst()
	{
		return remove(0);
	}

	/**
	 * Removes the last node in the LinkedList.
	 * @return	the value that was in the old last node.
	 */
	public E removeLast()
	{
		return remove(size-1);
	}

	/**
	 * Creates a new LinkedListIterator.
	 * @return	the new iterator created.
	 */
	public Iterator<E> iterator()
	{
		return new MyLinkedListIterator();
	}

	/**
	 * MyLinkedListIterator is an Iterator that
	 * is used on a MyLinkedList object.
	 * @author RakeshNori
	 * @version 10/14/2017
	 */
	private class MyLinkedListIterator implements Iterator<E>
	{
		private DoubleNode nextNode;
		private int index;

		/**
		 * Constructor for MyLinkedListIterator.
		 * Sets nextNode to the first node and sets
		 * the index, which is used to retrieve the last node accessed, 
		 * to -1.
		 */
		public MyLinkedListIterator()
		{
			nextNode = first;
			index = -1;
		}

		/**
		 * Checks if there is a nextNode.
		 */
		public boolean hasNext()
		{
			return nextNode != null;
		}

		/**
		 * Gives the value of the node and moves to the next node.
		 * @return the value of the node.
		 */
		public E next()
		{
			E val = (E)nextNode.getValue();
			nextNode = nextNode.getNext();
			index++;
			return val;
		}

		/**
		 * Removes the last node returned by next.
		 * @postcondition	removes the last element that was returned by next
		 */
		public void remove()
		{
			MyLinkedList.this.remove(index);
			index--;
		}
	}
}