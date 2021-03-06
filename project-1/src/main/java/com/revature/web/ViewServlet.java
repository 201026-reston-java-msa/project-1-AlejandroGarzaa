package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.repos.ReimbursementDao;
import com.revature.repos.UsersDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.HtmlTemplate;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = HtmlTemplate.getHtmlWriter(response);
		
				// we will create an html page on the fly
//		pw.println("<h3 style='color:red'>Denied</h3>");
//		pw.println("<p>Username or password is incorrect</p>");
		
		
		
		
	    pw.println("<html>");
	    pw.println("<head><title>Reimbursements</title>"
	    		+ "<link rel=\"stylesheet\"\r\n" + 
	    		"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n" + 
	    		"	integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + 
	    		"	crossorigin=\"anonymous\"></head>");
	    
	    pw.println("<body>");
	    
	    pw.println("	<div class=\"jumbotron\">\r\n" + 
	    		"		<h1 id=\"welcome\">Reimbursements</h1>\r\n" + 
	    	 
	    		"	</div>");
	    
		pw.println("<table border=2px><tr>");
		pw.println("<th> Reimb Id</th>");
		pw.println("<th> Amount</th>");
		pw.println("<th> Date Submitted Id</th>");
		pw.println("<th> Date Resolved Id</th>");
		pw.println("<th> Description</th>");
		pw.println("<th> Author </th>");
		pw.println("<th> Resolver</th>");
		pw.println("<th> Status</th>");
		pw.println("<th> Type</th>");
		pw.println("</tr>");
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursements;";

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				int amount = rs.getInt("reimb_amount");
				LocalDateTime subDate = rs.getTimestamp("reimb_submitted").toLocalDateTime();
				LocalDateTime resDate = rs.getTimestamp("reimb_resolved").toLocalDateTime();
				String description = rs.getString("reimb_description");
				int author = rs.getInt("reimb_author_id");
				int resolver = rs.getInt("reimb_resolver_id");
				int status = rs.getInt("reimb_status_id");
				int type = rs.getInt("reimb_type_id");
				
				pw.println("<tr>");
				pw.println("<td>" + id + "</td>");
				pw.println("<td>" + amount + "</td>");
				pw.println("<td>" + subDate + "</td>");
				pw.println("<td>" + resDate + "</td>");
				pw.println("<td>" + description + "</td>");
				pw.println("<td>" + author + "</td>");
				pw.println("<td>" + resolver + "</td>");
				pw.println("<td>" + status + "</td>");
				pw.println("<td>" + type + "</td>");
				//pw.println("</tr>");
			

			}
			pw.println("</tr></table>");

		} catch (SQLException e) {
			e.printStackTrace();
			//log.warn("Unable to retrieve all users");
		}
		
	}
}


		
//		
//		List<Reimbursement> list = ReimbursementDao.findAll();
//		pw.println("<table border=2px><tr>");
//		for (Reimbursement  r : list) {
//			pw.println("<th>" + r + "</th>");
//
//		
//			pw.println("</tr></table>");
//		}
//	}
//}
//

