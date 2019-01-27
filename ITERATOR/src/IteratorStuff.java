
import java.util.*;
public class IteratorStuff 
{
	public static void main(String[]args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(23984);
		list.add(3298);
		ListIterator<Integer> iter =  list.listIterator(list.size());
		if (iter.hasPrevious())
			System.out.println(iter.next());
		if (iter.hasNext())
			System.out.println(iter.previous());
		
	}
	
}
