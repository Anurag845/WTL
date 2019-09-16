package myPackage;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class taxcalculate
 */
@WebServlet("/taxcalculate")
public class taxcalculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public taxcalculate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		doGet(request, response);
		String emp_id = request.getParameter("emp_id");
		String name = request.getParameter("emp_name");
		String sal = request.getParameter("gross_sal");
		int gross_sal = Integer.parseInt(sal);
		
		double income_tax = 0;
		
		if(gross_sal < 250000) {
			income_tax = 0;
		}
		else if(gross_sal < 500000) {
			income_tax = 0.1*gross_sal;
		}
		else {
			income_tax = 0.2*gross_sal;
		}
		
		out.print("<table style='margin:auto;border-collapse:collapse;'><tr><th>Emp_Id</th><th>Emp_Name</th><th>Gross Salary</th><th>Income Tax</th></tr>");
		out.print("<tr><td>"+emp_id+"</td><td>"+name+"</td><td>"+gross_sal+"</td><td>"+income_tax+"</td></tr></table>");
		
		try {
			java.sql.Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag","root","dell");
			
			PreparedStatement ps = conn.prepareStatement("insert into tax values(?,?,?,?)");
			ps.setString(1, emp_id);
			ps.setString(2, name);
			ps.setInt(3, gross_sal);
			ps.setDouble(4, income_tax);
			
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
