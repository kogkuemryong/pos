package finalSemiProj; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
//2. 이윤화면 
public class PanelBenefit extends JPanel {
	NoodleController con = new NoodleController();
	int mul;
	int bibim;
	int hae;
	int mandoo;
	int goggi;
	
	
	
	JButton[] MBtn = new JButton[5];
	String[] menu = {"물냉면", "비빔냉면","회냉면","왕만두","숯불고기"};
	int[] price = {mul, bibim, hae, mandoo, goggi};
	
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[3];
	String[] Str = {"전체메뉴","전체취소","총 매출"}; // {"쿠폰","선택취소","전체취소","총 매출"};
	String [] ColName = {"메뉴","매출금액"};
	String [][] Data ;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	//매출금액을 보여줄 창
	class Screen extends JPanel{
		Screen(){
			setBackground(new Color(40, 150, 210));
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("휴먼옛체", Font.PLAIN, 20));
			add(new JScrollPane(table));
		}
	}
	
	//물/비/회/고/만이 있는 창
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(5,3,3,3));
			setBackground(new Color(40, 150, 210));
			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]= new JButton(menu[i]);
				MBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));
				add(MBtn[i]);
			}
		}
	}
	
	// 선취, 전취, 총매가 있는 창
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(new Color(40, 150, 210));
			setLayout(new GridLayout(1,3,4,3));
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]= new JButton(Str[i]);
				SBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));
				add(SBtn[i]);
			}
		}
	}
	
	
	// 본격 생성자!!!!!!!!!
	public PanelBenefit() {
		setLayout(null);
		setBackground(new Color(40, 150, 210));
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sc.setSize(500, 500);
		sc.setLocation(25, 20);
		add(sc);
		
		mbtn.setSize(400, 430);
		mbtn.setLocation(530, 23);
		add(mbtn);
		
		sbtn.setSize(400, 70);
		sbtn.setLocation(530, 480);
		add(sbtn);
		
		
		//메뉴별 매출액 보여주기
		for(int i=0;i<MBtn.length;i++) {
			final int index =i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					
					price[index] = con.displayBenefit(index);
					m.addRow(new Object[]{menu[index],price[index]});

				}
			});
		}
		
//			//선택취소
//		SBtn[0].addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JButton MBtn = (JButton)e.getSource();
//				DefaultTableModel m = (DefaultTableModel)table.getModel();				
//				m.removeRow(table.getSelectedRow());
//			}
//		});



		//전체재고
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				
				for(int i = 0; i < 5; i++) {
					price[i] = con.displayBenefit(i);
				     m.addRow(new Object[]{menu[i],price[i]});
				}

				
			}
		});







		
		
		//전체취소
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();			
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});
		

		
		
		//총매출버튼
		SBtn[2].addActionListener(new ActionListener() {// 총매출 계산안됌 왜그럼 ㅇㅅㅇ?
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();

				int sell = con.displayTotalBenefit();
				tf.setText(String.valueOf(" 총 매출 : "+sell));
				tf.setFont(new Font("휴먼옛체", Font.BOLD, 40));
			}
		});
	}
}

