package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class Dao {
	Connection con;
	public Dao()
	{
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","12345");
		} catch (Exception e) {
		e.printStackTrace();		
		}

}
public boolean adduser(int id,String name,String password,String mail,String address,String nick) {
	boolean res=false;
	try
	{
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, password);
		ps.setString(4, mail );
		ps.setString(5, address);
		ps.setString(6, nick);
		int a=ps.executeUpdate();
		if(a>0)
		{
			res=true;
		}
		else
		{
			res=false;
		}
   }

 catch(Exception e)
	{
	 e.printStackTrace();
	}
	return res;

}
public String userforget(int id,String nick)
{
	String a ="";
	try {
		System.out.println("hiii"+id);
		PreparedStatement ps1=con.prepareStatement("select * from user where id=? and nick=?");
		ps1.setInt(1, id);
		
		ps1.setString(2, nick);
		System.out.println("hiiooooo");
		ResultSet rs=ps1.executeQuery();
		
		if(rs.next())
		{
			
			 a=rs.getString(3);
		}
		else
		{
	
			a="invalid";
		}
	
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return a;
	
}
	public boolean adminsignup(int id,String name,String password,String mail,String address,String nick)
	{
		
		boolean res=false;
		try
		{
			PreparedStatement ps2=con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
			System.out.println("helloooo"+password);
			ps2.setInt(1, id);
			ps2.setString(2, name);
			ps2.setString(3, password);
			ps2.setString(4, mail );
			ps2.setString(5, address);
			ps2.setString(6, nick);
			int a=ps2.executeUpdate();
			
			if(a>0)
			{
				res=true;
			}
			else
			{
				res=false;
			}
	   }

	 catch(Exception e)
		{
		 e.printStackTrace();
		}
		return res;
	}
	
	public boolean userlog(int id,String password)
	
	{
		boolean res = false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from user where id=? and password=?");
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				res=true;
			}
			else
			{
				res=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public boolean adminlog(int id,String password)
	{
		boolean res = false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from admin where id=? and password=?");
			ps.setInt(1, id);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				res=true;
			}
			else
			{
				res=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public boolean addimage(int pid,String pname,String milege,String price,String maxd,String fileName,String qty)
	{
		boolean res = false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, milege);
			ps.setString(4,  price);
			ps.setString(5, maxd);
            ps.setString(6, fileName);
            ps.setString(7, qty);
			int a=ps.executeUpdate();
			if(a>0)
			{
				res=true;
			}
			else
			{
				res=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public boolean delete(int pid)
	{
		boolean res = false;
		try {
			System.out.println("hiiii");
			PreparedStatement ps=con.prepareStatement("delete from product where pid=?");
			ps.setInt(1, pid);
			int a=ps.executeUpdate();
			{
				
				if(a>0)
				{
					res=true;
				}
				else
				{
					res=false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	public boolean update(int pid,String pname,String milege,String price,String qty)
	{ 
	boolean res = false;
		try {

			PreparedStatement ps=con.prepareStatement(" update product set pname=?,milege=?,price=?,qty=? where pid=?");
			ps.setString(1,pname);
			ps.setString(2, milege);
			ps.setString(3, price);
			ps.setInt(5, pid);
			ps.setString(4,qty);
			int a=ps.executeUpdate();
			if(a>0)
			{
				res=true;
			}
			else
			{
				res=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return res;
	
	}
	public ResultSet search(String pname)
	{
		ResultSet rs = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where pname like '%"+pname+"%'");

			 rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs;		
	}
	public ResultSet showall()
	{
		ResultSet rs = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product ");
			 rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet userclick(int pid)
	{
		ResultSet rs = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
            ps.setInt(1, pid);
			 rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs;		
	}
	public ArrayList<Getter> getallitems()
	{
	ArrayList<Getter> li=new ArrayList<Getter>();
	Getter g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from product");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			g=new Getter();
			g.setPid(rs.getInt(1));
			g.setPname(rs.getString(2));
			g.setMilege(rs.getString(3));
			g.setPrice(rs.getString(4));
			g.setMaxd(rs.getString(5));
			g.setFileName(rs.getString(6));
			li.add(g);
			System.out.println("hiiiiii1");
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	public ArrayList<Getter> showp(int pid)
	{
	ArrayList<Getter> li=new ArrayList<Getter>();
	Getter g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
		ps.setInt(1,pid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			g=new Getter();
			g.setPid(rs.getInt(1));
			g.setPname(rs.getString(2));
			g.setMilege(rs.getString(3));
			g.setPrice(rs.getString(4));
			g.setMaxd(rs.getString(5));
			g.setFileName(rs.getString(6));
			g.setQty(rs.getString(7));
			li.add(g);
			System.out.println("hiiiiii1");
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	public ArrayList<Getter> searchsecond(String pname)
	{
	ArrayList<Getter> li=new ArrayList<Getter>();
	Getter g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from product where pname like '%"+pname+"%'");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			g=new Getter();
			g.setPid(rs.getInt(1));
			g.setPname(rs.getString(2));
			g.setMilege(rs.getString(3));
			g.setPrice(rs.getString(4));
			g.setMaxd(rs.getString(5));
			g.setFileName(rs.getString(6));
			li.add(g);
			System.out.println("hiiiiii1");
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	public ArrayList<Getter> searchfilter(String pname,int price)
	{
	ArrayList<Getter> li=new ArrayList<Getter>();
	Getter g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from product where pname like '%"+pname+"%'");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{ 
			String a=rs.getString(4);
			int b=Integer.parseInt(a);
			if(price>b)
			{
			g=new Getter();
			g.setPid(rs.getInt(1));
			g.setPname(rs.getString(2));
			g.setMilege(rs.getString(3));
			g.setPrice(rs.getString(4));
			g.setMaxd(rs.getString(5));
			g.setFileName(rs.getString(6));
			li.add(g);
			System.out.println("hiiiiii1");
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	public boolean cart(String userid,String pid,String pname,String milege,int price,int maxd,String fileName,int qty)
	{
		
		boolean res = false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?,?,?,?,?)");
			ps.setString(1, userid);
			ps.setString(2, pid);
			ps.setString(3, pname);
			ps.setString(4, milege);
			ps.setInt(5, price);
			ps.setInt(6, maxd);
			ps.setString(7, fileName);
			ps.setInt(8, qty);
			int a=ps.executeUpdate();
			if(a>0)
			{
				res=true;
			}
			else
			{
				res=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
