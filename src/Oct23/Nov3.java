package Oct23;

import java.io.*;
public class Nov3 {
   public static void main(String[] args) {

       try{
           File obj = new File("myfile.text");

           if(obj.createNewFile()){
               System.out.println("File created"+obj.getName());
           }
           else{
               System.out.println("File already exists");
           }
       }
       catch(IOException e){
           System.out.println("An error occured");
           e.printStackTrace();
       }
   }
}
