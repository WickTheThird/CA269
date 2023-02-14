import java.util.Scanner;

public class VowelAge {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        String age = input.nextLine();

        String state = "an adult";

        if (Integer.parseInt(age) < 18) {
            state = "a minor";
        }

        char[] str = name.toCharArray();
        int counter = 0;
        for (int i = 0; i < name.length(); ++i) {
           if (Character.toLowerCase(str[i]) == 'a' || Character.toLowerCase(str[i]) == 'e' || Character.toLowerCase(str[i]) == 'i' || Character.toLowerCase(str[i]) == 'o' || Character.toLowerCase(str[i]) == 'u') {
               counter++;
           }
        }

        System.out.println("Hello " + name + ", you have " + counter + " vowels, and you are " + state);

        input.close();
  }
}