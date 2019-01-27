
	import java.util.Stack;

	/**
	 * Uses Stacks to do string related problems
	 * 
	 * @author Anu Datar
	 * @author Ronit Gagneja 
	 * @author Rakesh Nori
	 * @version 11/5/2017
	 */
	public class StringUtil
	{
	    //reverse a string using a Stack and substring not charAt
	    //@param str string to reverse
	    //@return reversed string
	    public static String reverseString(String str)
	    {
	        Stack<String> s = new Stack<String>();
	        int index = 0;
	        while(index<str.length())
	        {
	            s.push(str.substring(index, index+1));
	            index++;
	        }
	        String reverse = "";
	        while(! s.isEmpty())
	        {
	            reverse += s.pop();
	        }
	        return reverse;
	    }

	    // must use reverse written above
	    // checks if string provided is a palindrome (same backwards and forwards)
	    // @param str string to check
	    // @return true if is a palindrome; otherwise,
	    //         false;
	    public static boolean isPalindrome(String str)
	    {
	        String reverse = reverseString(str);
	        if(reverse.equals(str))
	        {
	            return true;
	        }
	        return false;
	    }

	    // The tester for checking that reverse and isPalindrome work well.
	    public static void main(String[] args)
	    {
	        String test =  "racecar";
	        String test2 = "notapalindrome";

	        if ( !("".equalsIgnoreCase(reverseString(""))) )
	            System.out.println("** Oops Something went wrong. Check your reverse method **");

	        if ( !("a".equalsIgnoreCase(reverseString("a"))) )
	            System.out.println("** Oops Something went wrong. Check your reverse method **");

	        if (!test.equalsIgnoreCase(reverseString(test)))
	            System.out.println("** Oops Something went wrong. Check your reverse method **");
	        else
	            System.out.println("Success " + test + " matched " + reverseString(test));
	            
	        if (test2.equalsIgnoreCase(reverseString(test2)))
	            System.out.println("** Oops Something went wrong. Check your reverse method **");

	    }
	}

