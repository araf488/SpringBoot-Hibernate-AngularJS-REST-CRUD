/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.entity.Product;
import java.util.List;

/**
 *
 * @author Arefin
 */
public interface IProductDAO {

    List<Product> getAllProducts();

    Product getProductById(Integer id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    boolean productExists(String pname, double price, int qty);
}
