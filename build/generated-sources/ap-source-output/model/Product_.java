package model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cartitem;
import model.Promotion;
import model.Rating;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> modelName;
    public static volatile SingularAttribute<Product, String> imgFilename;
    public static volatile SingularAttribute<Product, String> pName;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile CollectionAttribute<Product, Promotion> promotionCollection;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile CollectionAttribute<Product, Cartitem> cartitemCollection;
    public static volatile SingularAttribute<Product, String> brand;
    public static volatile CollectionAttribute<Product, Rating> ratingCollection;

}