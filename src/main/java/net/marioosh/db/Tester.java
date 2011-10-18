package net.marioosh.db;

import java.sql.*;
import org.apache.log4j.Logger;

/**
 * odpalanie z mavena: 
 * 		mvn test
 * lub
 * 		mvn exec:java -Dexec.mainClass="net.marioosh.db.Tester"  
 * 
 * @author muniek
 *
 */
public class Tester {

	private Logger log = Logger.getLogger(getClass());
	
	private static String url;
	private static String username;
	private static String password;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length > 0) {
			url = args[0];
		}
		if(args.length > 1) {
			username = args[1];
		}
		if(args.length > 2) {
			password = args[2];
		}
		new Tester();
	}

	public Tester() {
		try {
			log.debug("Connecting...");
			
			/**
			 * H2
			 *
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			*/
			
			/**
			 * PG
			 *
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.10.253/test", "postgres", "");
			*/
			
			/**
			 * uniwersal
			 */
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			
			DatabaseMetaData db = conn.getMetaData();
			log.debug("DB product name: " + db.getDatabaseProductName());			
			log.debug("DB major version: " + db.getDatabaseMajorVersion());
			log.debug("DB minor version: " + db.getDatabaseMinorVersion());

			conn.close();
		} catch (ClassNotFoundException e) {
			log.error(e);
		} catch (SQLException e) {
			log.error(e);
		}

	}
}
