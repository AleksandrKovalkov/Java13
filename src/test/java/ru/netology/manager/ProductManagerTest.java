package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "1984", 100, "George Orwell");
    private Book book2 = new Book(2, "Fight Club", 200, "Chuck Palahniuk");
    private Book book3 = new Book(3, "Prisoner of the Castle of If", 300, "Alexandr Duma");
    private Smartphone smartphone1 = new Smartphone(1, "Iphone 11", 30_000, "Apple");
    private Smartphone smartphone2 = new Smartphone(2, "Readmi note 9", 15_000, "Xiaomi");
    private Smartphone smartphone3 = new Smartphone(3, "Galaxy 12", 25_000, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void searchBookByNameIfExistOneProduct() {
        String text = "Prisoner of the Castle of If";

        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfExistTwoProduct() {
        String text = "Fight Club";

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfNotExist() {
        String text = "Not exist";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchBookByAuthorIfNotExist() {
        String text = "Not exist author";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfExistOneProduct() {
        String text = "Galaxy 12";

        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchSmartphoneByNameIfNotExist() {
        String text = "Not exist name";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchSmartphoneByManufacturerIfNotExist() {
        String text = "Not exist Manufacturer";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }
}