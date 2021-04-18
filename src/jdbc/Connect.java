package jdbc;

//database connection
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Connect")
public class Connect extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String name=req.getParameter("name");
	int id=Integer.parseInt(req.getParameter("id"));
	String address=req.getParameter("addres");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","rajesh");
		PreparedStatement pes=con.prepareStatement("insert into person values(?,?,?)");
		pes.setString(1,name);
		pes.setInt(2,id);
		pes.setString(3,address);
		int i=pes.executeUpdate();
		if(i>0)
		out.println("inserted database");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	out.close();
	}
	}

