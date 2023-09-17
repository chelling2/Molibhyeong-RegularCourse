package m0905;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutEx {

	public static void main(String[] args) {
		
		Frame f = new Frame("border");
		
		Button east = new Button("East");
		Button west = new Button("West");
		Button center = new Button("Center");
		Button south = new Button("South");
		Button north = new Button("North");
		
		f.add(east,BorderLayout.EAST);
		f.add(west,BorderLayout.WEST);
		f.add(center,BorderLayout.CENTER);
		f.add("South",south);
		f.add("North",north);
		
		f.setLocation(300,300);
		f.setSize(300,100);
		f.setVisible(true);
	}

}
