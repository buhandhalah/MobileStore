/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Product;
import model.Promotion;

/**
 *
 * @author StudentAdmin
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    public List<String> findAllDistinctBrands() {
       return getEntityManager().createNamedQuery("Product.findAllDistinctBrands", String.class)
                .getResultList();     
    }
     public List<Product> findByBrand(String brand) {
       return getEntityManager().createNamedQuery("Product.findByBrand",Product.class)
               .setParameter("brand",brand)
                .getResultList();     
    }

    public List<Product> findByBrandAndMaxPrice(String brand, double maxPrice) {
        return getEntityManager().createNamedQuery("Product.findByBrandAndMaxPrice",Product.class)
               .setParameter("brand",brand)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }
    
     

    public List<Product> findByMaxPrice(double maxPrice) {
        return getEntityManager().createNamedQuery("Product.findByMaxPrice",Product.class)
                .setParameter("maxPrice", maxPrice)
                .getResultList();
    }

    public List<String> findAllDistinctModels(String brand) {
        return getEntityManager().createNamedQuery("Product.findAllDistinctModels", String.class)
                .setParameter("brand", brand)
                .getResultList();
    }

    public Product findBybrandM(String rbrand, String mmodel) {
        return getEntityManager().createNamedQuery("Product.findBybrandM", Product.class)
                .setParameter("rbrand", rbrand)
                .setParameter("mmodel", mmodel)
                .getSingleResult();
    }
}
