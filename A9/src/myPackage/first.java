package myPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class first
 */
@WebServlet("/first")
public class first extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public first() {
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
		doGet(request, response);
		
		String product_id = request.getParameter("product_id");
		String product_name = request.getParameter("product_name");
		String qty = request.getParameter("product_qty");
		int product_qty = Integer.parseInt(qty);
		String product_desc = request.getParameter("product_desc");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>First Servlet</h2>");
		out.println("Product Id: " + product_id + "<br>");
		out.println("Product Name: " + product_name + "<br>");
		out.println("Product Quantity: " + product_qty + "<br>");
		out.println("Product Description: " + product_desc + "<br><br>");
		
		HttpSession session = request.getSession();
		session.setAttribute("product_id",product_id);
		
		out.println("<a href='second'>Second Servlet</a>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
