package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

public class Connect {
	
	public static Connection conn;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// Port 3306 wamp et 8889 MAMP
	static final String DB_URL = "jdbc:mysql://localhost:3306/inscription";
	
	static final String USER = "root";
	// Pas sous wamp = "", "root" sous mamp
	static final String PASS = "";
	
	public Connect() {
		try {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Driver O.K.");
	
		      String url = DB_URL;
		      String user = USER;
		      String passwd = PASS;
	
		      @SuppressWarnings("unused")
		      Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");
		         
		} catch (Exception e) {
		      e.printStackTrace();
		}
	}
	
//	public static Connection connexion() throws ClassNotFoundException{
//		try {
//		      Class.forName("com.mysql.jdbc.Driver");
//		      System.out.println("Driver O.K.");
//	
//		      String url = DB_URL;
//		      String user = USER;
//		      String passwd = PASS;
//	
//		      @SuppressWarnings("unused")
//		      Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
//		      System.out.println("Connexion effective !");
//		         
//		} catch (Exception e) {
//		      e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public static String[] getNomsColonnes(ResultSet resultat) throws SQLException { 
//	   ResultSetMetaData metadata = (ResultSetMetaData) resultat.getMetaData(); 
//	   String[] noms = new String[metadata.getColumnCount()]; 
//	   for(int i = 0; i < noms.length; i++){ 
//	      String nomColonne = metadata.getColumnName(i+1); 
//	      noms[i] = nomColonne; 
//	   } 
//	   return noms; 
//	}
//	
//	public static void connexionExe (String req)
//	{
//		try {
//			connexion();
//			String sql = req;
//			Statement smt = conn.createStatement();
//			smt.executeUpdate(sql) ;
//		}  catch (Exception e) {
//			System.out.println( e.getMessage() );
//		}
//	}
//	
//
//
//	public static ResultSet connexionQuery (String req)
//	{
//		Connection conn = null;
//		try {
//			connexion();
//			String sql = req  ;
//			Statement smt = conn.createStatement() ;
//			ResultSet rs = smt.executeQuery(sql) ;
//			return rs;
//		}
//		catch (Exception e) {
//		// gestion des exceptions
//		System.out.println( e.getMessage() );
//		}
//
//		finally
//		{
//			try {
//				conn.close();
//			} catch (Exception e) {
//				
//				
//			}
//		}
//		return null;
//	}
	
	public void sql(String requete) {

		String url = DB_URL;
		String login = USER;
		String pass = PASS;
		Connection cn = null; Statement st = null; ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, login, pass);
			st = (Statement) cn.createStatement();
			// Requete
			String sql = requete;
			rs = st.executeQuery(sql);
			
			// AFFICHE TOUTES LES COLONNES 
			ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
			int columncount = metadata.getColumnCount();
			System.out.print("[");
			for (int i = 1; i <= columncount; i++) {
				System.out.print(metadata.getColumnName(i) + ", ");
			}
			System.out.print("]");
			System.out.println();
			while (rs.next()) {
		        String row = "";
		        for (int i = 1; i <= columncount; i++) {
		            row += rs.getString(i) + ", ";          
		        }
		        System.out.println();
		        System.out.println(row);
			}
			System.out.println();
		}
		catch (SQLException e) {
			// affiche les erreurs sql
			// e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				// Libérer les ress de la mémoire
				cn.close();
				st.close();
			}
			catch (SQLException e){
				e.printStackTrace();;
			}
		}
	}
}