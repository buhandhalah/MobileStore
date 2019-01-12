/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Date;
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
public class PromotionFacade extends AbstractFacade<Promotion> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }
    
    public List<Promotion> findTodays(Date tdate){
        return getEntityManager().createNamedQuery("Promotion.findTodays", Promotion.class)
                .setParameter("tdate", tdate)
                .getResultList();     
    }
    public List<Promotion> findBrandAll(Date tdate,String brand){
        return getEntityManager().createNamedQuery("Promotion.findBrandAll", Promotion.class)
                .setParameter("tdate", tdate)
                .setParameter("brand",brand)
                .getResultList();     
    }
    
    
    public List<Promotion> findAll() {
       return getEntityManager().createNamedQuery("Promotion.findAll", Promotion.class)
                .getResultList();     
    }
    
     public List<Promotion> findBrand(String brand) {
       return getEntityManager().createNamedQuery("Promotion.findBrand",Promotion.class)
               .setParameter("brand",brand)
                .getResultList();     
    }

    public List<Promotion> sortByDiscount() {
         return getEntityManager().createNamedQuery("Promotion.SortByDiscount", Promotion.class)
                .getResultList();
    }

    public List<Promotion> findBrandTodays(Date tdate, String brand) {
        return getEntityManager().createNamedQuery("Promotion.findBrandTodays",Promotion.class)
               .setParameter("tdate", tdate)
                .setParameter("brand",brand)
                .getResultList();
    }

   
    
    
}
