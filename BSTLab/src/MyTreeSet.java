/**
 * TreeSet uses methods from BSTUtilies to help its functions as a set.
 * @author RakeshNori
 * @version 1/10/2018
 * @param <E>
 */
public class MyTreeSet<E>
{
	private TreeNode root;
	private int size;
	private TreeDisplay display;

	public MyTreeSet()
	{
		root = null;
		size = 0;
		display = new TreeDisplay();

		//wait 1 millisecond when visiting a node
		display.setDelay(1);
	}

	/**
	 * Gives the size of the TreeSet.
	 * @return the size of the tree.
	 */
	public int size()
	{
		return size;
	}
	/**
	 * checks if the tree contains a certain object by using the BST method contains.
	 * @param obj the object being checked in the tree.
	 * @return true if the object is in the tree; otherwise,
	 * 		   false.
	 */
	public boolean contains(Object obj)
	{
		return BSTUtilities.contains(root, (Comparable)obj, display);
	}

	// if obj is not present in this set, adds obj and
	// returns true; otherwise returns false
	/**
	 * Adds an object to the tree if it does not contain it.
	 * Uses BST method add.
	 * @param obj the object to be added to the tree.
	 * @return true if the object is not initially in the tree 
	 * 		   and it has been added; otherwise,
	 * 		   false.
	 */
	public boolean add(E obj)
	{
		if (!contains(obj))
		{
			root = BSTUtilities.insert(root, (Comparable)obj, display);
			size++;
			return true;
		}
		return false;
	}

	// if obj is present in this set, removes obj and
	// returns true; otherwise returns false}
	/**
	 * Removes the object from a tree if it contains it. 
	 * Uses BST method delete.
	 * @param obj the object to be removed from the tree.
	 * @return true if the object 
	 */
	public boolean remove(Object obj)
	{
		if (contains(obj))
		{
			root = BSTUtilities.delete(root, (Comparable)obj, display);
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Outputs for the TreeSet
	 * @return the output for the object.
	 */
	public String toString()
	{
		return toString(root);
	}
	/**
	 * The process of outputting the values in the TreeSet
	 * @param t the current node in the TreeSet
	 * @return the values of the TreeSet.
	 */
	private String toString(TreeNode t)
	{
		if (t == null)
			return " ";
		return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
	}
}