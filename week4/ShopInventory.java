
import java.text.DecimalFormat;

abstract class Item {
    final String name;
    int expiresInDays;
    double price;

    Item(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getExpiresInDays() {
        return this.expiresInDays;
    }

    public void setExpiresInDays(int expiresInDays) {
        this.expiresInDays = expiresInDays;
    }

    public String getName() {
        return this.name;
    }

}

interface StorageCondition {
    String storageProcedure();
}

interface Refrigerate extends StorageCondition{

    boolean refrigerate(double currentTemp);

}

interface SecureItem extends StorageCondition {
    void attachSecurityTag();

    boolean removeSecurityTag();
}

interface ReducedPrice {
    double reduction(double totalAmount);
}

interface OnSale extends ReducedPrice {

    boolean saleCondition(Item[] items);
}

class Milk extends Item implements Refrigerate {
    int maxRefrigerateTemp;
    int expiryDays;

    private Milk(String name) {
        super(name);
    }

    Milk(String name,int expiryDays,double price, int maxRefrigerateTemp) {
        super(name);
        this.expiryDays = expiryDays;
        this.price = price;
        this.maxRefrigerateTemp = maxRefrigerateTemp;
    }

    public boolean refrigerate(double currentTemp) {
        if (currentTemp > this.maxRefrigerateTemp) {
            return true;
        } else {
            return false;
        }
    }

    public String storageProcedure() {
        return "refrigeration needed";
    }
}

class Bread  extends Item implements StorageCondition{

    int expiryDays;

    private Bread(String name) {
        super(name);
    }

    Bread(String name, int expiryDays, double price) {
        super(name);
        this.expiryDays = expiryDays;
        this.price = price;
    }


    public String storageProcedure() {
        return "Airtight Storage";
    }
}

class Perfume extends Item implements SecureItem {
    private boolean locked;  
    int expiryDays;

    private Perfume(String name) {
        super(name);
    }

    Perfume(String name, int expiryDays,double price) {
        super(name);
        this.expiryDays = expiryDays;
        this.price = price;
        this.locked = true;
    }
        
    public void attachSecurityTag() {
        this.locked = true;
    }
    
    public boolean removeSecurityTag() {
        if (this.locked == true) {
            this.locked = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean getLocked() {
        if (this.locked == true) {
            return true;
        } else {
            return false;
        }
    }

    public String storageProcedure() {
        return "Away from Sunlight";
    }
}

class PlasticCup extends Item {
    int expiryDays;

    private PlasticCup(String name) {
        super(name);
    }

    PlasticCup(String name, int expiryDays, double price) {
        super(name);
        this.expiryDays = expiryDays;
        this.price = price;
    }
}

class EasterSale implements OnSale {

    final String message; // sale message
    final double minimumAmount; // minimum amount for the sale to qualify
    final double salePercent;  // sale percentage

    EasterSale(double salePercent, double minimumAmount) {
        this.salePercent = salePercent / 100;
        this.minimumAmount = minimumAmount;
        DecimalFormat format = new DecimalFormat("0.#");
        this.message = "Spend over " + format.format(minimumAmount) + ", Get " 
            + (this.salePercent*100) + "% off for Easter!";
    }

    public double reduction(double totalAmount) {
        return totalAmount - (totalAmount * salePercent);
    }

    public boolean saleCondition(Item[] items) {
        
        int sum = 0;

        for (int i = 0; i < items.length; i++) {
            sum += items[i].getPrice();
        }

        if (sum > minimumAmount) {
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return this.message;
    }
}

public class ShopInventory {

    public static double billItems(Item[] items, OnSale Sale) {

        double total = 0;
        double actualTotal = 0;

        for (int i = 0; i < items.length; i++) {
            total += items[i].getPrice();
            actualTotal += items[i].getPrice();
            if (items[i] instanceof StorageCondition) {
                System.out.println(items[i].getName() + " (" + items[i].getPrice() + ") (Storage: " + ((StorageCondition) items[i]).storageProcedure() + ")");
            } else {
                System.out.println(items[i].getName() + " (" + items[i].getPrice() + ")");
            }
        }

        if ( Sale != null &&  Sale.saleCondition(items)) {
            System.out.println("Actual Total: " + actualTotal);
            System.out.println(Sale.toString());
            total = Sale.reduction(total);
        }

        return total;
        
    }

    /**
     * getCurrentTemperature returns the current temperature
     * Returns 24 to ensure StorageConditions on cooling are triggered
     */ 
    private static int getCurrentTemperature() {
        return 24;
    }

    /**
     * main() for testing the code
     * #Update Feb-11# 
     * If your code is correct, it should produce the below outputs
     * i.e. for Customer 1 and Customer 2 as shown in comments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##"); // double with 2 decimal precision

        // Case1: No Sale
        System.out.println("--- Customer 1 ---");
        Item[] items_no_sale = {
            new Milk("Avenmore Fresh", 5, 1.90, 12),
            new Bread("Bretzel Tortano", 7, 4.50),
            new Perfume("Lynx Vanilla", 500, 7),
            new PlasticCup("Tea Mug", 1200, 12),
        };
        double total_no_sale = billItems(items_no_sale, null);
        System.out.println("Total Amount: " + df.format(total_no_sale));

        // --- Customer 1 ---
        // Avenmore Fresh (1.9) (Storage: refrigeration needed)
        // Bretzel Tortano (4.5) (Storage: Airtight Storage)
        // Lynx Vanilla (7.0) (Storage: Away from Sunlight)
        // Tea Mug (12.0)
        // Total Amount: 25.4

        // Case2: Easter Sale
        System.out.println("--- Customer 2 ---");
        Item[] items_easter_sale = {
            new Milk("Mulled Wine", 60, 22.20, 8),
            new Bread("Fruit Cakes", 20, 13.50),
            new Perfume("Pot-pourri", 500, 15),
            new PlasticCup("Party Cups (set of 12)", 1200, 2),
        };
        double total_easter_sale = billItems(items_easter_sale, new EasterSale(7.5, 50));
        System.out.println("Total Amount: " + df.format(total_easter_sale));

        // --- Customer 2 ---
        // Mulled Wine (22.2) (Storage: refrigeration needed)
        // Fruit Cakes (13.5) (Storage: Airtight Storage)
        // Pot-pourri (15.0) (Storage: Away from Sunlight)
        // Party Cups (set of 12) (2.0)
        // Actual Total: 52.7
        // Spend over 50, Get 7.5% off for Easter!
        // Total Amount: 48.75
    }
}