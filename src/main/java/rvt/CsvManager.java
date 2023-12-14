package rvt;
import java.io.*;
import java.util.*;


public class CsvManager {
    static final String CSV_FILE = "data/hobbies.csv";
    private InputStream is;


    public CsvManager(String csvFile) {
        this.is = CsvManager.class.getClassLoader().getResourceAsStream(csvFile);
    }


    public ArrayList<HashMap> getAllHobbies() {
        ArrayList<HashMap> hobbies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.is))) {
            String header = reader.readLine();
            String line;

           


            while ((line = reader.readLine()) !=null) {
                String[] nextLine = line.split(", ");

                HashMap<String, String > hobby = new HashMap<>();
                hobby.put("id", nextLine[0]);
                hobby.put("title", nextLine[1]);
                hobby.put("content", nextLine[2]);
                hobbies.add(hobby);
            }
        }   catch (IOException e){
            e.printStackTrace();
        }
        return hobbies;


    }
}