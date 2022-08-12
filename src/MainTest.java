import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        String inputFileName = "D:\\lng.csv";
        List<HashSet<String>> list = new ArrayList<>();
        List<ArrayList<String>> resList = new ArrayList<>();
        boolean check = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            int l = 0;
            while ((line = reader.readLine()) != null && l < 20000) {
                for (int i = 0; i < list.size();i++){
                    for(int k = 0; k < line.split(";").length; k++){
                        if(list.get(i).contains(line.split(";")[k]) && !line.split(";")[k].equals("\"\""))
                        {
                            resList.get(i).addAll(Arrays.asList(line.split(";")));
                            resList.get(i).add("\n");
                            check = true;
                        }
                    }
                }
                if(!check)
                {
                    resList.add(new ArrayList<>(Arrays.asList(line.split(";"))));
                    resList.get(resList.size()-1).add("\n");
                    list.add(new HashSet<>(Arrays.asList(line.split(";"))));
                }
                check = false;
                l++;
            }
            for(int i = 0; i<resList.size();i++){
                System.out.println("Группа: " + (i+1));
                for (int k = 0; k < resList.get(i).size()-2;k++){
                    System.out.print(resList.get(i).get(k) + ";");
                }
                System.out.print(resList.get(i).get(resList.get(i).size()-2));
                System.out.println("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}