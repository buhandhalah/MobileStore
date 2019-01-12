package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Customer;
import model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, String> feedback;
    public static volatile SingularAttribute<Rating, Product> productId;
    public static volatile SingularAttribute<Rating, Customer> customerId;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, String> title;
    public static volatile SingularAttribute<Rating, Integer> productRating;

}