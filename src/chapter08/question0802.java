package chapter08;
import java.util.*;

public class question0802 {
	
	static HashSet<Character> operators;
	static
	{
		operators = new HashSet<Character>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(evaluateRPN(new char[]{'1','2','+','-','-','-','3','*'})+" ");
	}
	
	public static int evaluateRPN (char[] rpns) throws Exception
	{
		Stack numbers = new Stack();
		boolean isNegative = false;
		char op = '.';
		for(int i = 0;i<rpns.length;i++)
		{
			char c = rpns[i];
			// If it is an operator
			if(operators.contains(c))
			{
				// Every operator other than - requires two operands
				// And here we assume the negating - has lower precedence than the minus -
				if(numbers.size < 2)
				{
					if( c != '-')
					{
						throw new Exception("Invalid RPN");
					}
					else
					{
						isNegative = !isNegative;
					}
					continue;
				}
				op = c;
				int b = numbers.pop();
				int a = numbers.pop();
				switch(op)
				{
				case '+':
					numbers.push(a+b);
					break;
				case '-':
					numbers.push(a-b);
					break;
				case '*':
					numbers.push(a*b);
					break;
				case '/':
					numbers.push(a/b);
					break;
					default:
						throw new Exception ("Invalid operator");
				}
				continue;
			}
			//Check if is a number
			if(c > '9' || c < '0')
			{
				throw new Exception("Invalid char");
			}
			int num = c-'0';
			if(isNegative)
			{
				num *= -1;
			}
			numbers.push(num);
		}
		return numbers.pop();
	}
}
