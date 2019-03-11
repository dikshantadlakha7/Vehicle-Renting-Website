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
			System.out.println("welcome");
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
	ArrayList<Getter> li2=new ArrayList<Getter>();
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
	
	
	
	
	public int check(int pi,String pname)
	{
		int c = 0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where pid=? and pname=?");
			ps.setInt(1, pi);
			ps.setString(2, pname);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			String a=rs.getString(5);
			c=Integer.parseInt(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	
	public int qtcheck(int pi)
	{
		int q=0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
			ps.setInt(1,pi);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String q1=rs.getString(7);
				q=Integer.parseInt(q1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;	
	}	
	
	
	
	
	
	public int usercart(String userid,String pid)
	{ 
		int q = 0;
		try {
			PreparedStatement ps=con.prepareStatement("select * from cart where userid=? and pid=?");
			ps.setString(1, userid);
			ps.setString(2, pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
		   q=rs.getInt(9);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return q;
	}
	
	
	
	
	
	
  public boolean idcheck(String userid,String pid)
  {
	  boolean res = false;
	  try {
		PreparedStatement ps=con.prepareStatement("select * from cart where userid=? and pid=?");
		ps.setString(1, userid);
		ps.setString(2,pid);
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
  
  
  
  
	public boolean updatecart(String userid,String pid,int total)
	{
		boolean res = false;
		try {
			PreparedStatement ps=con.prepareStatement("update cart set qty=? where userid=? and pid=?");
			ps.setInt(1,total);
			ps.setString(2, userid);
			ps.setString(3, pid);
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
	
	
	
	
	
	public boolean cart(String userid,String pid,String pname,String milege,int price,int maxd,String fileName,int qty)
	{
		boolean res = false;
		try {
			
PreparedStatement ps=con.prepareStatement("insert into cart(userid,pid,pname,milege,price,maxd,fileName,qty) values(?,?,?,?,?,?,?,?)");
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
	
	
	
	
	public ArrayList<Get> gocart(String userid)
	{
	ArrayList<Get> li=new ArrayList<Get>();
	Get g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from cart where userid=?");
		ps.setString(1,userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			g=new Get();
			g.setPid(rs.getString(3));
			g.setPname(rs.getString(4));
			g.setMilege(rs.getString(5));
			g.setPrice(rs.getInt(6));
			g.setMaxd(rs.getInt(7));
			g.setFileName(rs.getString(8));
			System.out.println("cartttttttttthhehheheheh");
			g.setQty(rs.getInt(9)); 
			li.add(g);
			System.out.println("cartttttttttt");
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	
	
	
	
	public boolean finalybuy(String userid,String username,String phone,String email,String address,String pid,String pname,String milege,int price,int maxd,String fileName,int qty,String date)
	{
		System.out.println(date);
		System.out.println(milege);
		boolean b=false;
		try {
		PreparedStatement ps=con.prepareStatement("insert into buy(userid,username,phone,email,address,pid,pname,milege,price,maxd,fileName,qty,status,date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	   ps.setString(1, userid);
	   ps.setString(2,username);
	   ps.setString(3, phone);
	   ps.setString(4, email);
	   ps.setString(5, address);
	   ps.setString(6, pid);
	   ps.setString(7, pname);
	   ps.setString(8, milege);
	   System.out.println(milege);
	   ps.setInt(9, price);
	   System.out.println(price);
	   ps.setInt(10, maxd);
	   System.out.println(maxd);
	   ps.setString(11, fileName);
	   System.out.println(fileName);
	   ps.setInt(12,qty);
	   ps.setString(13, "pending");
	   ps.setString(14, date);
	   System.out.println(qty);
	   int a=ps.executeUpdate();
	   System.out.println("kuch ni rakha");
	   if(a>0)
	   {
		   b=true;
	   }
	   else
	   {
		   b=false;
	   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean cdel(String pid,String userid)
	{
		boolean rs=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete from cart where userid=? and pid=?");
			ps.setString(1, userid);
			ps.setString(2, pid);
			int a=ps.executeUpdate();
			if(a>0)
			{
				rs=true;
			}
			else
			{
				rs=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	
	
	
	
	

	public ArrayList<Get> prevdetails(String userid)
	{
	ArrayList<Get> li=new ArrayList<Get>();
	Get g=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from buy where userid=?");
		ps.setString(1,userid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			g=new Get();
            g.setUserid(rs.getString(2));
            g.setUsername(rs.getString(3));
            g.setPhone(rs.getString(4));
            g.setEmail(rs.getString(5));
            g.setAddress(rs.getString(6));
			li.add(g);
			System.out.println("cartttttttttt");
			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return li;
	}
	
	
	
}
