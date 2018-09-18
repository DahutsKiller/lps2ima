import static org.junit.Assert.*;

import org.junit.Test;


public class ContactServiceTest {
	
	private ContactService service = new ContactService();
	private IContactDAO dao = ContactDAO.getInstanceCDAO();
	
	@Test
	public void testNomOK() throws ContactDuplicateException{
		service.add("laurent");
		assertTrue("Test réussi","laurent".equals(dao.readAll().get(0).getNom()));	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomNull() throws ContactDuplicateException{
		service.add(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomTropCourt() throws ContactDuplicateException{
		service.add("ab");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNomTropCaractere() throws ContactDuplicateException{
		service.add("hsdmkqhfurqklghurkemlghzrkqmglruekqgbubuqjkmfbureqghurmhqghqgmrhgurlhgqgulhui");
	}
	
	@Test(expected=ContactDuplicateException.class)
	public void testNomUnique() throws ContactDuplicateException{
		service.add("arnaud");
		service.add("arnaud");
	}
}
