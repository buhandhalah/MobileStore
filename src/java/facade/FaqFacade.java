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
import model.Faq;
import model.Product;
import model.Rating;

/**
 *
 * @author StudentAdmin
 */
@Stateless
public class FaqFacade extends AbstractFacade<Faq> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Faq> findByStatus() {
       return getEntityManager().createNamedQuery("Faq.findByStatus",Faq.class)
                .getResultList();     
    }

    public FaqFacade() {
        super(Faq.class);
    }
    
}
