import java.util.Scanner;

public class ShoppingCartManager{
   
   private static String choice = "";
   
   public static void main (String [] args){
      
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("Enter Customer's Name:");
      String CustomerName = scnr.nextLine();
      System.out.println("Enter Today's Date:");
      String CurrentDate = scnr.nextLine();
      System.out.println("");
      
      ShoppingCart cart = new ShoppingCart(CustomerName, CurrentDate);
      
      System.out.println("Customer Name: " + cart.getCustomerName());
      System.out.println("Today's Date: " + cart.getDate());
      System.out.println("");
      
      while (!choice.equals("q")) {
      printMenu(cart, scnr);        
      } 
      
   }
   
   public static void printMenu(ShoppingCart cart, Scanner scnr){
      
      System.out.println("MENU");
      System.out.println("a - Add item to cart");
      System.out.println("d - Remove item from cart");
      System.out.println("c - Change item quantity");
      System.out.println("i - Output items' descriptions");
      System.out.println("o - Output shopping cart");
      System.out.println("q - Quit");
      System.out.println("");

      do {
         System.out.println("Choose an option:");
         choice = scnr.nextLine();
         
         if (!choice.equals("q")) {
            switch(choice){
         
               case "a":
                  System.out.println("ADD ITEM TO CART");
                  System.out.println("Enter the item name:");
                  String itemName = scnr.nextLine();
            
                  System.out.println("Enter the item description:");
                  String itemDescription = scnr.nextLine();
            
                  System.out.println("Enter the item price:");
                  int itemPrice = scnr.nextInt();
            
                  System.out.println("Enter the item quantity:");
                  int itemQuantity = scnr.nextInt();
                  System.out.println("");
            
                  ItemToPurchase newItem = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
                  cart.addItem(newItem);
            
                  break;
            
               case "d":
            
                  System.out.println("REMOVE ITEM FROM CART");
                  System.out.println("Enter name of item to remove:");
                  String itemToRemove = scnr.nextLine();
        
                  cart.removeItem(itemToRemove);
                  System.out.println("");
                  break;
            
               case "c":
               
                  System.out.println("CHANGE ITEM QUANTITY");
                  System.out.println("Enter the item name:");
                  String itemToModify = scnr.nextLine();
               
                  System.out.println("Enter the new quantity:");
                  int newQuantity = scnr.nextInt();
               
                  cart.modifyItem(itemToModify, newQuantity);
                  System.out.println("");
               
                  break;
        
               case "i":
               
                  cart.printDescriptions();
                  break;
            
               case "o":
            
                  cart.outputShoppingCart();
                  break;
            }
         }

      } while ((!choice.equals("a")) && (!choice.equals("d")) && (!choice.equals("c")) && (!choice.equals("i")) && (!choice.equals("o")) && (!choice.equals("q")));
   }
}
