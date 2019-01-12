package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:03")
@StaticMetamodel(Shipping.class)
public class Shipping_ { 

    public static volatile CollectionAttribute<Shipping, Cart> cartCollection;
    public static volatile SingularAttribute<Shipping, String> address;
    public static volatile SingularAttribute<Shipping, Customer> customerId;
    public static volatile SingularAttribute<Shipping, Integer> id;

}