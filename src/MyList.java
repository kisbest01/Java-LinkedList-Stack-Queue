
/**
 * Generic version of the LinkedList class
 * @author HK
 *
 * @param <T> the type of the value
 */
public class MyList<T> implements java.io.Serializable {
	
	/**
	 * Head node, default is null
	 */
	Node<T> headNode;
	/**
	 * Tail node, default is null
	 */
	Node<T> tailNode;
	
	/**
	 * Default constructor
	 */
	public MyList() {
		// TODO Auto-generated constructor stub
		headNode = tailNode = null;
	}
	
	/**
	 * Constructor with head and tail
	 * 
	 * @param headNode	Head node of this list
	 * @param tailNode	Tail node of this list
	 */
	public MyList(Node<T> headNode, Node<T> tailNode) {
		this.headNode = headNode;
		this.tailNode = tailNode;
	}
	
	/**
	 * Check if this list is empty
	 * 
	 * @return true if list is empty
	 */
	public boolean isEmpty() {
		return headNode == null;
	}
	
	/**
	 * Deleting all items in the list
	 */
	public void clear() {
		headNode = tailNode = null;
	}
	
	/**
	 * Returning the length of this list
	 * 
	 * @return	The length of this list
	 */
	public int length() {
		Node<T> current = headNode;
		int length = 0;
		if(isEmpty()) {
			return 0;
		}
		while(current != null) {
			length++;
			current = current.nextNode;
		}
		return length;
	}
	
	/**
	 * Insert an item to the head of the list
	 * 
	 * @param item	The item to be inserted
	 */
	public void insertToHead(T item) {
		Node<T> newNode = new Node<T>(item);
		if(isEmpty()) {
			headNode = tailNode = newNode;
		} else {
			newNode.nextNode = headNode;
			headNode = newNode;
		}
	}
	
	public void insertToTail(T item) {
		Node<T> newNode = new Node<T>(item);
		if(isEmpty()) {
			headNode = tailNode = newNode;
		} else {
			tailNode.nextNode = newNode;
			tailNode = newNode;
		}
	}
	
	/**
	 * Insert an item at position to this list
	 * 
	 * @param position	The position of new item
	 * @param item		The item to be inserted
	 */
	public void insertAfterPosition(int position, T item) {
		Node<T> newNode = new Node<T>(item);
		if(position > length()) {
			System.out.println("Vị trí nằm ngoài danh sách");
			return;
		}
		Node<T> currentNode = headNode;
		int count = -1;
		while (currentNode != null) {
			count++;
			if(count == position) {
				newNode.nextNode = currentNode.nextNode;
				currentNode.nextNode = newNode;
			}
			currentNode = currentNode.nextNode;
		}
	}
	
	/**
	 * Deleting the tail of this list
	 */
	public void deleteTail() {
		if(isEmpty()) {
			return;
		}
		if(headNode.nextNode == null) {
			clear();
		}
		Node<T> current = headNode;
		while (current.nextNode.nextNode != null) {
			current = current.nextNode;
		}
		current.nextNode = null;
		tailNode = current;
	}
	
	/**
	 * Searching and deleting an item from this list by comparing 
	 * the ID of items
	 *  
	 * @param item The item to be deleted
	 */
	public void deleteElement(T item) {
		if(isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}
		if(headNode.dataT == item) {
			headNode = headNode.nextNode;
			return;
		}
		if(tailNode.dataT == item) {
			deleteTail();
			return;
		}
		Node<T> currentNode = headNode;
		while (currentNode != null) {
			if(currentNode.nextNode.dataT == item) {
				currentNode.nextNode = currentNode.nextNode.nextNode;
				break;
			}
			currentNode = currentNode.nextNode;
		}
		System.out.println(headNode);
		System.out.println(tailNode);
	}
	
	/**
	 * Swapping two nodes [firstNode] and [secondNode]
	 * 
	 * @param firstNode
	 * @param secondNode
	 */
	public void swap(Node<T> firstNode, Node<T> secondNode) {
		T tmp = firstNode.dataT;
		firstNode.dataT = secondNode.dataT;
		secondNode.dataT = tmp;
	}
}

	