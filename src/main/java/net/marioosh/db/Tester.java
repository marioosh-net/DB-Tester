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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tester();
	}

	public Tester() {
		try {
			log.debug("Connecting...");
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			log.debug(conn);

			conn.close();
		} catch (ClassNotFoundException e) {
			log.error(e);
		} catch (SQLException e) {
			log.error(e);
		}

	}
}
