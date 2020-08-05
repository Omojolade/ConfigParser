import java.io.File;

/**
 *  Program is executed in the main file  read command line argument
 */
public class Main {
    public static void main(String[] args) {
        //This is to read the file from terminal
        ConfigParser config = null;
        String production = new File("./src/main/java/config.txt").exists() ? "./src/main/java/config.txt" :
                "config.txt";
        String development = new File("./src/main/java/config.dev.txt").exists() ? "./src/main/java/config.dev.txt" :
                "config.dev.txt";
        String staging = new File("./src/main/java/config.staging.txt").exists() ? "./src/main/java/config.txt" :
                "config.staging.txt";
        try{
            //String fileName = "";
            if(args.length == 0){
                config = new ConfigParser(production);
            }else{
                switch (args[0].trim().toLowerCase()){
                    case "production":
                        config = new ConfigParser(production);
                        break;
                    case "development":
                        config = new ConfigParser(development);
                        break;
                    case "staging":
                        config = new ConfigParser(staging);
                        break;
                    default:
                        System.out.println("Invalid Mode");
                }
            }

            System.out.println(config.get("mode"));
            System.out.println(config.get("dbname"));
            System.out.println(config.get("application.name"));
            System.out.println(config.get("application.port"));
            System.out.println(config.get("mode"));

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
