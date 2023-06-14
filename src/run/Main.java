import ra.bussiness.Book;
import service.BookService;

import java.util.Scanner;

public class Main {
    static Book book = new Book();
    public static void main(String[] args) {

        int choice = 0;
        while (true) {
            System.out.println("1.\tNhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách\n" +
                    "2.\tHiển thị thông tin tất cả sách trong thư viện\\\n" +
                    "3.\tSắp xếp sách theo lợi nhuận tăng dần\n" +
                    "4.\tXóa sách theo mã sách \n" +
                    "5.\tTìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                    "6.\tThay đổi thông tin sách theo mã sách \n" +
                    "7.\tThoát");
            System.out.println("nhập lự chọn của bạn");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }
    public static String inputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng danh mục cần thêm mới");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin danh mục thứ "+ (i+1));
            Book newBook = new Book();
            int id = BookService.getNewId();
            System.out.println("mã sách : " +id);
            newBook.setId(id);
            System.out.println("nhập tên Sach:");
            newBook.setBookName(scanner.nextLine());
            System.out.println("nhập tên Tác Giả:");
            newBook.setAuthor(scanner.nextLine());
            System.out.println("nhập tên mô tả về sách:");
            newBook.setDescriptions(scanner.nextLine());
            System.out.println("nhập giá nhập của sách:");
            newBook.setImportPrice(scanner.nextDouble());
            System.out.println("nhập giá xuất của sách:");
            newBook.setImportPrice(scanner.nextDouble());

            // lưu nó vào listcategory
            categoryController.save(newCategory);

        }
//▪ bookId – mã sách – int (Tự động tăng)
//▪ bookName – tên sách – String (Không được để trống)
//▪ author – tác giả – String (Không được để trống)
//▪ descriptions – mô tả về sách – String (Không được để trống, ít nhất 10 ký tự)
//▪ importPrice – giá nhập – double (phải lớn hơn 0)
//▪ exportPrice – giá xuất – double (phải lớn hơn 1.2 lần giá nhập)
//▪ interest – lợi nhuận – float
//▪ bookStatus – trạng thái – Boolean (mặc định là true)

}