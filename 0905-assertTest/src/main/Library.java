package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";

    List<String> bookList;

    public Library(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(NEGATIVE_LIBRARY_MESSAGE);
        }
        bookList = new ArrayList<>(i);
    }

    public void add(String book) {
        if (bookList.contains(book)) {
            throw new IllegalArgumentException(ADD_DUPLICATE_BOOK_MESSAGE);
        }
        try {
            bookList.add(book);
        } catch (Exception e) {
            throw new IllegalArgumentException(ADD_MORE_THAN_MAX_MESSAGE);
        }
    }

    public int getTotalBookCount() {
        return bookList.size();
    }

    public boolean find(String book) {
        return bookList.contains(book);
    }

    public void delete(String book) {
        if (bookList.contains(book) == false) {
            throw new IllegalArgumentException(DELETE_NOT_EXIST_BOOK_MESSAGE);
        }
        bookList.remove(book);
    }

}
