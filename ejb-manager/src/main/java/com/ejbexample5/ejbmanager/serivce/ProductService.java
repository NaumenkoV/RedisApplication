package com.ejbexample5.ejbmanager.serivce;


import com.ejbexample5.entity.Product;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Вадим on 22.08.2014.
 */
@Local
public interface ProductService {
    Product getProduct(String mpn, int availability, int pricesort);
    void addProduct(Product product);
    void deleteProductById(String id);
    void updateProduct(Product product);
    List<Product> getAllProducts();
    void addAllProducts(List<Product> productList);
}
