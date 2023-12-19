package com.hexaware.dao;

import com.hexaware.entity.Cart;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Product;
import com.hexaware.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @author shailendra sharma.
 */
/*
 * This class implements OrderProcessorRepository interface and have methods related to database
 */
public class OrderProcessorRepositoryImpl implements OrderProcessorRepository {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	/*
	 *@param product represents the product object
	 */
	/*
	 *This method takes the product object and adds it to database
	 */
	@Override
	public boolean createProduct(Product product) {
		try {
			connection = DBConnection.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
			
			preparedStatement.setLong(1, product.getProductId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5, product.getStockQuantity());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected > 0) {
				return true;
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		}

	/*
	 *@param customer represents the customer object
	 */
	/*
	 *This method takes the customer object and adds it to the database 
	 */
	@Override
	public boolean createCustomer(Customer customer) {
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");

	        preparedStatement.setLong(1, customer.getCustomerId());
	        preparedStatement.setString(2, customer.getName());
	        preparedStatement.setString(3, customer.getEmail());
	        preparedStatement.setString(4, customer.getPassword());

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}

	/*
	 *@param productId represents the id of the product
	 */
	/*
	 *This method deletes the product from the database 
	 */
	@Override
	public boolean deleteProduct(long productId) {
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("DELETE FROM product WHERE productId = ?");

	        preparedStatement.setLong(1, productId);

	        int rowsAffected = preparedStatement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            return true;
	        }
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
		return false;
	}

