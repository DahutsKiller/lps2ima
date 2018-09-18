import java.util.ArrayList;

public interface IContactDAO {

	ArrayList<Contact> readAll();

	Contact findByName(String name);

	void addContact(Contact name);
	
	void supprContact(int index);

}