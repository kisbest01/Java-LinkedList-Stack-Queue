
/**
 * Generic version of the Node class
 * @author HK
 *
 * @param <T> the type of the value
 */
public class Node<T> implements java.io.Serializable {
	/**
	 * The data of this node
	 */
	T dataT;
	/**
	 * The next node
	 */
	Node<T> nextNode;
	
	/**
	 * Default constructor
	 */
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor with data and next node
	 * 
	 * @param dataT		The data of this node
	 * @param nexNode	The next node of this node
	 */
	public Node(T dataT, Node<T> nexNode) {
		this.dataT = dataT;
		this.nextNode = nexNode;
	}
	
	public Node(T dataT) {
		this(dataT, null);
	}
	/**
	 * Overriding to convert this node to String
	 */
	@Override
	public String toString() { 
		return dataT.toString();
	}
}