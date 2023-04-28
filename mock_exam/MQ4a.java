
class Factory<T> {

    T item;

    public T getItem() { return this.item; }
    public void setItem(T item) { this.item = item; }

}


class Apple { }
class AppleFactory extends Factory<Apple>{
    Apple item;
    public Apple getItem() { return this.item; }
    public void setItem(Apple item) { this.item = item; }
}

class Orange { }
class OrangeFactory extends Factory<Orange>{
    Orange item;
    public Orange getItem() { return new Orange(); }
    public void setItem(Orange item) { this.item = item; }
}

class Lemon {}
class LemonFactory extends Factory<Lemon> {
    Lemon item;
    public Lemon getItem() { return new Lemon(); }
    public void setItem(Lemon item) { 
        if (this.item == null) {
            this.item = item;
        }   
    }

    public void removeItem(Lemon item) {
        if (this.item != null) {
            this.item = null;
        }
    }

}

