package Nov3;

import java.io.*;
import java.util.*;

public class Nov4 {
    static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("info text");

            fw.write("Hello Kanish");
            fw.write("What are you doing");
            fw.write("some messages some messages some messages some messages");
            fw.write("some messages some messages ");
            fw.write("some messages");
            fw.close();
            System.out.println("The file has been created");
        }
        catch(Exception e){
            System.out.println("An error has occurred:"+e);
        }
    }
}
