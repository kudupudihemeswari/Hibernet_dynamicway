package library;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class librarycontroller {
public static void main(String[] args) {
	Scanner scr = new Scanner(System.in);
	int ch;
	do {
		displaymethod();
		System.out.println("enter your choice:");
		ch=Integer.parseInt(scr.nextLine());
		switch (ch) {
		case 1:
			insertion();
			break;
		case 2:
			deletion();
			break;
		case 3:
			updation();
			break;
		case 4:
			getall();
			break;
		case 5:
			getbyid();
			break;
		case 6:
			System.exit(0);
			break;

		default:
			System.out.println("invalid operatipon");
			break;
		}
	} while (ch>0);
}

private static void getbyid() {
	// TODO Auto-generated method stub
	
}

private static void getall() {
	// TODO Auto-generated method stub
	
}

private static void updation() {
	// TODO Auto-generated method stub
	
}

private static void deletion() {
	// TODO Auto-generated method stub
	
}

@SuppressWarnings("deprecation")
private static void insertion() {
	Scanner scr=new Scanner(System.in);
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory sf = mt.buildSessionFactory();
	Session s = sf.openSession();
	Transaction t= s.beginTransaction();
	library li= new library();
	System.out.println("enter username");
	li.setUsername(scr.nextLine());
	System.out.println("enter password");
	li.setPassword(scr.nextLine());
	System.out.println("enter email");
	li.setEmail(scr.nextLine());
	System.out.println(":enter number");
	li.setNumber(scr.nextLong());
	s.save(li);
	t.commit();
	
}

private static void displaymethod() {
	System.out.println("________");
	System.out.println("\t1.insertion");
	System.out.println("\t2.deletion");
	System.out.println("\t3.updation");
	System.out.println("\t4.getall");
	System.out.println("\t5.getbyid");
	System.out.println("\t6.exit");
	System.out.println("________");
	
}
}