	/*
	 *@param customerId represent the customer id 
	 */
	/*
	 *This method removes the customer from database
	 */
	@Override
	public boolean deleteCustomer(long customerId) {
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customerId = ?");

	        preparedStatement.setLong(1, customerId);

	        int rowsAffected = preparedStatement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            return true;
	        }
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
		return false;
	}
	
	/*
	 * @param customerid
	 */
	/*
	 *The method check if the customer exists in the .
	 */
	public boolean isCustomerExists(long customerId) {
	    try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("SELECT 1 FROM customer WHERE customerId = ?");
	        preparedStatement.setLong(1, customerId);
	        resultSet = preparedStatement.executeQuery();
	        return resultSet.next(); // If any row is returned, the customer exists
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        return false;
	    }
	}
	
	
	/**
	 * @param productid
	 */
	/*
	 *This method check if the product exists in the system.
	 */
	public boolean isProductExists(long productId) {
	    try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("SELECT 1 FROM product WHERE productId = ?");
	        preparedStatement.setLong(1, productId);
	        resultSet = preparedStatement.executeQuery();
	        return resultSet.next(); // If any row is returned, the product exists
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        return false;
	    }
	}
	

	
	/*
	 * @param customerid, productid, quantity
	 */
	/*
	 *This method is used to add product to cart
	 */
	@Override
	public boolean addToCart(long customerId, long productId, int quantity) {
		try {
	        connection = DBConnection.getConnection();
	        
	        preparedStatement = connection.prepareStatement(
                    "SELECT quantity FROM cart WHERE customerId = ? AND productId = ?");
            
	        preparedStatement.setLong(1, customerId);
            preparedStatement.setLong(2, productId);
	        
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
            	int existingQuantity = resultSet.getInt("quantity");
                int newQuantity = existingQuantity + quantity;
                
                preparedStatement = connection.prepareStatement(
                        "UPDATE cart SET quantity = ? WHERE customerId = ? AND productId = ?");
                preparedStatement.setInt(1, newQuantity);
                preparedStatement.setLong(2, customerId);
                preparedStatement.setLong(3, productId);
                
            } else {
           
	        preparedStatement = connection.prepareStatement("INSERT INTO cart (customerId, productId, quantity) VALUES (?, ?, ?)");

	        preparedStatement.setLong(1, customerId);
	        preparedStatement.setLong(2, productId);
	        preparedStatement.setInt(3, quantity);
            }
	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        }
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
		return false;
	}

	/*
	 * @param customerid, productid
	 /*
	 *This method is used to remove product from cart
	 */
	@Override
	public boolean removeFromCart(long customerId, long productId) {
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement("DELETE FROM cart WHERE customerId = ? AND productId = ?");

	        preparedStatement.setLong(1, customerId);
	        preparedStatement.setLong(2, productId);

	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            return true;
	        }
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
		return false;
	}

	/**
	 *This method is used to get all product from cart
	 */
	@Override
	public List getAllFromCart(long customerId) {
		List productsInCart = new ArrayList<>();
		Cart cart;
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement(
	        		"SELECT p.productId, p.name, SUM(c.quantity) as totalQuantity " 
	        	     + "FROM product p " 
	        	     + "JOIN cart c ON p.productId = c.productId " 
	        	     + "WHERE c.customerId = ? " 
	        	     + "GROUP BY p.productId, p.name");

	        preparedStatement.setLong(1, customerId);
	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
                long productId = resultSet.getLong("productId");
                String name = resultSet.getString("name");
                int totalQuantity = resultSet.getInt("totalQuantity");

                List<Object> result = new ArrayList<>();
                result.add(productId);
                result.add(name);
                result.add(totalQuantity);
                
                productsInCart.add(result);
            }
		} catch (SQLException e) {
    		e.printStackTrace();
    	}
		return productsInCart;
	}

	/**
	 *This method is used to place order 
	 */
	@Override
	public boolean placeOrder(long customerId, Map<Long, Integer> productsMap, String shippingAddress) {
		try {
	        connection = DBConnection.getConnection();
	        int totalPrice = calculateTotalPrice(productsMap);
	        preparedStatement = connection.prepareStatement(
	                "INSERT INTO orders (customerId, orderDate, totalPrice, shippingAddress) VALUES (?,CURRENT_TIMESTAMP,?,?)",
	                Statement.RETURN_GENERATED_KEYS
	        );
	        preparedStatement.setLong(1, customerId);
	        preparedStatement.setInt(2, totalPrice);
	        preparedStatement.setString(3, shippingAddress);

	        int rowsAffectedOrder = preparedStatement.executeUpdate();

	        if (rowsAffectedOrder > 0) {
	            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                long orderId = generatedKeys.getLong(1);
	                PreparedStatement orderItemsStatement = connection.prepareStatement(
	                        "INSERT INTO orderItems (orderId, productId, quantity) VALUES (?, ?, ?)");

	                for (Map.Entry<Long, Integer> entry : productsMap.entrySet()) {
	                    long productId = entry.getKey();
	                    int quantity = entry.getValue();

	                    orderItemsStatement.setLong(1, orderId);
	                    orderItemsStatement.setLong(2, productId);
	                    orderItemsStatement.setInt(3, quantity);

	                    orderItemsStatement.addBatch();
	                }

	                int[] rowsAffectedOrderItems = orderItemsStatement.executeBatch();
	                if (rowsAffectedOrderItems.length == productsMap.size()) {
	                    return true;
	                }
	            }
	        }
	    } catch (SQLException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	
	/**
	 *This method is used to calculate the total price
	 */
	@Override
	public int calculateTotalPrice(Map<Long, Integer> productsMap) {
		int totalPrice = 0;
		try {
	        connection = DBConnection.getConnection();
	        for (Map.Entry<Long, Integer> entry : productsMap.entrySet()) {
	        	long productId = entry.getKey();
	        	int quantity = entry.getValue();
	        	
	        	preparedStatement = connection.prepareStatement("SELECT price FROM product WHERE productId = ?");
	        	preparedStatement.setLong(1, productId);
	        	
	        	resultSet = preparedStatement.executeQuery();
	        	
	        	if (resultSet.next()) {
                    int productPrice = resultSet.getInt("price");
                    int subtotal = productPrice * quantity;
                    totalPrice += subtotal;
                }
	     	}
		} catch (SQLException e) {
            e.printStackTrace(); 
		}
		return totalPrice;
	}
	

	/**
	 *The method is used to view the orders placed by a particular customer
	 */
	@Override
	public List getOrdersByCustomer(long customerId) {
        List<List<Object>> ordersList = new ArrayList<>();
		try {
	        connection = DBConnection.getConnection();
	        preparedStatement = connection.prepareStatement(
                    "SELECT o.orderId, oi.productId, p.name AS productName, oi.quantity " 
                    		+ "FROM orders o " 
                    		+ "JOIN orderItems oi ON o.orderId = oi.orderId " 
                    		+ "JOIN product p ON oi.productId = p.productId " 
                    		+ "WHERE o.customerId = ?");
	        
            preparedStatement.setLong(1, customerId);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                long orderId = resultSet.getLong("orderId");
                long productId = resultSet.getLong("productId");
                String productName = resultSet.getString("productName");
                int quantity = resultSet.getInt("quantity");
                
                List<Object> orderDetails = new ArrayList<>();
                
                orderDetails.add(orderId);
                orderDetails.add(productId);
                orderDetails.add(productName);
                orderDetails.add(quantity);
                
                ordersList.add(orderDetails);
            }
		} catch (SQLException e) {
    		e.printStackTrace();
    	}
	return ordersList;
	}
}
	
