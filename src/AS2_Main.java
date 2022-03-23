import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;


/**
 * Lớp AS2_Main là lớp để tạo menu và thực hiện thực hiện các chức năng trong lớp ProductEngine của bài toá
 * @author HK
 *
 */
public class AS2_Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * Thêm những product ban đầu vào file Data.txt
		 */
		Product product1 = new Product("P03", "Sugar", 12, 25.1);
		Product product2 = new Product("P01", "Miliket", 10, 5.2);
		Product product3 = new Product("P02", "Apple", 5, 4.3);
		Product product4 = new Product("P05", "Rose", 7, 15.4);
		Product product5 = new Product("P07", "Beer", 11, 12.2);
		Product product6 = new Product("P04", "Beer", 9, 5.2);
		MyList<Product> beginList = new MyList<Product>();
		beginList.insertToTail(product1);
		beginList.insertToTail(product2);
		beginList.insertToTail(product3);
		beginList.insertToTail(product4);
		beginList.insertToTail(product5);
		beginList.insertToTail(product6);
		OperationToProduct otp = new OperationToProduct();
		otp.writeAllItemsToFile("Data.txt", beginList);
		//tạo một PrintStream để lưu các output in ra màn hình vào file console_output.txt
		PrintStream out = new PrintStream("console_output.txt");
		MyList<Product> list = new MyList<Product>();
		Scanner inScanner = new Scanner(System.in);
		int choice;
		do {
			start(out);
			menu(out);
			System.out.print("choice = ");
			out.print("choice = ");
			choice = inScanner.nextInt();
			out.print(choice);
			System.out.println();
			out.println("\n");
			/*
			 * chọn chức năng mong muốn
			 */
			switch (choice) {
			case 0:
				System.out.println(" Thank!!!");
				out.println(" Thank!!!");
				break;
			case 1:
				/*
				 * đọc dữ liệu từ file Data.txt và hiển thị ra màn hình
				 */
				otp.getAllItemsFromFile("Data.txt", list);
				otp.displayAll(list, out);
				System.out.println();
				System.out.println("Successfully!");
				out.println("\n");
				out.println("Successfully!");
				break;
			case 2:
				// thêm một sản phẩm mới vào cuối danh sách
				otp.addLast(list, out);
				break;
			case 3:
				//hiển thị danh sách hiện tại
				otp.displayAll(list, out);
				break;
			case 4:
				//lưu danh sách vào file Data.txt
				otp.writeAllItemsToFile("Data.txt", list);
				System.out.println("Successfully!");
				out.println("Successfully!");
				break;
			case 5:
				//tìm một sản phẩm theo id nhập vào
				otp.searchByCode(list, out);
				break;
			case 6:
				//xóa một sản phẩm khởi danh sách
				otp.deleteByCode(list, out);
				break;
			case 7:
				//sắp xếp danh sách theo id sản phẩm
				otp.sortByCode(list, list.headNode, out);
				break;
			case 8:
				/*
				 * chuyển đổi giá trị quantity đầu danh sách thành số nhị phân 
				 */
				Integer i = list.headNode.dataT.quantity;
				int ctb = otp.convertToBinary(i);
				System.out.println("Quantity " + i + " => " + ctb);
				out.println("Quantity " + i + " => " + ctb);
				break;
			case 9:
				/*
				 * đọc dữ liệu từ file Data.txt, lưu vào Stack và in ra màn hình theo thứ tự ngược
				 */
				MyStack<Product> newStack = new MyStack<Product>();
				otp.getAllItemsFromFile("Data.txt", newStack);
				System.out.println(" ID  |  Title  | Quantity | price");
				System.out.println("---------------------------------");
				
				out.println(" ID  |  Title  | Quantity | price");
				out.println("---------------------------------");
				
				do {
					Product xProduct = newStack.pop();
					System.out.println(xProduct);
					out.println(xProduct);
				} while (!newStack.isEmpty());
				break;
			case 10:
				/*
				 * đọc dữ liệu từ file Data.txt, lưu vào Queue và in ra màn hình 
				 */
				MyQueue<Product> newQueue = new MyQueue<Product>();
				otp.getAllItemsFromFile("Data.txt", newQueue);
				System.out.println(" ID  |  Title  | Quantity | price");
				System.out.println("---------------------------------");
				
				out.println(" ID  |  Title  | Quantity | price");
				out.println("---------------------------------");
				
				do {
					Product xProduct = newQueue.dequeue();
					System.out.println(xProduct);
					out.println(xProduct);
				} while (!newQueue.isEmpty());
				break;
			default:
				break;
			}
		} while (choice != 0);
	}
	
	/**
	 * giới thiệu chương trình
	 * 
	 * @param out	
	 */
	public static void start(PrintStream out) {
		System.out.println();
		System.out.println("Chương Trình Quản Lý Sản Phẩm Trong Kho Hàng Của Một Siêu Thị");
		System.out.println();
		out.println("\n");
		out.println("Chương Trình Quản Lý Sản Phẩm Trong Kho Hàng Của Một Siêu Thị");
		out.println("\n");
	}
	
	/**
	 * danh sách chức năng của chương trình
	 * 
	 * @param out
	 */
	public static void menu(PrintStream out) {
		System.out.println();
		System.out.println(" Choose one of this options:");
		System.out.println(" Product list:");
		System.out.println(" 1. Load data from file and display");
		System.out.println(" 2. Input & add to the end.");
		System.out.println(" 3. Display data");
		System.out.println(" 4. Save product list to file.");
		System.out.println(" 5. Search by ID");
		System.out.println(" 6. Delete by ID");
		System.out.println(" 7. Sort by ID.");
		System.out.println(" 8. Convert to Binary ");
		System.out.println(" 9. Load to stack and display");
		System.out.println(" 10.Load to queue and display.");
		System.out.println(" Exit:");
		System.out.println(" 0. Exit");
		System.out.println();
		out.println("\n");
		out.println(" Choose one of this options:");
		out.println(" Product list:");
		out.println(" 1. Load data from file and display");
		out.println(" 2. Input & add to the end.");
		out.println(" 3. Display data");
		out.println(" 4. Save product list to file.");
		out.println(" 5. Search by ID");
		out.println(" 6. Delete by ID");
		out.println(" 7. Sort by ID.");
		out.println(" 8. Convert to Binary ");
		out.println(" 9. Load to stack and display");
		out.println(" 10.Load to queue and display.");
		out.println(" Exit:");
		out.println(" 0. Exit");
		out.println("\n");
	}
}
