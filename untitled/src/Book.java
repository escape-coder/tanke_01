/**
 * @Package: PACKAGE_NAME
 * @ClassName: Book
 * @Author: Mr.Zhang
 * @CreateTime: 2020/9/24 19:27
 * @Description:书的类
 */
public class Book {
    int booknumber;
    String bookname;

    public static void main(String[] args) {
        Book book = new Book();
        book.bookname = "Java web";
        book.booknumber = 10;
        System.out.println("书名:" + book.bookname + "书号:" + book.booknumber);

    }
}
