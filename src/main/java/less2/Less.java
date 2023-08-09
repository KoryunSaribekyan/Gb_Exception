package less2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Less {
    public static void main(String[] args) {
        File file = new File("name");
    }
    public static List<String[]> readFile(File file){
        List<String[]> list = new ArrayList<>();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null){
                list.add(line.split("="));
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            return list;
    }
    public static void changeList(List<String[]> lst){
        for(String[]el :lst){
            if(!checkException(el[1]) && !el[1].equals("?")){
                throw  new RuntimeException(el[1]);

            }
        }
    }
    public static boolean checkException(String line){
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
