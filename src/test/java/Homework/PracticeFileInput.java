package Homework;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class PracticeFileInput {
    public static void main(String[] args){
        String path = System.getProperty("user.dir")+"/src/test/resources/data/quote.yml";
       // InputStream f = null;
        try (InputStream inputFileData = new FileInputStream(path)){
            Yaml y = new Yaml();
            Map<String,Map<String, String>> map = y.load(inputFileData);
            Map<String, String> actuallMap = map.get("admin");
            System.out.println(actuallMap);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
