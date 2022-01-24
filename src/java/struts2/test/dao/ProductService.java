/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package struts2.test.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.beans.User;
import struts2.test.core.ConnectionManager;

/**
 *
 * @author lenovo
 */
public class ProductService {
public int addProduct(String productName, String productMake, double price, int availability) throws SQLException {
        int i = 0;
        Connection con = null;
        con = ConnectionManager.getConnection();
        String sql = "INSERT INTO struts2.product\n"
                + "(productName,\n"
                + "productMake,\n"
                + "price,\n"
                + "availability)\n"
                + "VALUES\n"
                + "(?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, productName);
        ps.setString(2, productMake);
        ps.setDouble(3, price);
        ps.setInt(4, availability);
        i = ps.executeUpdate();
        return i;
    }

 

public List productList() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT productId, productName, productMake, price,availability FROM product;";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));
                

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Product fetchProductDetails(int productId) throws SQLException {
        Product product = new Product();
        ResultSet rs = null;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT product.productId,\n"
                    + "    product.productName,\n"
                    + "    product.productMake,\n"
                    + "    product.price,\n"
                    + "    product.availability\n"
                    + "FROM struts2.product where productId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("productId = " + productId);
            ps.setInt(1, productId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));

            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateProductDetails(int productId, String productName, String productMake, 
            double price, int availability) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE struts2.product\n"
                    + "SET\n"
                    + "productName = ?,\n"
                    + "productMake = ?,\n"
                    + "price = ?,\n"
                    + "availability = ?\n"
                    + "WHERE productId = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, productName);
            ps.setString(2, productMake);
            ps.setDouble(3, price);
            ps.setInt(4, availability);
            ps.setInt(5, productId);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


}

    


