
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class manages all function relate to the product
 * @author HK
 *
 */
public class OperationToProduct {
	
	Scanner inScanner;
	
	public OperationToProduct() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Searching and returning the index of product p 
	 * in the list. If not found return -1
	 * 
	 * @param p		Product for searching
	 * @param list	The Linked List
	 * @return		The index of product p in the List
	 */
	/*public int index(Product p, MyList<Product> list) {
		
		int index = -1;
		Node<Product> currentNode = list.headNode;
		while (currentNode != null) {
			index ++;
			if(currentNode.dataT == p) {
				return index;
			}
			currentNode = currentNode.nextNode;
		}
		return index;
	}*/
	
	/**
	 * Creating and returning a product with info input from keyboard
	 * 
	 * @return	The product
	 */
	/*public Product createProduct() {
		
		inScanner = new Scanner(System.in);
		System.out.print("Product's bar code: ");
		String bcode = inScanner.next();
		System.out.print("Product's title: ");
		String title = inScanner.next();
		System.out.print("Product's quantity: ");
		Integer quantity = inScanner.nextInt();
		System.out.print("Product's price: ");
		double price = inScanner.nextDouble();
		Product newProduct = new Product(bcode, title, quantity, price);
		return newProduct;
	}*/
	
	/**
	 * Reading all products from the file and insert them to the list at tail
	 * 
	 * @param fileName	The file name of the file
	 * @param list		The Linked List contains all product that read from file
	 */
	public void getAllItemsFromFile(String fileName, MyList<Product> list) {
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			/*
			 * xóa danh sách cũ đi
			 */
			if(!list.isEmpty()) {
				list.clear();
			}
			MyList<Product> newList = (MyList<Product>) ois.readObject();
			Node<Product> current = newList.headNode;
			while (current != null) {
				list.insertToTail(current.dataT);
				current = current.nextNode;
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * Reading all products from the file and insert them to the stack.
	 * 
	 * @param fileName	The file name of the file
	 * @param list		The Stack contains all products that read from file
	 */
	public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
		
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			/*
			 * xóa Stack cũ đi
			 */
			while(!stack.isEmpty()) {
				stack.pop();
			}
			MyList<Product> newList = (MyList<Product>) ois.readObject();
			Node<Product> current = newList.headNode;
			while (current != null) {
				stack.push(current.dataT);
				current = current.nextNode;
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	  * Reading all products from the file and insert them to the queue.
	  *
	  * @param fileName The file name of the file
	  * @param queue     The Queue contains all products that read from file
	  */
	public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
		 
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			/*
			 * xóa Queue cũ đi
			 */
			while(!queue.isEmpty()) {
				queue.dequeue();
			}
			MyList<Product> newList = (MyList<Product>) ois.readObject();
			Node<Product> current = newList.headNode;
			while (current != null) {
				queue.enqueue(current.dataT);
				current = current.nextNode;
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	/**
	  * Adding a product to the list, info of the product input from keyboard.
	  *
	  * @param list The Linked list
	  */
	public void addLast(MyList<Product> list, PrintStream out) {
		 
		inScanner = new Scanner(System.in);
		
		System.out.print("Input new ID: ");
		out.print("Input new ID: ");
		String bcode = inScanner.next();
		out.print(bcode);
		
		System.out.print("Input Product's Name: ");
		out.print("\nInput Product's Name: ");
		String title = inScanner.next();
		out.print(title);
		
		System.out.print("Input Product's quantity: ");
		out.print("\nInput Product's quantity: ");
		Integer quantity = inScanner.nextInt();
		out.print(quantity);
		
		System.out.print("Input Product's price: ");
		out.print("\nInput Product's price: ");
		double price = inScanner.nextDouble();
		out.print(price);
		
		Product newProduct = new Product(bcode, title, quantity, price);
		list.insertToTail(newProduct);
	}
	 
	/**
	  * Printing all products of the list to console screen
	  *
	  * @param list
	  */
	public void displayAll(MyList<Product> list, PrintStream out) {
		
		if(list.isEmpty()) {
			System.out.println("Danh sách trống!");
			out.println("Danh sách trống!");
			return;
		}
		System.out.println(" ID  |  Title  | Quantity | price");
		System.out.println("---------------------------------");
		out.println(" ID  |  Title  | Quantity | price");
		out.println("---------------------------------");
		Node<Product> currentNode = list.headNode;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			out.println(currentNode.toString());
			currentNode = currentNode.nextNode;
		}
	}
	
	/**
	  * Writing all products from the list to the file
	  *
	  * @param fileName Input file name
	  * @param list     Input Linked list
	  */
	public void writeAllItemsToFile(String fileName, MyList<Product> list) {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	  * Searching product by ID input from keyboard.
	  *
	  * @param list
	  */
	public void searchByCode(MyList<Product> list, PrintStream out) {
		
		if(list.isEmpty()) {
			System.out.println("Danh sách trống!");
			out.println("Danh sách trống!");
			return;
		}
		inScanner = new Scanner(System.in);
		System.out.print("Input the IDto search = ");
		out.print("Input the IDto search = ");
		String id = inScanner.next();
		out.print(id);
		
		boolean kq = false;
		Node<Product> currentNode = list.headNode;
		System.out.println("Result: ");
		out.println("Result: ");
		System.out.println(" ID  |  Title  | Quantity | price");
		out.println(" ID  |  Title  | Quantity | price");
		System.out.println("---------------------------------");
		out.println("---------------------------------");
		
		while (currentNode != null) {
			if(currentNode.dataT.bcode.contains(id)) {
				System.out.println(currentNode.toString());
				out.println(currentNode.toString());
				kq = true;
			}
			currentNode = currentNode.nextNode;
		}
		if (!kq) {
			System.out.println("-1");
			out.println("-1");
			return;
		}
	}
	
	/**
	  * Deleting first product that has the ID input from keyboard from the list.
	  *
	  * @param list
	  */
	public void deleteByCode(MyList<Product> list, PrintStream out) {
	 
		inScanner = new Scanner(System.in);
		System.out.print("Input the bcode to delete = ");
		out.print("Input the bcode to delete = ");
		String id = inScanner.next();
		out.print(id);
		
		boolean kq = false;
		Node<Product> currentNode = list.headNode;
		while (currentNode != null) {
			if(currentNode.dataT.bcode.contains(id)) {
				list.deleteElement(currentNode.dataT);
				kq = true;
			}
			currentNode = currentNode.nextNode;
		}
		
		if (kq) {
			System.out.println();
			System.out.println("Deleted!");
			out.println("\n");
			out.println("Deleted!");
		} else {
			System.out.println("Không tìm thấy ID xóa!");
			out.println("Không tìm thấy ID xóa!");
		}
	}
	
	/**
	  * Sorting products in linked list by ID
	  *
	  * @param list The Linked list
	  */
	public void sortByCode(MyList<Product> list, Node<Product> currentNode, PrintStream out) {
		
		/*
		 * nếu danh sách trống thì in ra thông báo và kết thúc
		 * ngược lại tìm node có id nhỏ nhất trong danh sách và đưa nó lên đầu
		 * sử dụng đệ quy để tìm node có id nhỏ nhất trong phần còn lại của danh sách
		 */
		if(list.isEmpty()) {
			System.out.println("Danh sách trống!");
			out.println("Danh sách trống!");
			return;
		}
		Node<Product> tmpNode = currentNode;
		Node<Product> minNode = currentNode;
		if(tmpNode == null) {
			System.out.println("Successfully!");
			out.println("Successfully!");
			return;
		}
		
		while (currentNode != null) {
			if(currentNode.dataT.bcode.compareTo(minNode.dataT.bcode) < 0) {
					minNode = currentNode;
			}
			currentNode = currentNode.nextNode;
		}
		list.swap(tmpNode, minNode);
		sortByCode(list, tmpNode.nextNode, out);
	}

	
	
	/**
	  * Adding new product to head of Linked List. The info input from keyboard.
	  *
	  * @param list The linked list
	  */
	/*public void addFirst(MyList<Product> list) {

		inScanner = new Scanner(System.in);
		System.out.print("Product's bar code: ");
		String bcode = inScanner.next();
		System.out.print("Product's title: ");
		String title = inScanner.next();
		System.out.print("Product's quantity: ");
		Integer quantity = inScanner.nextInt();
		System.out.print("Product's price: ");
		double price = inScanner.nextDouble();
		Product newProduct = new Product(bcode, title, quantity, price);
		list.insertToHead(newProduct);
	}*/
	
	/**
	  * Convert a decimal to an array of binary. Example: input i = 18 -> Output =
	  * {0, 1, 0, 0, 0, 1}
	  *
	  * @param i Input decimal number
	  * @return Array of binary numbers
	  */
	public int convertToBinary(int i) {

		if(i <= 0) {
			return 0;
		}
		return i % 2 + 10 * convertToBinary(i / 2);	
	 }
	
	/**
	  * Deleting the product at position
	  *
	  * @param list The Linked List
	  * @param pos  The position of product to be deleted
	  */
	/*public void deleteAtPosition(MyList<Product> list, int pos) {
 
		if(list.isEmpty()) {
			System.out.println("Danh sách trống!");
			return;
		}
		
		int count = -1;
		Node<Product> currentNode = list.headNode;
		while (currentNode != null) {
			count++;
			if (count == pos) {
				list.deleteElement(currentNode.dataT);
			}
			currentNode = currentNode.nextNode;
		}
	}*/
}
