package storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bean.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory=metadata.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		
		Employee employee=new Employee();
		
		employee.setId(102);
		employee.setFirstName("Anu");
		employee.setLastName("Mathew");
		
		session.save(employee);
		
		System.out.println("Saved");
		
		transaction.commit();
		factory.close();
		session.close();

	}

}
