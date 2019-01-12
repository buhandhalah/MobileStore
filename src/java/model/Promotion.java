/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author StudentAdmin
 */
@Entity
@Table(name = "PROMOTION")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findBrand", query = "SELECT p FROM Promotion p WHERE p.productId.brand  = :brand"),
    @NamedQuery(name = "Promotion.SortByDiscount", query = "SELECT p FROM Promotion p ORDER BY p.discountAmt ASC"),
    @NamedQuery(name = "Promotion.findTodays", query = "SELECT p FROM Promotion p WHERE p.startDate <= :tdate and p.endDate >= :tdate"),
    @NamedQuery(name = "Promotion.findBrandTodays", query = "SELECT p FROM Promotion p WHERE p.startDate <= :tdate and p.endDate >= :tdate and p.productId.brand  = :brand"),
    @NamedQuery(name = "Promotion.findByPromoId", query = "SELECT p FROM Promotion p WHERE p.promoId = :promoId"),
    @NamedQuery(name = "Promotion.findBrandAll", query = "SELECT p FROM Promotion p WHERE p.startDate Between :tdate and p.endDate >= :tdate and p.productId.brand  = :brand"),
    @NamedQuery(name = "Promotion.findByStartDate", query = "SELECT p FROM Promotion p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Promotion.findByEndDate", query = "SELECT p FROM Promotion p WHERE p.endDate = :endDate")})
public class Promotion implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DISCOUNT_AMT")
    private Integer discountAmt;
    @Column(name = "PROMO_ID")
    private Integer promoId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Product productId;

    public Promotion() {
    }

     public Promotion(Integer promoId) {
        this.promoId = promoId;
    }
     
    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
    
    

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        hash += (promoId != null ? promoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.promoId == null && other.promoId != null) || (this.promoId != null && !this.promoId.equals(other.promoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promotion[ promoId=" + promoId + " ]";
    }

    public Integer getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Integer discountAmt) {
        this.discountAmt = discountAmt;
    }
    
}
