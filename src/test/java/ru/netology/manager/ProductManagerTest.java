package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "1984", 100, "George Orwell");
    Product product2 = new Book(2, "Fight Club", 200, "Chuck Palahniuk");
    Product product3 = new Book(3, "Prisoner of the Castle of If", 300, "Alexandr Duma");
    Product product4 = new Book(4, "Three Musketeers", 250, "Alexandr Duma");
    Product product5 = new Smartphone(1, "Iphone 11", 30_000, "Apple");
    Product product6 = new Smartphone(2, "Readmi note 9", 15_000, "Xiaomi");
    Product product7 = new Smartphone(3, "Galaxy 12", 25_000, "Samsung");
    Product product8 = new Smartphone(4, "Iphone 11 Pro", 33_900, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }


    @Test
    void searchSmartphoneByNameIfExistOneProduct() {
        String text = "Galaxy 12";

        Product[] expected = new Product[]{product7};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByNameIfExistTwoProduct() {
        String text = "Iphone 11";


        Product[] expected = new Product[]{product5, product8};
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

    @Test
    void searchSmartphoneByManufacturerIfExist() {
        String text = "Samsung";

        boolean expected = false;
        boolean actual = manager.matches(product7, text);

        assertEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfExistOneProduct() {
        String text = "Prisoner of the Castle of If";

        Product[] expected = new Product[]{product3};
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
    void searchBookByAuthorIfExistOneProduct() {
        String text = "George Orwell";

        boolean expected = false;
        boolean actual = manager.matches(product1, text);
        assertEquals(expected, actual);
    }


    @Test
    void searchBookByAuthorIfNotExist() {
        String text = "Not exist author";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

}
