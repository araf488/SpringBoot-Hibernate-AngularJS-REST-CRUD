/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.IProductDAO;
import com.mycompany.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arefin
 */
@Service
public class ProductService implements IProductService{
    
    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        Product obj = productDAO.getProductById(id);
        return obj;
    }

    @Override
    public synchronized boolean addProduct(Product product) {
        if (productDAO.productExists(product.getPname(), product.getPrice(), product.getQty())) {
            return false;
        } else {
            productDAO.addProduct(product);
            return true;
        }
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDAO.deleteProduct(id);
    }
    
}
