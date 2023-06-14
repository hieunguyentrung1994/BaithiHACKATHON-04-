package run;

import ra.bussiness.Book;
import service.BookService;

import java.util.Scanner;

public class Main {
    static Book book = new Book();
    private static BookService bookService = new BookService();

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
                    inputData();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:

                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:

                    break;
                case 6:
                    updateCategory();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Nhập số từ 1 đến 7");
            }
        }
    }

    public static void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng danh mục cần thêm mới");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin danh mục thứ " + (i + 1));
            Book newBook = new Book();
            int id = BookService.getNewId();
            System.out.println("mã sách : " + id);
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
            newBook.setExportPrice(scanner.nextDouble());

            // lưu nó vào listBook
            bookService.save(newBook);

        }
    }

    public static void displayAll() {
        Book[] listBook = BookService.getAll();
        if (BookService.getSize() == 0) {
            System.err.println("danh sách trống");
        } else {
            for (Book cat : listBook) {
                if (cat != null) {
                    System.out.println(cat);
                }
            }
        }
    }
    public static void deleteBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốn xóa");
        int idDel = scanner.nextInt();
        // cho phép xóa
        BookService.delete(idDel);
    }

    public static  void  updateCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" hãy nhập vào id của danh mục muốnn sửa");
        int idEdit = scanner.nextInt();
        Book categoryEdit = BookService.findById(idEdit);
        if (categoryEdit!= null){
            Book newBook = new Book();
            // có ton tại , cho phép chỉnh sửa
            System.out.println("nhập tên Sach:");
            categoryEdit.setBookName(scanner.nextLine());

            System.out.println("nhập tên Tác Giả:");
            categoryEdit.setAuthor(scanner.nextLine());

            System.out.println("nhập tên mô tả về sách:");
            categoryEdit.setDescriptions(scanner.nextLine());

            System.out.println("nhập giá nhập của sách:");
            categoryEdit.setImportPrice(scanner.nextDouble());

            System.out.println("nhập giá xuất của sách:");
            categoryEdit.setExportPrice(scanner.nextDouble());


            BookService.save(categoryEdit);
        }else {
            System.err.println("Id không tồn tại");
        }
    }

}