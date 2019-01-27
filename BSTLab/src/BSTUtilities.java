/**
 * This class is a collection of static methods for operating on binary search trees
 * @author Rakesh Nori
 * @version 1/8/2018
 *
 */
public abstract class BSTUtilities
{
	/**
	 * Checks if the tree contains the value x.
	 * @param t The tree rooted at node t.
	 * @param x the value being checked in the tree.
	 * @param display the tree's display.
	 * @return true if t is present in the tree; otherwise,
	 * 		   false.
	 */
	public static boolean contains(TreeNode t, Comparable x, TreeDisplay display)
	{
		//System.out.println(t);
		if (t == null)
			return false;
			//display.visit(t);
		if (((Comparable) t.getValue()).compareTo(x) == 0)
		{
			display.visit(t);
			return true;
		}
		if (((Comparable) t.getValue()).compareTo(x) > 0)
			return contains(t.getLeft(), x, display);
		
		return contains(t.getRight(), x , display);
	}
	
	/**
	 * inserts a TreeNode with value comparable x into the BST.
	 * @param t the reference to the BST.
	 * @param x the value to be added.
	 * @param display the display of the tree.
	 * @return the tree with the new node of value x.
	 */
	public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (!contains(t, x, display))
        {
            if (t == null)
                return new TreeNode(x);
            else
            {
                if (x.compareTo((Comparable) t.getValue()) < 0)
                {
                    t.setLeft(insert(t.getLeft(), x, display));
                }
                else 
                {
                    t.setRight(insert(t.getRight(), x, display));
                }
            }
        }
        return t;
	}
	/**
	 * 
	 * @param t the binary search tree rooted at TreeNode t.
	 * @param display the tree's display.
	 * @return the binary search tree without treenode t.
	 */
	private static TreeNode deleteNode(TreeNode t, TreeDisplay display)
	{
		TreeNode curr = t;
		if (curr.getLeft() == null && curr.getRight() == null)
		{
			return null;
		}
		if (curr.getLeft() == null)
			return curr.getRight();
		else if (curr.getRight() == null)
			return curr.getLeft();
		else
		{
			TreeNode temp = curr.getLeft();
			TreeNode replace = (TreeNode)TreeUtil.rightmost(temp);
			Object val = replace.getValue();
			curr.setValue(val);
			curr.setLeft(delete(curr.getLeft(), (Comparable)val, display));
            return curr; 
		}
	}
	/**
	 * deletes the node containing the value x.
	 * @param t the binary search tree rooted at tree node x.
	 * @param x the value to be removed.
	 * @param display the display of the tree
	 * @precondition t is a binary search tree in ascending order.
	 * @return	the binary search tree without the node containing x.
	 */
	public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display)
	{
		if (contains(t,x,display))
        {
			//display.visit(t);
            if (t == null)                          
                return t;                                           
            if (x.compareTo(t.getValue()) > 0 ) 
            {
            	display.visit(t);
                t.setRight(delete(t.getRight(), x, display));
                return t;
            }
            else if (x.compareTo(t.getValue()) < 0) 
            {
            	display.visit(t);
                t.setLeft(delete(t.getLeft(), x , display));
                return t;
            }
            else             
                return deleteNode(t, display);          
        }       
        return t; 
	}
}