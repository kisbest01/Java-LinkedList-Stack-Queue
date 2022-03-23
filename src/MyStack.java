
/**
 * Generic version of the Stack class
 * @author HK
 *
 * @param <T>	The type of the value
 */
public class MyStack<T> implements java.io.Serializable {
	
	/**
	 * Head node contains front node in the stack
	 */
	Node<T> headNode;
	
	public MyStack() {
		// TODO Auto-generated constructor stub
		headNode = null;
	}
	
	/**
	 * kiểm tra Stack có trống hay không
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return headNode == null;
	}
	
	/**
	 * thêm một Node vào đầu Stack
	 * 
	 * @param dataT		Node cần thêm
	 */
	public void push(T dataT) {
		headNode = new Node<T>(dataT, headNode);
	}
	
	/**
	 * Xóa Node đầu khởi Stack
	 * 
	 * @return	trả về Node đã xóa
	 */
	public T pop() {
		if(isEmpty()) {
			System.out.println("Danh Sách Trống!");
		}
		T x = headNode.dataT;
		headNode = headNode.nextNode;
		return x;
	}
}
