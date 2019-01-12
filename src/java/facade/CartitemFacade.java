/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.Cart;
import model.Cartitem;
import model.Product;

/**
 *
 * @author StudentAdmin
 */
@Stateless
public class CartitemFacade extends AbstractFacade<Cartitem> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartitemFacade() {
        super(Cartitem.class);
    }
     public Cartitem findByCartAndProduct(Cart c,Product p) {
        //if we are looking for single result and if there is no result catch exception NoResultException: getSingleResult() did not retrieve any entities.
        try{
        return getEntityManager().createNamedQuery("Cartitem.findByCartAndProduct", Cartitem.class)
                .setParameter("cartid", c)
                .setParameter("productcode", p)
                .getSingleResult();
        }catch(NoResultException e){
        return null;
        }
    }
    
       public List<Cartitem> findCartitemByCart(Cart c) {
        //if we are looking for single result and if there is no result catch exception NoResultException: getSingleResult() did not retrieve any entities.
        return getEntityManager().createNamedQuery("Cartitem.findCartitemByCart", Cartitem.class)
                .setParameter("cartid", c)
                .getResultList();        
    }
       
       public List<Cartitem> findProductPopularity(Product productcode) {
        //if we are looking for single result and if there is no result catch exception NoResultException: getSingleResult() did not retrieve any entities.
        return getEntityManager().createNamedQuery("Cartitem.findProductPopularity", Cartitem.class)
                .setParameter("productcode", productcode)
                .getResultList();        
    }

    public List <Cartitem> findByQty() {
       return getEntityManager().createNamedQuery("Cartitem.findByQty", Cartitem.class)
                 .getResultList();
    }
}
