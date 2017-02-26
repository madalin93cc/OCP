package ocp.designpatterns;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Madalin on 24/02/2017.
 */
public class DAO_FactoryMethodExample {
    public static void main(String[] args) {
//        BookDAO dao = new InMemoryBookDAO();
        Factory factory = new FactoryImpl();
        BookDAO dao = factory.createDao();
        Book book = new Book();
        dao.create(book);
        book.setName("name");
        dao.update(book);
        dao.delete(book);
    }
}

//abstract class Factory {
//    public abstract BookDAO createDao();
//}

abstract class Factory {
    public BookDAO createDao() {
        if (true) {
            return new InMemoryBookDAO();
        } else {
//            other implementation
            return createActualDao();
        }
    }

    protected abstract BookDAO createActualDao();
}

//class FactoryImpl extends Factory {
//    @Override
//    public BookDAO createDao() {
//        return new InMemoryBookDAO();
//    }
//}

class FactoryImpl extends Factory {
    @Override
    public BookDAO createActualDao() {
        // other implementation
        return new InMemoryBookDAO();
    }
}

class Book {
    private String isbn;
    private String name;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface BookDAO {
    Collection<Book> findAllBooks();
    Book findByIsbm(Book book);
    void create(Book book);
    void update(Book book);
    void delete(Book book);
}

class InMemoryBookDAO implements BookDAO {
    private Map<String, Book> bookStore = new HashMap<>();

    @Override
    public Collection<Book> findAllBooks() {
        return bookStore.values();
    }

    @Override
    public Book findByIsbm(Book book) {
        return bookStore.get(book.getIsbn());
    }

    @Override
    public void create(Book book) {
        bookStore.put(book.getIsbn(), book);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {
        bookStore.remove(book.getIsbn());
    }
}
