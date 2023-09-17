package m0905;

import java.awt.*;

public class RadioCheckBoxEx {

	public static void main(String[] args) {
		
		Frame f = new Frame("EXam");
		Panel p = new Panel();
		
		CheckboxGroup group = new CheckboxGroup();  //라디오는 그룹을 따로 만들어야하고,  라디오체크박스 클래스가 따로 없음 
		
		Checkbox radio1 = new Checkbox("a",group,false);
		Checkbox radio2 = new Checkbox("b",group,false);
		Checkbox radio3 = new Checkbox("c",group,true);
		
		p.add(radio1);
		p.add(radio1);
		p.add(radio1);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
		

	}

}
