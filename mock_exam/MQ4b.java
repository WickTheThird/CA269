
class NoCakeFoundException extends Exception {

    //> constructors
    public NoCakeFoundException() {
        super();
    }

    public NoCakeFoundException(String message) {
        super(message);
    }

    //> toString
    public String toString() {
        return "The Cake is a Lie!";
    }

}

class Cake {

    //> main
    public static void main(String[] args) {
        Cake cake = new Cake();
        cake.eatCake();
    }

    public String getCake() throws NoCakeFoundException{
        throw new NoCakeFoundException();
    }

    public void eatCake() {
        try {
            this.getCake();
        } catch (NoCakeFoundException e) {
            System.out.println(e);
        }
    }

}
