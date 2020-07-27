package finalSemiProj; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


//2. 재고화면 
public class PanelStock extends JPanel {
	NoodleController con = new NoodleController();
	JButton[] MBtn = new JButton[9];
	String[] menu = {"면", "육수","계란","오이","고명고기", "무", "회", "만두", "숯불고기"};
	int n, y, e, o, gg, m, h, md, g;
	int[] price = {n, y, e, o, gg, m, h, md, g};

	
	//JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[3];
	String[] Str = {"전체재고","선택취소","전체취소"};
	String [] ColName = {"메뉴","재고량"};//기사용 재료?
	String [][] Data ;
//	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	//재고현황 보여줄 판
	class Screen extends JPanel{
		Screen(){
			setBackground(new Color(255, 255, 215));
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("휴먼옛체", Font.PLAIN, 20));
			add(new JScrollPane(table));
		}
	}
	
	//재고관리 종류
	class MenuBtn extends JPanel{
		MenuBtn(){
			setLayout(new GridLayout(3,3,3,3));
			setBackground(new Color(255, 255, 215));
			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]= new JButton(menu[i]);
				MBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));
				add(MBtn[i]);
			}
		}
	}
	
	// 선택취소, 전체취소
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(new Color(255, 255, 215));
			setLayout(new GridLayout(1,3,3,3));
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]= new JButton(Str[i]);
				SBtn[i].setFont(new Font("휴먼옛체", Font.PLAIN, 20));
				add(SBtn[i]);
			}
		}
	}
	
	public PanelStock() {
		setLayout(null);
		setBackground(new Color(255, 255, 215));
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		
		//tf.setSize(450, 70);
		//tf.setLocation(50, 480);
		//add(tf);
		
		sc.setSize(500, 700);
		sc.setLocation(25, 20);
		add(sc);
		
		mbtn.setSize(400, 430);
		mbtn.setLocation(530, 23);
		add(mbtn);
		
		sbtn.setSize(400, 70);
		sbtn.setLocation(530, 480);
		add(sbtn);
		
		
		
		//재고 클릭
		for(int i=0;i<MBtn.length;i++) {
			final int index =i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					
					
					
					price[index] = con.getStock(index);
					m.addRow(new Object[]{menu[index],price[index]});
				}
			});
		}

		//전체 재고 --메서드 바꿔야함
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JButton MBtn = (JButton)e.getSource();
//				table.setValueAt(0, table.getSelectedRow(), 2); // setValueAt(Object aValue, int row, int column)
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				
				for(int i = 0; i < 9; i++) {
					price[i] = con.getStock(i);
				     m.addRow(new Object[]{menu[i],price[i]});
				}
				
			}
		});



		
			//선택취소
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());
			}
		});
		
		
		//전체취소
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				//tf.setText(String.valueOf(""));
			}
		});
		
	}
}

