import java.util.ArrayList;

public class ContactDAO implements IContactDAO {

	private ArrayList<Contact> contactListe;

	public ContactDAO(){
		this.contactListe = new ArrayList<Contact>();
	}
	
	private static IContactDAO cDAO = null;
	
	public static synchronized IContactDAO getInstanceCDAO(){
		
		if(cDAO==null){
			cDAO = new ContactDAO();}
		return cDAO;
	}

	/* (non-Javadoc)
	 * @see IContactDAO#readAll()
	 */
	public ArrayList<Contact> readAll() {
		return contactListe;
	}

	public void setContactListe(ArrayList<Contact> contactListe) {
		this.contactListe = contactListe;
	}

	/* (non-Javadoc)
	 * @see IContactDAO#findByName(java.lang.String)
	 */
	public Contact findByName(String name){

		int rep = -1;
		int i = 0;
		for (Contact contact : contactListe) {
			if (contact.getNom().equals(name)){rep=i;}
			i++;
		}
		if(rep > -1){
			return contactListe.get(rep);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see IContactDAO#addContact(Contact)
	 */
	public void addContact(Contact name){
		readAll().add(name);
	}
	
	public void supprContact(int index){

		readAll().remove(index);
	}
}
