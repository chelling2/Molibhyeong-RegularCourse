package m0905;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ActionEventEx2 extends Frame implements ActionListener, WindowListener,KeyListener {

    Panel p;
    Button clear, exit;
    TextArea ta; 
    TextField tb;

    public ActionEventEx2() {

        super("ActionEvent Test2");

        p = new Panel();

        clear = new Button("clear");
        exit = new Button("exit");
        ta = new TextArea();
        tb = new TextField();

        // 이벤트소스를 이벤트핸들러에 연결. 핵심!
        clear.addActionListener(this);
        exit.addActionListener(this);

        p.add(clear);
        p.add(exit);

        add(p, BorderLayout.SOUTH);
        add(ta, BorderLayout.CENTER);
        add(tb, BorderLayout.NORTH);
        
        setBounds(300, 100, 300, 300);
        setVisible(true);

        this.addWindowListener(this);
    	tb.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	String name;
		name = e.getActionCommand();

		if (name.equals("clear")) {
			ta.setText("");
		} else {
			System.exit(0);
		}
      

    }

    public static void main(String[] args) {

        new ActionEventEx2();

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) { // x 클릭 시 창 종료함

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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			ta.append(String.valueOf(tb.getText()) + "\n");
			tb.setText("");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
