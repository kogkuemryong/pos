package finalSemiProj; 

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//import gui.JComboBoxPanel;
//import gui.JRadioPanel;
//import gui.JTabbedPaneFrame;

public class POS_Frame extends JFrame {
	public POS_Frame() {
		
		
		setTitle("POS 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new PanelPOS());

		setSize(985,660);
		setVisible(true);
		
		//------------------------------------------
		
		setTitle("이윤 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new PanelBenefit()); 

		setSize(985,660);
		setVisible(true);
		
		//------------------------------------------
		setTitle("재고 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new PanelStock());  //채민이 패널

		setSize(985,660);
		setVisible(true);
	}
}

class JTabbedPaneFrame extends JFrame{ 
	
	JTabbedPaneFrame(){
		PanelPOS tab1 = new PanelPOS(); //첫번째 탭 객체 생성
		PanelBenefit tab2 = new PanelBenefit(); //두번째 탭 객체 생성
		PanelStock tab3 = new PanelStock(); //두번째 탭 객체 생성
		
		JTabbedPane jtp = new JTabbedPane(); //탭 객체 생성
		
		jtp.addTab("POS 프로그램", tab1);
		jtp.addTab("이윤 프로그램", tab2);
		jtp.addTab("재고 프로그램", tab3);
		
		Container container = getContentPane(); 
		
		container.add(jtp);
		
		//컨테이너 제목,크기, 종료, 보이기
		setTitle("냉면선호 관리자 프로그램");
		setSize(1000,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

//public class Swing16 {
//	public static void main(String[] args) {
//		new JTabbedPaneFrame();
//
//	}
//}
