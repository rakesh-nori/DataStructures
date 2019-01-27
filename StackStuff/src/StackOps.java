import java.util.Stack;

/**
 * Stack Practice given in class. Did the lab with Ronit.
 * @author Rakesh Nori
 *
 */
public class StackOps 
{
	public boolean isBalanced(String exp)
	{
		int index = 0;
		Stack<String> s = new Stack<String>();
		while (index < exp.length())
		{
			String c = exp.substring(index,  index+1);
			if (c.equals("[") || c.equals("(") || c.equals("{"))
				s.push(c);
			else if (c.equals("]"))
			{
				if (s.isEmpty() || !s.peek().equals("["))
					return false;
				else
					s.pop();
			}
			else if (c.equals(")"))
			{
				if (s.isEmpty() || !s.peek().equals("("))
					return false;
				else
					s.pop();
			}
			else if (c.equals("}"))
			{
				if (s.isEmpty() || !s.peek().equals("{"))
					return false;
				else
					s.pop();
			}
			index++;
		}
		return (s.isEmpty());
	}
	public int evaluatePost(String exp)
	{
		int index = 0;
		Stack s = new Stack();
		Stack <Integer> nums = new Stack();
		while (index < exp.length())
		{
			boolean doingStuff = false;
			String c = exp.substring(index, index+1);
			if (c.equals("*") || c.equals("+") || c.equals("/") || c.equals("-"))
			{
				Integer second = nums.pop();
				Integer first = nums.pop();
				Integer ans = 0;
				if (c.equals("*"))
					ans = first * second;
				else if (c.equals("/"))
					ans = first / second;
				else if (c.equals("+"))
					ans = first + second;
				else
					ans = first - second;
				nums.push(ans);
			}		
			else
			{
				nums.push(new Integer(c));
			}
			index++;
		}
		return nums.peek();
	}
	
	public static void main(String [] args)
	{
		StackOps so = new StackOps();
		System.out.println(so.isBalanced("[4*(231+2139)]"));
		System.out.println(so.evaluatePost("523*+4-36*+"));
	}
}
