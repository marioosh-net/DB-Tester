package net.marioosh.db;

import java.sql.*;
import org.apache.log4j.Logger;

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
