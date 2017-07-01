package com.hybridFramework.homepage;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.hybridFramework.database.DataBase;
import com.hybridFramework.testBase.TestBase;

public class DBTest extends TestBase{
	
	@Test
	public void selectDBdata() throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM registration";
		DataBase dataBase = new DataBase();
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(2));
		}
	}
	
	@Test
	public void insertDBdata() throws ClassNotFoundException, SQLException{
		String query = "insert into registration values('2','bhnau','testing')";
		DataBase dataBase = new DataBase();
		dataBase.insertData(query);	
	}
	
	@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "update registration set name='56777' where name=testing";
		DataBase dataBase = new DataBase();
		dataBase.updateData(query);
		
	}

}
