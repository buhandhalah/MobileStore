/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author StudentAdmin
 */
@Entity
@Table(name = "CARTITEM")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Cartitem.findByCartAndProduct", query = "SELECT c FROM Cartitem c where c.cartId = :cartid and c.productId = :productcode"), //created by me
    
    @NamedQuery(name = "Cartitem.findProductPopularity", query = "SELECT c FROM Cartitem c WHERE c.productId = :productcode"),
    
    @NamedQuery(name = "Cartitem.findByQty", query = "SELECT c FROM Cartitem c ORDER BY  c.quantity DESC"),
    
    @NamedQuery(name = "Cartitem.findCartitemByCart", query = "SELECT c FROM Cartitem c where c.cartId = :cartid"), //created by me
    @NamedQuery(name = "Cartitem.findAll", query = "SELECT c FROM Cartitem c"),
    @NamedQuery(name = "Cartitem.findById", query = "SELECT c FROM Cartitem c WHERE c.id = :id"),
    @NamedQuery(name = "Cartitem.findByQuantity", query = "SELECT c FROM Cartitem c WHERE c.quantity = :quantity")})
public class Cartitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cart cartId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Product productId;

    public Cartitem() {
    }

    public Cartitem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof Cartitem)) {
            return false;
        }
        Cartitem other = (Cartitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cartitem[ id=" + id + " ]";
    }
    
}
