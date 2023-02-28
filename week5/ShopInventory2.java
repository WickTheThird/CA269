import java.util.*;

class ShopInventory2 {
    public static void main(String[] args) {
            Basket basket = new Basket();
            loadBasket(basket);
            Checkout checkout = new Checkout(basket);
            Bill bill = new Bill(checkout);
            System.out.println(bill);
        }

        static void loadBasket(Basket basket) {
            basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
            basket.addItem(new Item("Folans Orange Marmalade", 4.00));
            basket.addItem(new Item("Free-range Eggs", 3.35));
            basket.addItem(new Item("Brennan's Bread", 2.15));
            basket.addItem(new Item("Ferrero Rocher", 7.00));
            basket.addItem(new Item("Ferrero Rocher", 7.00));
        }
}

class Item {
    private final String name;
    private final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}

class Basket {
    private final Stack<Item> basket;

    Basket() {
        this.basket = new Stack<>();
    }

    public void addItem(Item item) {
        this.basket.push(item);
    }

    public Item removeItem() {
        return this.basket.pop();
    }

    public boolean isEmpty() {
        return this.basket.isEmpty();
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }
}

class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        this.checkout = new LinkedList<>();
        while (!basket.isEmpty()) {
            addItem(basket.removeItem());
        }
    }

    public void addItem(Item item) {
        this.checkout.offer(item);
    }

    public Item removeItem() {
        return this.checkout.poll();
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }

    public Collection<Item> getCheckout() {
        return this.checkout;
    }
}

class Bill {
    private final Map<String,Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        this.basket = new LinkedHashMap<>();
        this.price = 0.0;
        for (Item item : checkout.getCheckout()) {
            billItem(item);
        }
    }

    public void billItem(Item item) {
        String name = item.getName();
        int count = this.basket.getOrDefault(name, 0);
        this.basket.put(name, count + 1);
        this.price += item.getPrice();
    }

    public double getTotal() {
        return this.price;
    }

    public String toString() {
        String output = "";
        for(String item: this.basket.keySet()) {
            output += item + " (" + this.basket.get(item) + "nos)\n";
        }
        return output + "total: " + this.price;
    }
}
