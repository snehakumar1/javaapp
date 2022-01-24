/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import struts2.test.dao.ProductService;
import org.apache.log4j.Logger;
import struts2.test.dao.Admin;
import org.apache.log4j.Level;

/**
 *
 * @author Lenovo
 */
public class AddProductAction extends ActionSupport{
private static final Logger log = Logger.getLogger(AddProductAction.class);
    private int productId;
    private String productName;
    private String productMake;
    private double price;
    private int availability;
    
    
    private String msg = "";
    ProductService product=null;
    private int ctr = 0;
    
    @Override
    public String execute()throws Exception{
        product =new ProductService();
        try{
            setCtr(product.addProduct(productName, productMake, price, availability));
            if (getCtr() > 0) {
                setMsg("Product Added Successfull");
            } else {
                setMsg("Some error");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
log.info("This is a debug log message from Struts2");
        return "ADDED";
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
}
