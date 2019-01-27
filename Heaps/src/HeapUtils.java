
/**
 * A class that contains various actions that can be done on a heap.
 * @author Rakesh Nori
 * @version 1/7/2018
 *
 */
public class HeapUtils 
{
	/**
	 * Recursively sorts the tree rooted at the given index
	 * so that it follows the conditions of a heap.
	 * @param heap	the array of values given
	 * @param index the index of the root
	 * @param heapSize the size of the heap
	 */
	public static void heapify(Comparable [] heap, int index, int heapSize)
	{
		Comparable value = heap[index];
		int left = index * 2;
		int right = index * 2 + 1;
		if (left > heapSize)
			return;
		Comparable l = heap[left];
		Comparable max = l;
		int loc = left;
		if (right <= heapSize)
		{
			Comparable r = heap[right];
			if (r.compareTo(l) > 0)
			{
				max = r;
				loc = right;
			}
		}
		if (max.compareTo(value) > 0)
		{
			Comparable temp = heap[loc];
			heap[loc] = heap[index];
			heap[index] = temp;
			heapify(heap, loc, heapSize);
		}
	}
	/**
     * Starting at the rightmost non leaf node and heapifys
     * each subtree going to the root node
     * @param heap the input array representing a complete binary tree
     * @param heapSize the amount of nodes in the heap
     * @postcondition heap contains a complete binary tree satisfying the heap condition
     */
    public static void buildHeap(Comparable[] heap, int heapSize)
    {
        for(int i = heapSize/2; i > 0; i--)
        {
            heapify(heap, i, heapSize);
        }
    }
   
    /**
     * Inserts a new value into the heap 
     * and sorts it so that it is in its proper place in the array.
     * @param heap the array of random values.
     * @param item	the value to be inserted.
     * @param heapSize the size of the heap being used
     * @return the new heap with the value inserted into its correct place.
     */
    public static Comparable[] insert(Comparable [] heap, Comparable item, int heapSize)
    {
    	heapSize++;
    	if (heapSize - 1 >= heap.length)
    	{
    		Comparable [] newHeap = new Comparable[heap.length + 1];
    		for (int i = 0; i < heap.length; i++)
    			newHeap[i] = heap[i];
    	}
    	heap[heapSize-1] = item;
    	buildHeap(heap, heapSize);
    	return heap;
    }
    /**
     * removes and returns the root value, leaving a complete binary tree 
     * that is one element smaller and satisfies the heap condition
     * @param heap the input array representing a complete binary tree
     * @param heapSize the amount of nodes in the heap
     */
    public static Comparable remove(Comparable[] heap, int heapSize)
    {
        Comparable temp = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize] = temp;
        heapSize--;
        heapify(heap, 1, heapSize);
        return temp;
    }
    /**
     * Sorts the random data in the heap into ascending order with a heap
     * @param heap the input array representing a complete binary tree
     * @param heapSize the amount of nodes in the heap
     */
    public static void heapSort(Comparable[] heap, int heapSize)
    {
        for (int i=0; i<heap.length; i++)
            System.out.print(heap[i] + " | ");
        System.out.println();
        buildHeap(heap, heapSize);
        while(heapSize > 1)
        {
            remove(heap, heapSize);
            heapSize--;
            heapify(heap, 1, heapSize);
            for (int i=0; i<heap.length; i++)
                System.out.print(heap[i] + " | ");
            System.out.println();  
        }
    }

}
