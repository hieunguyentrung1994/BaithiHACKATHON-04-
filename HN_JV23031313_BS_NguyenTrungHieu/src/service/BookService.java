package service;

import ra.bussiness.Book;




public class BookService {
    private static Book[]  listBook = new Book[100];
    private static int size;
    public static Book[]getAll(){
        return listBook;
    }
    public static int getSize(){
        return size;
    }




    public static boolean save(Book cat){
        // add
        if (findById(cat.getId())==null){
            if (size==listBook.length){
                System.err.println("Danh sách danh muc quá số lương, vui lòng them moi sau");
                return false;
            }else {
                for (int i = 0; i < listBook.length; i++) {
                    if(listBook[i]==null){
                        listBook[i] = cat;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        }else {
            // update
            for (int i = 0; i < listBook.length; i++) {
                if (listBook[i]!=null&& listBook[i].getId()== cat.getId()){
                    listBook[i] = cat;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }
    public static Book findById(int id){
        for (Book cat:listBook) {
            if (cat!=null) {
                if (cat.getId() == id) {
                    return cat;
                }
            }
        }
        return null;
    }
    public static int getNewId(){
        BookService bookService = new BookService();
        int max = 0;
        for (Book cat: bookService.listBook) {
            if(cat!= null ){
                if (cat.getId()>= max){
                    max = cat.getId();
                }
            }
        }
        return max+1;
    }
    public static boolean delete(int id){
        if (findById(id) != null){
            for (int i = 0; i < listBook.length ; i++) {
                if (listBook[i]!=null&& listBook[i].getId()== id){
                    listBook[i] = null;
                    break;
                }
            }
            size--;
            System.out.println("Xóa thành công");
            return true;
        }
        System.out.println("không tìm thấy id cần xóa");
        return false;

    }
}

