import java.util.LinkedList;


/**
 * A stack class that needs to be used in your Gloom.java.
 * This class SHOULD NOT BE MODIFIED!
 */
public class Stack<T>{

	private LinkedList<T> stackData;

	/**
	 * A constructor for our stack
	 */
	public Stack(){
		stackData = new LinkedList<T>();
	}

	/**
	 * Push an element onto our stack.
	 *
	 * @param o the element to put onto our stack
	 */
	public void push(T o){
		stackData.push(o);
	}

	/**
	 * Look at the top element of our stack
	 *
	 * @return the top element of the stack
	 */
	public T top(){
		return stackData.peek();
	}

	/**
	 * Remove and return the top element of the stack
	 *
	 * @return the removed top element of the stack
	 */
	public T pop(){
		return stackData.pop();
	}

	/**
	 * Checks if the stack is empty.
	 *
	 * @return true if the stack is empty.
	 */
	public boolean isEmpty(){
		return stackData.isEmpty();
	}

}
