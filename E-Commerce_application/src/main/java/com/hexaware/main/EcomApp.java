package com.hexaware.main;


import com.hexaware.controller.IOrderProcessor;
import com.hexaware.controller.OrderProcessorImpl;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
import java.util.Scanner;

/**
 *@author shailendra sharma
 *This is the main class of the application to interact with user
 */
public class EcomApp {
	/**
	 * @param args
	 * Main method of the class
	 */
	public static void main(String[] args) {
		IOrderProcessor orderProcessorImpl = new OrderProcessorImpl();

		System.out.println("Welcome!!");
		Scanner scanner = new Scanner(System.in);
		String choice = null;

		do {
			System.out.println("1. Register Customer");
			System.out.println("2. Create Product");
			System.out.println("3. Delete Customer");
			System.out.println("4. Delete product");
			System.out.println("5. Add to cart");
			System.out.println("6. Remove from cart");
			System.out.println("7. View cart");
			System.out.println("8. Place Order");
			System.out.println("9. Get all orders for customer");
			System.out.println("\nEnter your choice");

			int menuchoice = scanner.nextInt();
			switch (menuchoice) {
			case 1: {
				orderProcessorImpl.addCustomer();
				break;
			} case 2: {
				orderProcessorImpl.addProduct();
				break;
			} case 3: {
				try {
					orderProcessorImpl.removeCustomer();
					} catch (CustomerNotFoundException e) {
						System.out.println(e.toString());
					}
				break;
			} case 4: {
				try {
					orderProcessorImpl.removeProduct();
				} catch (ProductNotFoundException e) {
					System.out.println(e.toString());
					}
				break;
				}
			 case 5: {
				 try {
					 orderProcessorImpl.addProductToCart();
					 } catch (CustomerNotFoundException e) {
							System.out.println(e.toString());
					} catch (ProductNotFoundException e) {
						System.out.println(e.toString());
					}
				break;
			} case 6: {
				try {
				orderProcessorImpl.removeProductFromCart();
				} catch (CustomerNotFoundException e) {
					System.out.println(e.toString());
				}
				break;
			} case 7: {
				orderProcessorImpl.getAllProductFromCart();
				break;
			} case 8: {
				try {
				orderProcessorImpl.addOrder();
				} catch (CustomerNotFoundException e) {
					System.out.println(e.toString());
				}
				break;
			} case 9: {
				orderProcessorImpl.getCustomerOrders();;
				break;
			} default: {
				System.out.println("wrong choice!");
				break;
			}	
			}
			System.out.println("Do you want to continue? Y | y");
			choice = scanner.next();
			} while (choice.equals("Y") || choice.equals("y"));
		System.out.println("Thanks for using our system");
		}
}
