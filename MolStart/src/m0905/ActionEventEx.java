package m0905;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx extends Frame implements ActionListener , WindowListener{

	Panel p;
	Button input,exit;
	TextArea ta;
	
	public ActionEventEx() {
		
		super("ActionEvent Test");
		
		p= new Panel();
		
		input = new Button("input");
		exit = new Button("exit");
		ta = new TextArea();
		
		// 이벤트소스를 이벤트핸들러에 연결.  핵심!
		input.addActionListener(this);
		exit.addActionListener(this);
		
		p.add(input);
		p.add(exit);
		
		add(p,BorderLayout.NORTH);
		add(ta,BorderLayout.CENTER);
		
		setBounds(300,300,300,200);
		setVisible(true);
		this.addWindowListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name;
		name = e.getActionCommand();
		
		if(name.equals("input"))
			ta.append("입력...\n");
		
		else {
			
			ta.append("대기중...\n");
			
			try {
				Thread.sleep(2000);
			}catch(Exception r) {
				
			}
			
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		
		new ActionEventEx();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {   // x 클릭 시 창 종료함 
		
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
