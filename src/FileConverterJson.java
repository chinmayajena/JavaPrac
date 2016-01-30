import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileConverterJson {

  public static void main(String[] args) {
    File file = new File("data/sampledata.json");
    FileWriter fw = null;
    try {
      fw = new FileWriter("data/outdata.json");
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      String thisLine = null;
      BufferedReader br = new BufferedReader(new FileReader(file));
      BufferedWriter bw = new BufferedWriter(fw);
      while ((thisLine = br.readLine()) != null) {
          String line = thisLine.trim();
          if(line.startsWith("\'")){
          bw.write(line.substring(1, line.length()));
          }else{
            bw.write(line);
          }
     }  
      bw.flush();
      bw.close();
      br.close();
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}

