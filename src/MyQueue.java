
/**
 * Generic version of the Queue class
 * @author HK
 *
 * @param <T>	The type of the value
 */
public class MyQueue<T> implements java.io.Serializable {
	
	/**
	 * Head node contains front node in the queue;
	 */
	Node<T> headNode;
	/**
	 * Tail node contains last node in the queue
	 */
	Node<T> tailNode;
	
	public MyQueue() {
		// TODO Auto-generated constructor stub
		headNode = tailNode = null;
	}
	
	/**
	 * kiểm tra Queue có trống hay không
	 * 
	 * @return 	
	 */
	public boolean isEmpty() {
		return headNode == null;
	}
	
	/**
	 * thêm một Node vào cuối Queue
	 *  
	 * @param dataT		Node cần thêm
	 */
	public void enqueue(T dataT) {
		Node<T> newNode = new Node<T>(dataT);
		if(isEmpty()) {
			headNode = tailNode = newNode;
		}
		tailNode.nextNode = newNode;
		tailNode = newNode;
	}
	
	/**
	 * xóa Node đầu khởi Queue
	 * @return	trả về Node đã xóa
	 */
	public T dequeue() {
		if(isEmpty()) {
			System.out.println("Danh sách trống!");
		}
		T x = headNode.dataT;
		headNode = headNode.nextNode;
		return x;
	}
}
