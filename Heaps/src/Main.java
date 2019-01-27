
/**
 * The Main class for the heapsort.
 * @author Rakesh Nori
 * @version 1/4/2018
 */
public class Main 
{
	/**
	 * Displays a random heap and uses heapsort to make 
	 * the randomly generated array into ascending order. 
	 * @param args Arguments from the command line.
	 */
	public static void main(String [] args)
	{
		Integer [] arr = new Integer[12];
		for (int i = 1; i < arr.length; i++)
		{
			int rand = (int)(Math.random() * 99) + 1;
			arr[i] = rand;
		}
		HeapDisplay dis = new HeapDisplay();
		dis.displayHeap(arr, 11);
		HeapUtils.heapSort(arr, 11);
	}
}
