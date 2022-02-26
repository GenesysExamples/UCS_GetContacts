package andrei.genesysexamples.get_contact.ucs;

import andrei.genesysexamples.get_contact.configuration.Confg;
import com.genesyslab.platform.commons.protocol.Message;
import com.genesyslab.platform.contacts.protocol.UniversalContactServerProtocol;
import com.genesyslab.platform.contacts.protocol.contactserver.Operators;
import com.genesyslab.platform.contacts.protocol.contactserver.SearchCriteriaCollection;
import com.genesyslab.platform.contacts.protocol.contactserver.SimpleSearchCriteria;
import com.genesyslab.platform.contacts.protocol.contactserver.events.EventError;
import com.genesyslab.platform.contacts.protocol.contactserver.events.EventGetContacts;
import com.genesyslab.platform.contacts.protocol.contactserver.requests.RequestGetContacts;

import java.util.HashMap;
import java.util.Map;

public class UCSGetContact{
    private static Confg confUcs = new Confg();
    private static UCSInit ucs = new UCSInit();
    private static UniversalContactServerProtocol ucsp;
    private Map<String, Object> mapContact = new HashMap<>();

    public void init(){
        ucsp = ucs.ucs();
    }

    public int getContacts(String contacts, String attrName){
        int countContacts = -1;
        try{
            RequestGetContacts request = new RequestGetContacts();
            request.setTenantId(confUcs.getTenantId());
            SearchCriteriaCollection scc = new SearchCriteriaCollection();

            SimpleSearchCriteria searchCriteria = new SimpleSearchCriteria();
            searchCriteria.setAttrName(attrName);
            searchCriteria.setAttrValue(contacts);
            searchCriteria.setOperator(Operators.Equal);

            scc.add(searchCriteria);
            request.setSearchCriteria(scc);

            Message response = ucsp.request(request);

            if(response.messageName().equals("EventError")){
                EventError eventError = (EventError) response;
                System.out.print(eventError);
                return -1;
            }
            EventGetContacts getContacts = null;
            if(response.messageName().equals("EventGetContacts")) {
                getContacts = (EventGetContacts) response;
            }

            countContacts = getContacts.getCurrentCount();
            if(countContacts > 0) {
                mapContact.put("contacts", getContacts.getContactData());
                return countContacts;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

        return countContacts;
    }

    public Map<String, Object> getMapContact(){
        return mapContact;
    }
}
