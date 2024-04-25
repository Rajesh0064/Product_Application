package com.sathya;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;


public class ProductDao {

	public int saveProduct(Product product) {
        int result =0;
        try (Connection connection =dbconnection.createConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement("insert into  product_data values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1,product.getProId());
			preparedStatement.setString(2,product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4,product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			
			preparedStatement.setDate(6,product.getProMfgDate());
			preparedStatement.setDate(7,product.getProExpDate());
			
			preparedStatement.setBinaryStream(8,product.getProImage());
			
			result =preparedStatement.executeUpdate();
			
		} catch (Exception e) {
             e.printStackTrace();
		}
		return result;
	}


public List<Product> displayListOfProducts() {
        List<Product> productList = new ArrayList<Product>();
        try(Connection connection = dbconnection.createConnection()){
        	Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery("select * from product_data");
           
            while (resultSet.next()) {
	         	  Product product = new Product();
	         	  product.setProId(resultSet.getString("proId"));
				  product.setProName(resultSet.getString("proName"));
				  product.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  product.setProImage(resultSet.getBinaryStream("proImage"));
				  product.setReadImage(resultSet.getBytes("proImage"));
				  productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }



public int deleteById(String proId) {
		int result=0;
		try (Connection connection=dbconnection.createConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement("delete from product_data where proId=?");
			preparedStatement.setString(1, proId);
			result=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
}


public Product findById(String proId) {
       Product product=null;	

	 try(Connection connection = dbconnection.createConnection()){
		 PreparedStatement preparedStatement = connection.prepareStatement("select * from product_data where proId=?");
			preparedStatement.setString(1, proId);
			ResultSet resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
	         	   product = new Product();
	         	  product.setProId(resultSet.getString("proId"));
				  product.setProName(resultSet.getString("proName"));
				  product.setProPrice(Double.parseDouble(resultSet.getString("proPrice")));
				  product.setProBrand(resultSet.getString("proBrand"));
				  product.setProMadeIn(resultSet.getString("proMadeIn"));
				  product.setProMfgDate(resultSet.getDate("proMfgdate"));
				  product.setProExpDate(resultSet.getDate("proExpDate"));
				  product.setProImage(resultSet.getBinaryStream("proImage"));
				  product.setReadImage(resultSet.getBytes("proImage"));
         }	
	 }catch (SQLException e) {
			e.printStackTrace();
		}

	return product;
	 }

public int updateProduct(Product updatedProduct) {
    int result = 0;
try(Connection connection = dbconnection.createConnection())
{
	int parameterIndex = 1;
     // SQL query to update product details
	 String sql = "UPDATE product_data SET proName=?, proPrice=?, proBrand=?, proMadeIn=?, " +
             "proMfgDate=?, proExpDate=?" +
             (updatedProduct.getProImage() != null ? ", proImage=?" : "") +
             " WHERE proId=?";
    
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // Set the parameters for the update statement
    preparedStatement.setString(parameterIndex++, updatedProduct.getProName());
    preparedStatement.setDouble(parameterIndex++, updatedProduct.getProPrice());
    preparedStatement.setString(parameterIndex++, updatedProduct.getProBrand());
    preparedStatement.setString(parameterIndex++, updatedProduct.getProMadeIn());
    preparedStatement.setDate(parameterIndex++, updatedProduct.getProMfgDate());
    preparedStatement.setDate(parameterIndex++, updatedProduct.getProExpDate());
    
    if ( updatedProduct.getProImage() != null) {
        preparedStatement.setBinaryStream(parameterIndex++, updatedProduct.getProImage());
    }
    
    preparedStatement.setString(parameterIndex++, updatedProduct.getProId());

        // Execute the update
        result = preparedStatement.executeUpdate();
    }
 catch (SQLException e) {
    e.printStackTrace();
     }
return result;
    }


}


