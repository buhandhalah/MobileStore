package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.Product;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:03")
@StaticMetamodel(Cartitem.class)
public class Cartitem_ { 

    public static volatile SingularAttribute<Cartitem, Integer> quantity;
    public static volatile SingularAttribute<Cartitem, Product> productId;
    public static volatile SingularAttribute<Cartitem, Cart> cartId;
    public static volatile SingularAttribute<Cartitem, Integer> id;

}