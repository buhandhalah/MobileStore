/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author StudentAdmin
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAllDistinctBrands", query = "SELECT DISTINCT p.brand From Product p order by p.brand ASC"),
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByPName", query = "SELECT p FROM Product p WHERE p.pName = :pName"),
    @NamedQuery(name = "Product.findBybrandM", query = "SELECT p FROM Product p WHERE p.brand = :rbrand and p.modelName = :mmodel"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByImgFilename", query = "SELECT p FROM Product p WHERE p.imgFilename = :imgFilename"),
    @NamedQuery(name = "Product.findByModelName", query = "SELECT p FROM Product p WHERE p.modelName = :modelName"),
    @NamedQuery(name = "Product.findByBrandAndMaxPrice", query = "SELECT p FROM Product p WHERE p.brand = :brand AND p.price <= :maxPrice"),
    @NamedQuery(name = "Product.findByMaxPrice", query = "SELECT p FROM Product p WHERE p.price <= :maxPrice"),
    @NamedQuery(name = "Product.findAllDistinctModels", query = "SELECT DISTINCT p.modelName From Product p where p.brand = :brand order by p.modelName ASC"),
    @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "P_NAME")
    private String pName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Size(max = 70)
    @Column(name = "IMG_FILENAME")
    private String imgFilename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "MODEL_NAME")
    private String modelName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "BRAND")
    private String brand;
    @OneToMany(mappedBy = "productId")
    private Collection<Cartitem> cartitemCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<Rating> ratingCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<Promotion> promotionCollection;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String pName, BigDecimal price, String modelName, String brand) {
        this.id = id;
        this.pName = pName;
        this.price = price;
        this.modelName = modelName;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImgFilename() {
        return imgFilename;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlTransient
    public Collection<Cartitem> getCartitemCollection() {
        return cartitemCollection;
    }

    public void setCartitemCollection(Collection<Cartitem> cartitemCollection) {
        this.cartitemCollection = cartitemCollection;
    }

    @XmlTransient
    public Collection<Rating> getRatingCollection() {
        return ratingCollection;
    }

    public void setRatingCollection(Collection<Rating> ratingCollection) {
        this.ratingCollection = ratingCollection;
    }

    @XmlTransient
    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ id=" + id + " ]";
    }
    
}
