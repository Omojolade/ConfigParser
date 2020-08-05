import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ConfigParser {
    private String fileName ;
    private Map<String, String> mapStoredValue = new HashMap<>();



    public ConfigParser (String fileName) {
        this.fileName = fileName;
        try{
            readConfigData();
        }catch(FileNotFoundException e){
            e.getMessage();
        }


    }
    public String getFileName() {
        return fileName;
    }


    public void readConfigData() throws FileNotFoundException{
        Reader reader = new FileReader(fileName);
       try(BufferedReader bufferedReader = new BufferedReader(reader)
       ){
           String line = bufferedReader.readLine();

           String startValue = "";
           while(line != null) {

                //do something with line
               String[] splitLineValue = line.split("=");
               if (splitLineValue.length > 1) {
                   if (!mapStoredValue.containsKey(startValue + splitLineValue[0])) {
                       mapStoredValue.put(startValue + splitLineValue[0], splitLineValue[1]);
                   }
               }
               if (splitLineValue[0].contains("[")) {
                   startValue = splitLineValue[0].substring(1, splitLineValue[0].length() - 1) + ".";

               }
               if (splitLineValue[0].length() == 0) {
                   startValue = "";
               }
               //System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public String get(String key){
        return mapStoredValue.get(key);

    }
}
