package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
    }
}