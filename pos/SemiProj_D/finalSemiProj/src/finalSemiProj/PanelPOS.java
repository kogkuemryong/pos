package finalSemiProj; 

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//1. POS화면 
public class PanelPOS extends JPanel {
	JButton[] MBtn = new JButton[11];
	String[] menu = {"<html>물냉면 <br />소<html>","<html>물냉면<br  /> 중<html>","<html>물냉면<br  /> 대<html>","<html>비빔냉면 <br  />소<html>","<html>비빔냉면<br  /> 중<html>","<html>비빔냉면<br  /> 대<html>","<html>회냉면<br  /> 소<html>","<html>회냉면<br  /> 중<html>", "<html>회냉면 <br  />대<html>","왕만두","숯불고기"};
	int[] price = {6000,6500,7000,6000,6500,7000,7000,7500,8000,4000,6000};
	List<Integer> selectBtn = new ArrayList<Integer>();
	MenuDAO dao = new MenuDAO();
	Stock ds = new Stock();
	Benefit db = new Benefit();
	
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[4];
	String[] Str = {"선택취소","전체취소","결제"};
	String [] ColName = {"메뉴","수량","가격"};
	String [][] Data ; //menu를 4행3열 꼴로 만들어주는 친구
	int count =1; // 이건 왜인지 ㅇㅅㅇ?
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);

	
	//장바구니패널 판
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.pink);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("휴먼옛체", Font.PLAIN, 20));
			add(new JScrollPane(table)); // 장바구니 스크롤바
		}
	}
	
	//메뉴의 패널 판 
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(4,3,3,3));
			setBackground(Color.PINK);
			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]= new JButton(menu[i]);	
				MBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));		
				add(MBtn[i]);
//				String n = MBtn[i].toString();				
			}
		}
	}
	
	// 메뉴아래 쿠폰, 취소, 결제 칸
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(Color.pink);
			setLayout(new GridLayout(1,3,3,3));
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]= new JButton(Str[i]);
				SBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));
				add(SBtn[i]);
			}
		}
	}
	
	public PanelPOS() {
		setLayout(null);
		setBackground(Color.PINK);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		//금액란
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
		
		//메뉴추가
		for(int i=0; i<MBtn.length; i++) {
			final int index =i; // 왜 단건가 -- 이 아래에서 index가 변하지 않고 처음 받은 값을 계속 가지고 다닐 수 있게 하려고. 즉, 첫번째 index는 무조건 0을 의미한다.
			MBtn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource(); // index 0에 해당하는 소스를 가지고옴
					//System.out.println(MBtn);
					DefaultTableModel m = (DefaultTableModel)table.getModel(); // 그 소스를 가지고 테이블 형태로 표현할꺼임
					m.addRow(new Object[]{menu[index],count,price[index]}); // 그 테이블은 1행 3열 꼴임
					
					//noddleController con = new noddleController();
					//con.addMenu(index);
					selectBtn.add(index);
				}
			});
		}
		
		

		
			//선택취소
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				int sr = table.getSelectedRow();
				m.removeRow(sr);
				selectBtn.remove(sr);
			}
		});
		
		
		//전체취소
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0); // 들어가있는 수 만큼의 테이블이 형성됨
				selectBtn = new ArrayList<Integer>();
				tf.setText(String.valueOf(""));
			}
		});
		
		//결제버튼
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NoodleController con = new NoodleController();
				
				for(Integer select : selectBtn) {
					con.addMenu(select);
					dao.updateStock(ds); // DB연동
					dao.updateBenefit(db); // DB연동
				}
				
				selectBtn = new ArrayList<Integer>();
				
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				int rowCont = table.getRowCount();
				int sum =0;
				for(int i=0;i<rowCont;i++) {
					sum += (int)table.getValueAt(i, 2);
				}
				m.setRowCount(0);//결제 누르면 장바구니 담긴애들 사라지게 함
				tf.setText(String.valueOf(" 총 금액 : "+sum));
				tf.setFont(new Font("휴먼옛체", Font.BOLD, 40));
			}
		});
	}

}

