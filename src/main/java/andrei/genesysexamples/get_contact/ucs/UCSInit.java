package andrei.genesysexamples.get_contact.ucs;

import andrei.genesysexamples.get_contact.configuration.Confg;
import com.genesyslab.platform.commons.protocol.ChannelClosedOnSendException;
import com.genesyslab.platform.commons.protocol.Endpoint;
import com.genesyslab.platform.commons.protocol.ProtocolException;
import com.genesyslab.platform.commons.protocol.RegistrationException;
import com.genesyslab.platform.contacts.protocol.UniversalContactServerProtocol;

public class UCSInit{
    private static UniversalContactServerProtocol ucsConnection;
    private static Confg configUcs = new Confg();

    public void init(){
        try{
            Endpoint ep = new Endpoint(configUcs.getAppName(), configUcs.getServer(), configUcs.getPort());

            ucsConnection = new UniversalContactServerProtocol(ep);
            ucsConnection.setClientName(configUcs.getAppName());
            ucsConnection.open();
        } catch (ChannelClosedOnSendException e){
            e.printStackTrace();
        } catch (RegistrationException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public UniversalContactServerProtocol ucs(){
        return ucsConnection;
    }
}
