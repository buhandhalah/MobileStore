/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import model.Cart;
import model.Cartitem;
import model.Customer;
import model.Faq;
import model.Payment;
import model.Product;
import model.Promotion;
import model.Promotion;
import model.Rating;
import model.Shipping;

import facade.CartFacade;
import facade.CartitemFacade;
import facade.CustomerFacade;
import facade.FaqFacade;
import facade.PaymentFacade;
import facade.ProductFacade;
import facade.PromotionFacade;
import facade.RatingFacade;
import facade.ShippingFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@Named("userController")
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private facade.CustomerFacade ejbFacade;

    @EJB
    private facade.PromotionFacade ejbPromotionFacade;
    
    @EJB
    private facade.ProductFacade ejbProductFacade;

    @EJB
    private facade.CartFacade ejbCartFacade;
    
   

    @EJB
    private facade.PaymentFacade ejbPaymentFacade;

    @EJB
    private facade.CartitemFacade ejbCartitemFacade;

    @EJB
    private facade.ShippingFacade ejbShippingFacade;
    @EJB
    private facade.RatingFacade ejbRatingFacade;
     @EJB
    private facade.FaqFacade ejbFaqFacade;

    
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String maxPrice;
    private String brand;
    private String model;
    Integer code;
    Integer id;
    //private Date Today = ;
    Integer promoprod;
    private String dis;
    String selection;
    String search;
    public UserController() {

    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
     public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
    
    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getDis() {
        return dis;
    }

    public RatingFacade getEjbRatingFacade() {
        return ejbRatingFacade;
    }

    public void setEjbRatingFacade(RatingFacade ejbRatingFacade) {
        this.ejbRatingFacade = ejbRatingFacade;
    }

    public FaqFacade getEjbFaqFacade() {
        return ejbFaqFacade;
    }
    
    

    private String password;

//    public void setToday(Date Today) {
//        this.Today = Today;
//    }
 
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public PromotionFacade getEjbPromotionFacade() {
        return ejbPromotionFacade;
    }

    
    public ShippingFacade getEjbShippingFacade() {
        return ejbShippingFacade;
    }

    public CustomerFacade getEjbFacade() {
        return ejbFacade;
    }

    
    public PaymentFacade getEjbPaymentFacade() {
        return ejbPaymentFacade;
    }

    public CartitemFacade getEjbCartitemFacade() {
        return ejbCartitemFacade;
    }

    public CartFacade getEjbCartFacade() {
        return ejbCartFacade;
    }

    public ProductFacade getEjbProductFacade() {
        return ejbProductFacade;
    }

    public void setEjbPaymentFacade(PaymentFacade ejbPaymentFacade) {
        this.ejbPaymentFacade = ejbPaymentFacade;
    }

    public String getMaxPrice() {

        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {

        this.maxPrice = maxPrice;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
   
    
    
     

    public List<String> getModels() {
        
        return getEjbProductFacade().findAllDistinctModels(rbrand);
    
    }
    
    private String td;
    
    public void setTd(String td) {
        this.td = td;
    }

    public String getTd() {
        return td;
    }


    
      Date date = new java.util.Date();
    
 public String increaseQuantity(Cartitem item) {
        return Buy(item.getProductId().getId());
}
 
 public String decreaseQuantity(Cartitem item) {
        Cartitem c = item;
        if (c.getQuantity() <= 1) {
            deleteCartitem(c);
        } else {
            c.setQuantity(item.getQuantity() - 1);
            getEjbCartitemFacade().edit(c);
        }
        return "/user/cart/View?faces-redirect=true";
    }
 
 public String deleteCartitem(Cartitem cartitem) {
        getEjbCartitemFacade().remove(cartitem);
        return "/user/cart/View?faces-redirect=true";
    }
    
    public List<Promotion> GETDiscount() {
        return getEjbPromotionFacade().sortByDiscount();
        
    }
    
    
        
        private boolean haveTodays() {
        return !(td == null || td.isEmpty());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
        
        
    
    public List<Promotion> getTodays(){
       if(haveTodays() && "promoToday".equals(td) && !haveModel()){
       return getEjbPromotionFacade().findTodays(date);
       }
       else if(haveTodays() && "promoToday".equals(td)&& haveModel()){
              
                  return getEjbPromotionFacade().findBrandTodays(date,model);
              }
              
       else if (!haveTodays() && "AllPromotion".equals(td) && haveModel()) {
            return getEjbPromotionFacade().findBrand(model);
       }
        else if (haveTodays() && "AllPromotion".equals(td) && haveModel()) {
            return getEjbPromotionFacade().findBrand(model);
       }
       else{
       return getEjbPromotionFacade().findAll();
       }
}
//        try {
//            Date date = dd.parse(nd);
//         
//            System.out.println(dd.format(date));
//
//     return getEjbPromotionFacade().findTodays(date);
//   
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//          return getEjbPromotionFacade().findAll();


     
//   if(td != null){
//     return getEjbPromotionFacade().findTodays(date);
//    } 
   
   
    public List<Product> getProducts() {
        //should look at brand to see if user wants a certain brand

        System.out.println("Brand = " + brand + ",");
        if (haveBrand() && havMaxPrice()) {
            return getEjbProductFacade().findByBrandAndMaxPrice(brand, Integer.parseInt(maxPrice)); //findAll();
        } else if (haveBrand() && !havMaxPrice()) {
            System.out.println("test");
            return getEjbProductFacade().findByBrand(brand);
        } else if (!haveBrand() && havMaxPrice()) {
            return getEjbProductFacade().findByMaxPrice(Integer.parseInt(maxPrice));
        } else {
            return getEjbProductFacade().findAll();
           
        }

    }

    public String logout() {
        ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false)).invalidate();
        return "/public/product/List?faces-redirect=true";
    }

    public List<Cartitem> getCartitem() {

        if (code != null) {
            Buy(code);
        }
        return getEjbCartitemFacade().findCartitemByCart(getCart());
    }
    public String manageAccount() {
        String user = getUser();
        String groupname = groupname();
        getSelected().setUsername(user);
        getSelected().setCName(user);
        getSelected().setGroupname(groupname);
        return "/user/customer/ManageAccount";
    }
    
    String CPassword;

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }
    
    
      public String updatePassword() {
        String user = getUser();
        String groupname = groupname();
        getSelected().setUsername(user);
        getSelected().setCName(user);
        getSelected().setGroupname(groupname);
        getSelected().setCPassword(CPassword);
        
        
            return null;
        }
    
    
    public String groupname() {
        String user = getUser();
        String groupname;
        if (user.equals("admin")) {
            groupname = "admin";
        } else {
            groupname = "user";
        }
        return groupname;
    }
    
    public String getUser() {
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return user;
    }
    
     public String getColor() {
        String user = getUser();
        if (user == null) {
            return "background: #2E2E2E";
        } else if (user.equals("admin")) {
            return "background: #6B5778";
        }

        return "background: #564F47";
    }

    public String prepareBuy(Integer productCode) {
        System.out.println("PREPARE BUY");
        this.code = productCode;
        return "/user/cart/View?faces-redirect=true";
    }

    public String Buy(int code) {
        System.out.println("BUY");
        this.code = null;
        Product product = getEjbProductFacade().find(code);

        // find user's unpaid cart        
        Cart cart = getCart();

        System.out.println(cart.getCustomerId().getCName());

        // add new cartitem to cart(unless it exist then increment quantity only)
        // - find cartitem by cart and product
        // - if cartitem null, create new, quantity = 0
        Cartitem cartitem = getCartItem(cart, product);

        // - increment the quantitiy (increment quantity is the best way because in a scenario where cartitem already exist it is just incrementing thye number.
        cartitem.setQuantity(cartitem.getQuantity() + 1);

        // - save to db
        getEjbCartitemFacade().edit(cartitem);

        //return "/user/cart/View";
        return "/user/cart/View";
    }
    
    

    public Cart getCart() {

        //--not needed (cart == null) { }//if cart is null try to find the cart in the database
        // Look up logged-in user-cart in the database
        Shipping shipping = getEjbShippingFacade().findunshipped(getSelected());
        if (shipping == null) {
            System.out.println("Creating new Shipping.....");
            shipping = new Shipping();
            shipping.setAddress("");
            shipping.setCustomerId(getSelected());
            getEjbShippingFacade().create(shipping);
        }
        Payment payment = getEjbPaymentFacade().findunpaid(getSelected());
        if (payment == null) {
            System.out.println("Creating new payment.....");
            payment = new Payment();
            payment.setPMethod("");
            payment.setIdNumber("");
            payment.setCustomerId(getSelected());
            getEjbPaymentFacade().create(payment);
        }

        Cart cart = getEjbCartFacade().findunpaid(getSelected());
        if (cart == null) {                     //if the cart is still null the create a new cart
            // if not found create one
            System.out.println("Creating new cart ....");
            cart = new Cart();                  //create new cart
            cart.setCustomerId(getSelected());   //when creating cart put username foriegn key
            cart.setCStatus("unpaid");           // make cart status unpaid
            cart.setDatePurchased(new java.util.Date());

            cart.setPaymentId(payment);
            cart.setShippingId(shipping);
            getEjbCartFacade().create(cart);

        }
        return cart;
    }

    public Cartitem getCartItem(Cart cart, Product product) {

        // if (cartitem == null) {  get rid because we are directly taking stuffs from db and then we check whether it is null or not later
        //if cartitem is null try to find the cart in the database
        // Look upcart item in the database by cartid and product
        Cartitem cartitem = getEjbCartitemFacade().findByCartAndProduct(cart, product);

        if (cartitem == null) {                     //if the cartitem is still null the create a new cartitem
            // if not found create one
            System.out.println("Creating new cartitem ....");
            cartitem = new Cartitem();                  //create new cartitem
            cartitem.setCartId(cart);                   //when creating cartitem it requires cartid foriegn key
            cartitem.setProductId(product);           // when creating cartitem it requires productid foriegn key
            cartitem.setQuantity(0);
            getEjbCartitemFacade().create(cartitem);

        }

        return cartitem;
    }
    
   /* public List<Promotion> GETDiscount() {
        return getEjbPromotionFacade().sortByDiscount();
        
    } */
    
    public List<Rating> GetItems(Product p) {
        return getEjbRatingFacade().findById(p);
    }
    
   

    public List<Faq> FItems() {
        return getEjbFaqFacade().findByStatus();
    }
    
    public Customer getSelected() {

        //if (current == null) { get rid because we are directly taking stuffs from db and then we check whether it is null or not later
        // Look up logged-in user in the database
        // need to know log-in username
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        Customer current = getEjbFacade().find(username);
        // }
        return current;
    }
    
    Product p;
    
    public Product getProduct(){
    return p;
    }
    
    public void setProduct(Product p){
    this.p = p;
    }
    
    public String viewProduct(Product p){
    setProduct(p);
    return "/public/product/View";
    }
    
    public String viewFaq(){
    
    return "/public/faq/List?faces-redirect=true";
    }
    
    public String addReview(){
    return "/user/rating/Create_1?faces-redirect=true";
    }
    
    String f;
    
    public String getFaq(){
    return f;
    }
    
    public void setFaq(String f){
    this.f = f;
    }
    
    public String addQuestion(){
    setFaq(f);
    return "/public/Faq/Create?faces-redirect=true";
    }
    
    String FeedBack;
    
    public String getFeedBack(){
    return FeedBack;
    }
    
    public void setFeedBack(String s){
    this.FeedBack = s;
    }
    
    String ProductRating;
    
    public String getProductRating(){
    return ProductRating;
    }
    
    public void setProductRating(String s){
    this.ProductRating = s;
    }
    
    String Question;
    
    String Answer;
    
    public String getQuestion(){
        return Question;
    }
    
    public void setQuestion(String q){
    this.Question=q;
    }
    
    public String getAnswer(){
        return Answer;
    }
    
    public void setAnswer(String a){
    this.Answer=a;
    }
    
    String title;
    String feedback;
    String productId;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }
    
    
    
    public String createReview(Rating r) {
        try {
            r.setCustomerId(getSelected());
            r.setProductId(p);
            getEjbRatingFacade().create(r);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RatingCreated"));
            return viewProduct(p);
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
    
    String mmodel;
    public void setMmodel(String mmodel) {
        this.mmodel = mmodel;
    }
    
     public String getMmodel() {
        return mmodel;
    }
    
     String rbrand;
     public void setRBrand(String rbrand) {
        this.rbrand = rbrand;
    }

    public String getRBrand() {
        return rbrand;
    }
    
    int Cartid;

    public int getCartid() {
        return Cartid;
    }

    public void setCartid(int Cartid) {
        this.Cartid = 1;
    }
    
    

   public List <Cartitem> getMostSold() {
      return getEjbCartitemFacade().findByQty();
       // System.out.println("ID = "+ a);
     // return null;
    }
    
    
    
    public Product getProductID() {
      return getEjbProductFacade().findBybrandM(rbrand,mmodel);
       // System.out.println("ID = "+ a);
     // return null;
    }
    
     public String NewReview(Rating r) {
        try {
            r.setProductId(getProductID());
            r.setCustomerId(getSelected());
            getEjbRatingFacade().create(r);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RatingCreated"));
            return viewProduct1(p);
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }
     
     private String viewProduct1(Product p) {
        setProduct(p);
    return "/public/product/View_1";
    }
    
    public String createQuestion() {
        try {
            Faq ff = new Faq();
            ff.setCustomerId(getSelected());
            ff.setQuestion(Question);
            ff.setAnswer("");
            ff.setFaqStatus("UnApproved");
            ff.setCustomerId(getSelected());
            getEjbFaqFacade().create(ff);
            JsfUtil.addSuccessMessage("Faq question has been posted. The question will be answered shortly.");
            return viewFaq();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    Promotion pp;
     public Promotion getPromotion(){
    return pp;
    }
    
    public void setPromotion(Promotion pp){
    this.pp = pp;
    }
    
    public String ViewPromotion(Promotion pp){
    setPromotion(pp);
    return "/public/promotion/View";
    }
    
    
    
    public List<String> getBrands() {

        return getEjbProductFacade().findAllDistinctBrands();
    }

    public boolean havMaxPrice() {
        return !(maxPrice == null || maxPrice.isEmpty());
    }

    private boolean haveBrand() {
        return !(brand == null || brand.isEmpty());
    }
    
    private boolean haveModel() {
        return !(model == null || model.isEmpty());
    }
    
    public double getCartTotal(){
    List<Cartitem> c = getCartitem();
    double total = 0.0;
    for(int i =0; i< c.size(); i++){
               double productPrice =  (c.get(i).getProductId().getPrice()).doubleValue();
               int quantity = c.get(i).getQuantity();
               double t = (double)((productPrice) * (quantity));
            total+= t;
            } 
        return total;
    }
    
    double pop;

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }
    
 
     public double findProductPopularity(Product p) {
        Integer totalProductItems = 0;
        
        List<Cartitem> pi = getEjbCartitemFacade().findProductPopularity(p);
        if(pi != null){
            System.out.println("got in if");
            System.out.println("pi size" + pi.size());
            for(int i =0; i< pi.size(); i++){
                System.out.println("got in for loop" + pi.get(i).getQuantity());
            totalProductItems+= pi.get(i).getQuantity();
            }                                   
        }
        Integer tt = 0;
        List<Cartitem> ttt = getEjbCartitemFacade().findAll();
           if(ttt != null){  
               System.out.println("ttt size" + ttt.size());
            for(int j =0; j< ttt.size(); j++){
                System.out.println("Product code" + ttt.get(j).getProductId());
                tt+= ttt.get(j).getQuantity();
            }
           }
           System.out.println("tt = "+ tt);
           double dd = (double)totalProductItems/tt;
        return (double) dd*100;
    }
   
    public String register(Customer customer) {
        try {
            System.out.println("Customer password: " + customer.getCPassword());
            if (customer.getCPassword().equals(getPassword())) {
                customer.setGroupname("user");
                getEjbFacade().create(customer);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CustomerCreated"));
                //return prepareCreate();
                return "/user/product/List.xhtml";
            } else {
                JsfUtil.addErrorMessage("Passwords do not match");
            }

        } catch (Exception e) {
            if (e.getMessage().equals("Transaction aborted")) {
                JsfUtil.addErrorMessage("Username not available");
            } else {
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
        return null;

    }

    

    
    
}
