/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author StudentAdmin
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findUnpaidByUsername", query = "SELECT c FROM Cart c " + " WHERE c.customerId = :customer_id AND c.cStatus = 'unpaid'"),
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.id = :id"),
    @NamedQuery(name = "Cart.findByCStatus", query = "SELECT c FROM Cart c WHERE c.cStatus = :cStatus"),
    @NamedQuery(name = "Cart.findByDatePurchased", query = "SELECT c FROM Cart c WHERE c.datePurchased = :datePurchased")})
public class Cart implements Serializable {

    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "USERNAME")
    @ManyToOne(optional = false)
    private Customer customerId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 15)
    @Column(name = "C_STATUS")
    private String cStatus;
    @Column(name = "DATE_PURCHASED")
    @Temporal(TemporalType.DATE)
    private Date datePurchased;
    @OneToMany(mappedBy = "cartId")
    private Collection<Cartitem> cartitemCollection;
    @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Payment paymentId;
    @JoinColumn(name = "SHIPPING_ID", referencedColumnName = "ID")
    @ManyToOne
    private Shipping shippingId;

    public Cart() {
    }

    
    public Cart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCStatus() {
        return cStatus;
    }

    public void setCStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    
    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }

    @XmlTransient
    public Collection<Cartitem> getCartitemCollection() {
        return cartitemCollection;
    }

    public void setCartitemCollection(Collection<Cartitem> cartitemCollection) {
        this.cartitemCollection = cartitemCollection;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public Shipping getShippingId() {
        return shippingId;
    }

    public void setShippingId(Shipping shippingId) {
        this.shippingId = shippingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cart[ id=" + id + " ]";
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
    
}
