/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package struts2.test.actions;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.User;
import struts2.test.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;
import struts2.test.beans.Product;
import struts2.test.dao.ProductService;

/**
 *
 * @author lenovo
 */
public class ProductAction extends ActionSupport {
       private String msg = "";
       private int ctr = 0;
      private int productId;
    private String productName;
    private String productMake;
    private double price;
    private int availability;
private String submitType;

    private static long serialVersionUID = 6329394260276112660L;
    private ResultSet rs = null;
    private Product product = null;
    private List<Product> productList = null;
    private ProductService admin = new ProductService();
    private boolean noData = false;

    
    public String getAllProduct() throws Exception {
        try {
            setProductList(new ArrayList<>());
            setProductList(admin.productList());
            

            if (!productList.isEmpty() ) {
                setNoData(false);
                System.out.println("Users retrieve = "+getProductList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PRODUCTLIST";
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }


public String addPoduct(){
        ProductService product = new ProductService();
        try{
            setCtr(product.addProduct(getProductName(), getProductMake(), getPrice(), getAvailability()));
            if (getCtr() > 0) {
                setMsg("Product Added Successfull");
            } else {
                setMsg("Some error");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ADDED";
    }

    /**
     * @return the msg
     */
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

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the admin
     */
    public ProductService getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(ProductService admin) {
        this.admin = admin;
    }
 public String updateProduct(){
        ProductService product=new ProductService();
        try {
            if (getSubmitType().equals("updatedata")) {
                Product pro =product.fetchProductDetails(productId);
                if (pro != null) {
                    productId = pro.getProductId();
                    productName = pro.getProductName();
                    productMake = pro.getProductMake();
                    price = pro.getPrice();
                    availability =pro.getAvailability();
                }
            } 
                else {
                System.out.println("in else part Product Name: "+productName);
                int i = product.updateProductDetails(productId, productName, productMake, price, availability);
                if (i > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "UPDATE";
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
}


