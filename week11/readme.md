
# CVS Reader

For the CVS reader, we can do the following:

<code> 
public static String[] readCVS(String filename) {

    String[] lines = new String[1];

    try {
        Scanner input = new Scanner(new File(filename));
        input.useDelimiter(",");

        int i = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            lines[i] = line;
            ++i;
            lines = Arrays.copyOf(lines, (i + 1));
        }

        input.close();
    } catch (FileNotFoundException ex) {
        System.out.println("File not found.");
    }

    return lines;

}
</code>

In there we are returning a string array containing all the collumns of the CVS file, given that you pass the name of the CVS file.

## Other tests that can be added

<code>
String[] planets = readCVS("planets.csv");
String[] species = readCVS("species.csv");
String[] starships = readCVS("starships.csv");
String[] vehicles = readCVS("vehicles.csv");
String[] films = readCVS("films.csv");
</code>
