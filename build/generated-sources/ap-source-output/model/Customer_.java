package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Faq;
import model.Payment;
import model.Rating;
import model.Shipping;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> cPassword;
    public static volatile SingularAttribute<Customer, String> cName;
    public static volatile CollectionAttribute<Customer, Faq> faqCollection;
    public static volatile SingularAttribute<Customer, String> groupname;
    public static volatile CollectionAttribute<Customer, Payment> paymentCollection;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile CollectionAttribute<Customer, Rating> ratingCollection;
    public static volatile SingularAttribute<Customer, String> username;
    public static volatile CollectionAttribute<Customer, Shipping> shippingCollection;

}