public class ItemToPurchase{

   private String itemName;
   private int itemPrice;
   private int itemQuantity;
   private String itemDescription;
   
   public ItemToPurchase() {
      itemName = "none";
      itemPrice = 0;
      itemQuantity = 0;
      itemDescription = "none";
   }
   
   public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
      this.itemName = itemName;
      this.itemQuantity = itemQuantity;
      this.itemPrice = itemPrice;
      this.itemDescription = itemDescription;
   }   
   
   public void setName(String itemName){
      this.itemName = itemName;
   }
   
   public void setPrice(int itemPrice){
      this.itemPrice = itemPrice;
   }
   
   public void setQuantity(int itemQuantity){
      this.itemQuantity = itemQuantity;
   }
   
   public void setDescription(String itemDescription){
      this.itemDescription = itemDescription;
   }
   
   @Override
   public String toString() {
      return this.itemName;
   }
   
   public String getName(){
      return itemName;
   }
   
   public int getPrice(){
      return itemPrice;
   }
   
   public int getQuantity(){
      return itemQuantity;
   }
   
   public String getDescription(){
      return itemDescription;
   }
   
   public int itemTotal(int price, int quantity) {
      int total = price * quantity;
      return total;
   }
   
   public void printItemCost(){
      System.out.println(this.itemName + " " + this.itemQuantity + " @ $" + this.itemPrice + " = &" + (this.itemQuantity * this.itemPrice));
   }
   
   public void printItemDescription(){
      System.out.println(this.itemName + ": " + this.itemDescription);
   }
   

}