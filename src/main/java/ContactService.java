public class ContactService {

	
	
	public ContactService(){
	}

	private IContactDAO dao = ContactDAO.getInstanceCDAO();
	
	public void add(String name) throws ContactDuplicateException{
		if(name == null || name.length()<3 || name.length()>40){
			throw new IllegalArgumentException("le param�tre name doit �tre valide (entre 3 et 40 caract�res");
		}
		if(dao.findByName(name) != null){
			throw new ContactDuplicateException("le contact "+name+" existe d�j�");
		}
		dao.addContact(new Contact(name));
	}

	public void readAll(){
		dao.readAll();
	}

	public void findByName(String name){
		dao.findByName(name);
	}
	
	public void supprContact(int index) throws ContactDuplicateException{

		dao.supprContact(index);
	}
}
