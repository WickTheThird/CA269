import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;
import com.google.gson.Gson;

class JarJarBinks {

 public static void main(String[] args) {
        StarWarsCharacter.readCVS("characters.csv");
        StarWarsCharacter.toJSON();
    }

}

/**
* This is the main class that reads the CVS files.
* NOTE: the file that we redirecting output to is called: 'characters.json'.
*/

class StarWarsCharacter {
    static List<StarWarsCharacter> charactersList = new ArrayList<StarWarsCharacter>();
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    /**
    * Intialize the class.
    * This sets the vvalues of the strings.
    */
    public StarWarsCharacter() {}

    /** 
    * This is the Main
    * @param args comamnd line arguments.
    */

    //title: constructors

    /**
    * Takes the CVS file, and parses it into the above categories, declared as class variables.
    * @param filename The name of the file to be read.
    */
    public static void readCVS(String filename) {

        try {
            Reader in = new FileReader(filename);
            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();

            Iterable<CSVRecord> records = CSVparser.parse(in);
            for (CSVRecord record : records) {
                StarWarsCharacter character = new StarWarsCharacter();


                System.out.println(((record.get("name")) == null) ? "N/A" : record.get("name"));

                character.name = ((record.get("name")) == null) ? "N/A" : record.get("name");
                character.height = (record.get("height") == null) ? "N/A" : record.get("height");
                character.mass = (record.get("mass") == null) ? "N/A" : record.get("mass");
                character.hairColor = (record.get("hair_color") == null) ? "N/A" : record.get("hair_color");
                character.eyeColor = (record.get("eye_color") == null) ? "N/A" : record.get("eye_color");
                character.skinColor = (record.get("skin_color") == null) ? "N/A" : record.get("skin_color");
                character.birthYear = (record.get("birth_year") == null) ? "N/A" : record.get("birth_year");
                character.gender = (record.get("gender") == null) ? "N/A" : record.get("gender");
                character.homeworld = (record.get("homeworld") == null) ? "N/A" : record.get("homeworld");
                character.species = (record.get("species") == null) ? "N/A" : record.get("species");

                charactersList.add(character);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("No such file!");
        } catch (IOException ex) {
            System.out.println("IO Exception!");
        }

    }

    public static void toJSON() {
        try {
            Writer out = new FileWriter("characters.json");
            Gson gson = new Gson();
            gson.toJson(charactersList, out);
            out.close();
        } catch (IOException ex) {
            System.out.println("IO Exception!");
        } 

    }


    //title: getters and setters go here
    /**
    * toString to print character info.
    * @return Returns the output of of the class.
    */
    public String toString() {
        String output = "";

        return output;
    }

}
