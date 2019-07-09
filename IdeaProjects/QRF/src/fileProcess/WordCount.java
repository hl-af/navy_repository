package fileProcess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args){
        Map<String, Integer> maplist = new HashMap<>();
        try {
            String line;
            String output_path = "./output.txt";
            FileReader file = new FileReader("resources/test.txt");
            BufferedWriter wr = new BufferedWriter(new FileWriter(output_path));
            BufferedReader br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                //String test = "huanglei,zongcan,kaoshi,huanglei";
                String[] param = line.split("、|。|：");

                for (int i = 0; i < param.length; i++) {
                    if (maplist.get(param[i])==null) {
                        maplist.put(param[i], 1);
                    }
                    else {
                        maplist.put(param[i], maplist.get(param[i]) + 1);
                    }
                }

            }
            for (Map.Entry entry : maplist.entrySet()) {
                System.out.println(entry.getKey() + "," + entry.getValue());
                wr.write(entry.getKey() + "," + entry.getValue()+"\n");
            }
            br.close();
            wr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
