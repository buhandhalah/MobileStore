package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cartitem;
import model.Payment;
import model.Shipping;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Cart.class)
public class Cart_ { 

    public static volatile SingularAttribute<Cart, Shipping> shippingId;
    public static volatile SingularAttribute<Cart, Payment> paymentId;
    public static volatile SingularAttribute<Cart, Date> datePurchased;
    public static volatile SingularAttribute<Cart, Integer> id;
    public static volatile CollectionAttribute<Cart, Cartitem> cartitemCollection;
    public static volatile SingularAttribute<Cart, String> cStatus;

}