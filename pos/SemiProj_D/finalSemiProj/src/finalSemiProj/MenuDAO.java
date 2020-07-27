package finalSemiProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


class MenuDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid = "scott";
	private String passwd = "tiger";
	
	
	
	MenuDAO() { // db와 한번만 연동하기 위해 생성자에서 연결함.
		try {
			Class.forName(driver);
			//System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	public ArrayList<Stock> selectStock() {
		Connection conn = null;
		String sql = "select * from stock";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stock> list = new ArrayList<Stock>(); 
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd); 
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) { 
				Stock dto = new Stock();
				
				dto.setNoodle(rs.getInt("noodle"));
				dto.setYuksu(rs.getInt("yuksu"));
				dto.setGomung_mu(rs.getInt("gomung_mu"));
				dto.setGomung_egg(rs.getInt("gomung_egg"));
				dto.setGomung_goggi(rs.getInt("gomung_goggi"));
				dto.setGomung_oi(rs.getInt("gomung_oi"));
				dto.setHae(rs.getInt("hae"));
				dto.setGoggi(rs.getInt("goggi"));
				dto.setMandoo(rs.getInt("mandoo"));
	
				
				list.add(dto);
			}return list;
				
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;

	}
	
	public ArrayList<Benefit> selectBenefit() {
		Connection conn = null;
		String sql = "select * from benefit";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Benefit> list = new ArrayList<Benefit>(); 
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd); 
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) { 
				Benefit dto = new Benefit();
				
				dto.setTotalMulBenefit(rs.getInt("totalMulBenefit"));
				dto.setTotalBibimBenefit(rs.getInt("totalBibimBenefit"));
				dto.setTotalHaeBenefit(rs.getInt("totalHaeBenefit"));
				dto.setMandooBenefit(rs.getInt("mandooBenefit"));
				dto.setGoggiBenefit(rs.getInt("goggiBenefit"));
				dto.setTotalBenefit(rs.getInt("totalBenefit"));

	
				
				list.add(dto);
			}return list;
				
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;

	}
	
	
	
	
	
	

	
	public void updateStock(Stock ds) {
		String sql = "update stock set noodle = ?, yuksu =?, gomung_mu = ?, gomung_egg = ?, gomung_goggi=?, gomung_oi=?, hae=?, goggi=?, mandoo=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(sql);
			
					pstmt.setInt(1, ds.getNoodle());
					pstmt.setInt(2, ds.getYuksu());
					pstmt.setInt(3, ds.getGomung_mu());
					pstmt.setInt(4, ds.getGomung_egg());
					pstmt.setInt(5, ds.getGomung_goggi());
					pstmt.setInt(6, ds.getGomung_oi());
					pstmt.setInt(7, ds.getHae());
					pstmt.setInt(8, ds.getGoggi());
					pstmt.setInt(9, ds.getMandoo());
				
					int result = pstmt.executeUpdate();
					
					if(result == 1) {
						System.out.println("데이터 수정 성공");
					}else {
						System.out.println("데이터 수정 실패");
					}
				
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						 if(pstmt != null) {pstmt.close();}
						 if(conn != null) {conn.close();}
					} catch (SQLException e) {
						e.printStackTrace();
					}			
				}				
	}
	
	
	public void updateBenefit(Benefit db) {
		String sql = "update benefit set totalMulBenefit=?, totalBibimBenefit=?, totalHaeBenefit=?, mandooBenefit=?, goggiBenefit=?, totalBenefit=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DriverManager.getConnection(url, userid, passwd);
			pstmt = conn.prepareStatement(sql);
			
					pstmt.setInt(1, db.getTotalMulBenefit());
					pstmt.setInt(2, db.getTotalBibimBenefit());
					pstmt.setInt(3, db.getTotalHaeBenefit());
					pstmt.setInt(4, db.getMandooBenefit());
					pstmt.setInt(5, db.getGoggiBenefit());
					pstmt.setInt(6, db.getTotalBenefit());

				
					int result = pstmt.executeUpdate();
					
					if(result == 1) {
						System.out.println("데이터 수정 성공");
					}else {
						System.out.println("데이터 수정 실패");
					}
				
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						 if(pstmt != null) {pstmt.close();}
						 if(conn != null) {conn.close();}
					} catch (SQLException e) {
						e.printStackTrace();
					}			
				}				
	}
	
	

}
