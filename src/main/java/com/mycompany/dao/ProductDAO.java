/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.entity.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Arefin
 */
@Transactional
@Repository
public class ProductDAO implements IProductDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        String hql = "FROM Product as p ORDER BY p.id";
        return (List<Product>) hibernateTemplate.find(hql);
    }

    @Override
    public Product getProductById(Integer id) {
        return hibernateTemplate.get(Product.class, id);
    }

    @Override
    public void addProduct(Product product) {
        hibernateTemplate.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product p = getProductById(product.getId());
        p.setPname(product.getPname());
        p.setPrice(product.getPrice());
        p.setQty(product.getQty());
        hibernateTemplate.update(p);
    }

    @Override
    public void deleteProduct(Integer id) {
        hibernateTemplate.delete(getProductById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean productExists(String pname, double price, int qty) {
        String hql = "FROM Product as p WHERE p.pname = ? and p.price = ? and p.qty = ?";
        List<Product> product = (List<Product>) hibernateTemplate.find(hql, pname, price, qty);
        return product.size() > 0 ? true : false;
    }

}
