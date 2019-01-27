import java.util.Stack;

/**
 * Write a description of class StringUtil here. Worked with Ronit.
 * 
 * @author Rakesh Nori
 * @version 10/27/2017
 * 
 */

public class Expressions
{
    // parenthesis matching : An expression is said to be balanced if
    // every opener has a corresponding closer, in the right order
    // {, [ or ( are the only types of brackets allowed
    // @param   expression containing operands operators 
    //          and any of the 3 supportedbrackets
    // @return  true is the parenthesis are balanced         
    //          false otherwise
    public static boolean matchParenthesis(String exp)
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
    // returns a string in postfix form 
    // if given an expression in infix form as a parameter
    // does this conversion using a Stack
    // @param expr valid expression in infix form
    // @return equivalent expression in postfix form
    public static String infixToPostfix(String exp)
    {
        Stack<String> ops = new Stack<String>();
        int index = 0;
        String post = "";
        while (index < exp.length())
        {
        	String c = exp.substring(index, index+1);
        	if (c.equals("*") ||  c.equals("/") || c.equals("%"))
        	{
        		while (!ops.isEmpty() && (ops.peek().equals("*") || ops.peek().equals("/") || 
        				ops.peek().equals("%")))
        		{
        			post += ops.pop();
        		}
        		ops.push(c);
        	}
        	else if ( c.equals("-") || c.equals("+"))
        	{
        		while (!ops.isEmpty())
        			post += ops.pop();
        		ops.push(c);
        	}
        	else
        	{
        		post += c;
        	}
        	index++;
        }
        while (!ops.isEmpty())
        	post += ops.pop();
        return post;
    }

    // returns the value of an expression in postfix form
    // does this computation using a Stack
    // @param expr valid expression in postfix form
    // @return value of the expression
    // @precondition postfix expression  
    //               contains numbers and operators + - * / and %
    //               and that operands and operators are separated by spaces
    public static double evalPostfix(String exp)
    {
    	int index = 0;
		Stack nums = new Stack();
		while (index < exp.length())
		{
			String c = exp.substring(index, index+1);
			if (c.equals("*") || c.equals("+") || c.equals("/") || c.equals("-") || c.equals("%"))

			{
				Integer second = (Integer)nums.pop();
				Integer first = (Integer)nums.pop();
				Integer ans = 0;
				if (c.equals("*"))
					ans = first * second;
				else if (c.equals("/"))
					ans = first / second;
				else if (c.equals("+"))
					ans = first + second;
				else if (c.equals("-"))
					ans = first - second;
				else
					ans = first % second;
				nums.push(ans);
			}		
			else if (!c.equals(" "))
			{
				String num = "";
				while (!(c.equals(" ") || c.equals("*") || c.equals("+") || c.equals("/") || c.equals("-") || c.equals("%")))
				{
					num += c;
					index++;
					c = exp.substring(index, index + 1);
				}
				Integer cInt = new Integer(num);
				nums.push(cInt);
				index--;
			}
			index++;
		}
		return (Integer)nums.peek();
    }

    // Tester to check if infix to postfix and evaluate postfix work well
    public static void main(String[] args)
    {
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 5);   

        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("()()()()()", true);
    }

    public static void test(String expr, double expect)
    {
        String post = infixToPostfix(expr);    
        double val = evalPostfix(post);

        System.out.println("Infix: " + expr);
        System.out.println("Postfix: " + post);
        System.out.println("Value: " + val);
        if (val == expect)
        {
            System.out.print("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = matchParenthesis(ex);
        if (act == expected)
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + act);
        else
        {
            System.out.print("** Oops! Something went wrong check : matchParen(" + ex + ")");
            System.out.println(" returned " + act + " but should have returned " + expected);
        }
    }
}
