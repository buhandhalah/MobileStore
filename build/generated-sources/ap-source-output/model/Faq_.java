package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-14T17:53:02")
@StaticMetamodel(Faq.class)
public class Faq_ { 

    public static volatile SingularAttribute<Faq, String> faqStatus;
    public static volatile SingularAttribute<Faq, String> question;
    public static volatile SingularAttribute<Faq, String> answer;
    public static volatile SingularAttribute<Faq, Customer> customerId;
    public static volatile SingularAttribute<Faq, Integer> id;

}