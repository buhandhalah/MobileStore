/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.Cart;
import model.Customer;
import model.Shipping;

/**
 *
 * @author StudentAdmin
 */
@Stateless
public class ShippingFacade extends AbstractFacade<Shipping> {

    @PersistenceContext(unitName = "MobileStorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShippingFacade() {
        super(Shipping.class);
    }
    public Shipping findunshipped(Customer user) {
        //if we are looking for single result and if there is no result catch exception NoResultException: getSingleResult() did not retrieve any entities.
        try{
        return getEntityManager().createNamedQuery("Shipping.findUnpaidBycustomer", Shipping.class)
                .setParameter("customer_id", user)
                .getSingleResult();
        }catch(NoResultException e){
        return null;
        }
}
}