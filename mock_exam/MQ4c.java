//> interfaces Div3, Div5, NumberObject

class NumberObject {}

//> interface Div3
interface Div3 {}

class NumDiv3 extends NumberObject implements Div3 {} 

//> interface Div5
interface Div5 {}

class NumDiv5 extends NumberObject implements Div5 {}

//> fizzbuzz
class NumDiv3And5 extends NumberObject implements Div3, Div5 {}

//> class game
class Game {

    public static void play(NumberObject obj) {

        if ((obj instanceof Div3) || (obj instanceof Div5)) {
            if (obj instanceof Div3) {
                System.out.print("Fizz");
            }
            if (obj instanceof Div5) {
                System.out.print("Buzz");
            }
            System.out.println();
        } else {
            System.out.println(obj);
        }
    }
}

//> test
class Test {
    public static void main(String[] args) {
        Game.play(new NumDiv3());
        Game.play(new NumDiv5());
        Game.play(new NumDiv3And5());
    }
}

