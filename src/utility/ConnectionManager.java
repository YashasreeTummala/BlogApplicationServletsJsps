package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager 
{
	public static Connection getConnection() throws Exception 
	{
		//Creating Properties object and retrieving the details from properties file present in src.
		Properties properties = null;
		properties = loadPropertiesFile();
		
		//loading all properties like driver, url, username, password.
		final String driver = properties.getProperty("driver");
		final String url = properties.getProperty("url");
		final String username = properties.getProperty("username");
		final String password = properties.getProperty("password");
		
		//Loading Driver
		Class.forName(driver);
		Connection con = null;
		
		//Establishing Connection with database
		con = DriverManager.getConnection(url, username, password);
		
		if(con == null)
			System.out.println("Connection not Established");
		
		return con;
	}
	
	//loading preoperties from jdbc.properties file.
	public static Properties loadPropertiesFile() throws Exception 
	{
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop; 
	} 
	
}
