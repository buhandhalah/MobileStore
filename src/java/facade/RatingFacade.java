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
public class RatingFacade extends AbstractFacade<Rating> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Rating> findById(Product id) {
       return getEntityManager().createNamedQuery("Rating.findById",Rating.class)
               .setParameter("id",id)
                .getResultList();     
    }

    public RatingFacade() {
        super(Rating.class);
    }

    public List<Faq> findByStatus(Faq f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
