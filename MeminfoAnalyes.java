import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeminfoAnalyes{
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("result_analyes");

        //  bos = new BufferedOutputStream(fos);
        FileReader fr = new FileReader("result_analyes");

        BufferedReader br= new BufferedReader(new InputStreamReader(fis));
        String temp="";

        ArrayList<ArrayList<List<String>>> values = new ArrayList<>();
        while ((temp=br.readLine())!=null) {
            // System.out.println(temp);
            if(temp.startsWith("java")){
                ArrayList<List<String>> arrayList = new ArrayList<>();
                for (int i = 0; i < 11; i++) {
                    String line = br.readLine();

                    String[] split =line.split(",");
                        arrayList.add(Arrays.asList(split));

                }
                values.add(arrayList);
            }
        }



        ArrayList<ArrayList<Integer>> finalResult = new ArrayList();

        for (List<String> strings : values.get(0)) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            for (String string : strings) {
                tempArrayList.add(Integer.parseInt(string));
            }
            finalResult.add(tempArrayList);
        }
        for (int i = 1; i < values.size(); i++) {       // javaMem
            for (int j = 0; j < values.get(i).size(); j++) {    // java
                for (int k = 0; k < values.get(i).get(j).size(); k++) {
                    int value1 = finalResult.get(j).get(k);
                    int value2 = Integer.parseInt(values.get(i).get(j).get(k));
                    int tempResult = (value1 + value2);
                    finalResult.get(j).set(k,tempResult);


                    System.out.print(tempResult+":"+value1+":"+value2+",");
                }
                System.out.println();
            }
            System.out.println("==============================");
        }


        for (ArrayList<Integer> arrayList : finalResult) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.set(i,arrayList.get(i)/values.size());
            }
        }


        for (ArrayList<Integer> arrayList : finalResult) {
            System.out.println(arrayList);
        }
    }
}
