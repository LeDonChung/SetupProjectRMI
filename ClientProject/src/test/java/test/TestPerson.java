package test;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.donchung.server.dao.PersonDAO;
import com.donchung.server.entities.Gender;
import com.donchung.server.entities.Person;


public class TestPerson {
    public static final String URL = "rmi://LAPTOP-646QQPK1:23861/";

	private PersonDAO personDAO;
	
	@BeforeEach
	public void setUp() throws MalformedURLException, RemoteException, NotBoundException {
		personDAO = (PersonDAO) Naming.lookup(URL + "personDAO");
	}
	
	@Test
	public void testFindAll() throws RemoteException {
		personDAO.findAll().forEach(System.out::println);
	}
	
	@Test
	public void testSave() throws RemoteException {
		Person person = new Person();
		person.setName("ThanhTuyen");
		person.setGender(Gender.FEMALE);
		
		List<String> phones = new ArrayList<String>();
		phones.add("0867713557");
		phones.add("038833821");
		
		person.setPhones(phones);
		
		Person manager = new Person();
		manager.setId(1);
		
		person.setManager(manager);
		
		personDAO.save(person);
		personDAO.findAll().forEach(System.out::println);
	}
	
}
