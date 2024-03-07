package data;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public void writeToFile(String fileName, String data){
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
