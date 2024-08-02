package library;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
@WebServlet("/insertion")
public class insertservlet extends HttpServlet{
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Scanner scr=new Scanner(System.in);
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = mt.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t= s.beginTransaction();
		
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		long number=Long.parseLong(req.getParameter("number"));
		library li= new library(0, username, password, email, number);
		s.save(li);
		t.commit();
		
		}
	}