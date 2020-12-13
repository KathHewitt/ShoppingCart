import java.util.ArrayList;

public class ShoppingCart{

   private String customerName;
   private String currentDate;
   ArrayList <ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
   
   public ShoppingCart() {
      customerName = "none";
      currentDate = "January 1, 2016";
   }
   
   public ShoppingCart(String customerName, String currentDate){
      this.customerName = customerName;
      this.currentDate = currentDate;
   }
   
   public String getCustomerName(){
      return customerName;
   }
   
   public String getDate(){
      return currentDate;
   }
   
   public void addItem(ItemToPurchase newItem){
      cartItems.add(newItem);
   }
   
   public void removeItem(String itemToRemove){
      
      ItemToPurchase currentItem;
      Boolean itemFound = false;
      int i = 0;
      
      while ((i < cartItems.size()) && (!itemFound)) {
         currentItem = cartItems.get(i);
         
         if (itemToRemove.equalsIgnoreCase(currentItem.getName())) {
            cartItems.remove(currentItem);
            itemFound = true;
         }
         
         i++;
      }
      
      if (!itemFound)
         System.out.println("Item not found in cart. Nothing removed.");
      
   }
   
   public void modifyItem(String itemToModify, int newQuantity){
      
      ItemToPurchase currentItem;
      boolean itemFound = false;
      int i = 0;
      
      while ((i < cartItems.size()) && (!itemFound)) {
         currentItem = cartItems.get(i);
         
         if (currentItem.getName().equals(itemToModify)) {
            itemFound = true;
            currentItem.setQuantity(newQuantity);
         }
         
         i++;
         
      }
      
      if (!itemFound) 
         System.out.println("Item not found in cart. Nothing modified.");
   }
   
   public int getNumItemsInCart(){
      
      ItemToPurchase currentItem;
      int quantity = 0;
      
      for (int i = 0; i < cartItems.size(); i++) {
         currentItem = cartItems.get(i);
         quantity = quantity + currentItem.getQuantity();
      }
      
      return quantity;
   }
   
   public int getCostOfCart(){
      
      int total = 0;
      ItemToPurchase currentItem;
      
      for (int i = 0; i < cartItems.size(); i++) {
         currentItem = cartItems.get(i);
         total = total + currentItem.itemTotal(currentItem.getPrice(), currentItem.getQuantity());
      }
   
      return total;
   }
   
   public void printTotal(){
      if (cartItems.size() == 0) {
         System.out.println("SHOPPING CART IS EMPTY");
         System.out.println("");
         System.out.println("Total: $0");
      }
      
      else {

         ItemToPurchase currentItem;   
         int itemTotal = 0;
         int total = 0;
         
         for (int i = 0; i < cartItems.size(); i++) {
            currentItem = cartItems.get(i);
            itemTotal = (currentItem.getQuantity() * currentItem.getPrice());
            System.out.println(currentItem.getName() + " " + currentItem.getQuantity() + " @ $" + currentItem.getPrice() + " = $" + itemTotal);
            total = total + itemTotal;
         }
         
         System.out.println("");
         System.out.print("Total: $" + total);
         System.out.println("");
         
      }
   }
   
   public void printDescriptions(){
      
      System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
      System.out.println(this.customerName + "'s Shopping Cart - " + this.currentDate);
      System.out.println("");
      System.out.println("Item Descriptions");
      
      ItemToPurchase currentItem;   
      int itemTotal = 0;
      int total = 0;
         
      for (int i = 0; i < cartItems.size(); i++) {
         currentItem = cartItems.get(i);
         System.out.println(currentItem.getName() + ": " + currentItem.getDescription());
         }
      
      System.out.println("");
   }
   
   public void outputShoppingCart() {
      
      System.out.println("OUTPUT SHOPPING CART");
      System.out.println(this.customerName + "'s Shopping Cart - " + this.currentDate);
      System.out.println("Number of Items: " + this.getNumItemsInCart());
      System.out.println("");
      this.printTotal();
      System.out.println("");

   }

}