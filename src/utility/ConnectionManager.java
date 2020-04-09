package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;


public class ConnectionManager {
	public static Connection getConnection() throws Exception,SQLException {
		Properties p = loadPropertiesFile(); //loadproperties returns properties.
		Class.forName(p.getProperty("driver")); //getting value in jdbc assigned to prop.why seperate file is db may change
		//create connection object
		System.out.println(p.getProperty("driver"));
		System.out.println(p.getProperty("url"));
		Connection con= null;
		con= DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
	
		return con;
		
		
	}
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in =  ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
	
}
// Can you show me the steps. okay i fork it first. copy the link. go to ubuntu. select directory. git clone and paste the link.
// Are you cloning the project or dwo. clonigfrom ubuntu. everything else is getting imported. just not that one.cloned twice also sir by deleting it
	// jdbc properties should be inside src. sir other projects it worked when kept in utility. sir as i said ski
	
// In your other project its inside src and not utility. oh okay sir got it. i have one more problem. not able to import day 2 project into eclipse
	//not getting import do i clone a project and open it sir?
// I have kept the name as projectt-builder-jd