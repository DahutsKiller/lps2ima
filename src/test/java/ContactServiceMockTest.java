import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ContactServiceMockTest extends EasyMockSupport{

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);

	@TestSubject
	private ContactService service = new ContactService();

	@Mock
	private IContactDAO contactDAO;

	@Test(expected=ContactDuplicateException.class)
	public void testAddContact() throws ContactDuplicateException{
		//1 - Enregistrement des comportements de Mocks.
		Contact contact =new Contact(null);
		EasyMock.expect(contactDAO.findByName("cekonve"))//
		.andReturn(contact);
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		service.add("cekonve");
		service.findByName("cekonve");
	}
	
	/*@Test(expected=ContactDuplicateException.class)
	public void testSupprContact() throws ContactDuplicateException{
		//1 - Enregistrement des comportements de Mocks.
		Contact contact =new Contact(null);
		EasyMock.expect(contactDAO.findByName("cekonve"))//
		.andReturn(null);
		//2 - Fin d'enregistrement
		replayAll();
		//3 - Test
		contact.getNom();
	}
	
	@Test
	public void TestDeleteContactExistEasyMockSample() throws ContactNotFound{*/
}