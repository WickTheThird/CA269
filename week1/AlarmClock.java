import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String time = input.nextLine();
        String[] new_time = time.split(" ");
        int final_time = Integer.parseInt(new_time[0] + new_time[1]);

        String fakes = input.nextLine();
        String[] new_fakes = fakes.split(" ");
        int final_fakes = Integer.parseInt(new_fakes[0] + new_fakes[1]);

        int counter = 0;
        while (final_fakes < final_time) {
            fakes = input.nextLine();
            new_fakes = fakes.split(" ");
            final_fakes = Integer.parseInt(new_fakes[0] + new_fakes[1]);

            ++counter;
        }

        System.out.println("false alarms: " + counter);

  }
}