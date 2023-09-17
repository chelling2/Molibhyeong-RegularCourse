package m0905;

import java.awt.*;

public class TextFieldEx {
   public static void main(String[] args) {
      Frame f = new Frame("EXam");
      Panel p = new Panel();
      
      TextField tf1 = new TextField("Id input: ", 12);
      TextField tf2 = new TextField("password",10);
      
      tf1.selectAll();
      tf2.selectAll();
      
      tf2.setEchoChar('*');
      
      p.add(tf1);
      p.add(tf2);
      
      f.add(p);
      
      f.setSize(300,100);
      f.setVisible(true);
   }
}