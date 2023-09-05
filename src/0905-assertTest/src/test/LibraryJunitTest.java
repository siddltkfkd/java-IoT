import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import main.Library;

public class LibraryJunitTest {
    private static final String NEGATIVE_LIBRARY_MESSAGE = "음수로는 도서관을 생성할 수 없습니다.";
    private static final String ADD_MORE_THAN_MAX_MESSAGE = "도서관 최대 용량을 초과해 책을 추가할 수 없습니다.";
    private static final String ADD_DUPLICATE_BOOK_MESSAGE = "도서관에 같은 이름의 책이 존재합니다.";
    private static final String DELETE_NOT_EXIST_BOOK_MESSAGE = "도서관에 존재하지 않는 책은 삭제할 수 없습니다.";
    Library library;
        
    @BeforeEach
    void setUp() {
        library = new Library(5);
        library.add("해리포터");
        library.add("어린왕자");
        library.add("샬롯의 거미줄");
    }

    @Test
    void isOutOfBounds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Library(-1));
    }

    @Test
    void countBooks() {
        Assertions.assertEquals(library.getTotalBookCount(), 3);
    }

    @Test
    void morThanMax() {
        library.add("book1");
        library.add("book2");
        library.add("book3");
        library.add("book4");
        library.add("book5");
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.add("book6"));
    }
}


