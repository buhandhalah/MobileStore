package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cart;
import model.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile CollectionAttribute<Payment, Cart> cartCollection;
    public static volatile SingularAttribute<Payment, String> pMethod;
    public static volatile SingularAttribute<Payment, Customer> customerId;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, String> idNumber;

}