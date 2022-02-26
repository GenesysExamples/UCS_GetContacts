package andrei.genesysexamples.get_contact.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
@PropertySource("file:applications.properties")
@ConfigurationProperties
public class Confg {
    private static Map<String, String> ucs = new HashMap<>();
    private static String appName = "testAPP";
    private static String server = "localhost";
    private static int port = 0;
    private static int tenantId = 101;

    public Confg(){
        if(ucs != null) {
            setAppName(ucs.get("appName"));
            setServer(ucs.get("server"));
            setPort(ucs.get("port"));
            setTenantId(ucs.get("tenantId"));
        }
    }

    public Map<String, String> getUcs(){
        return ucs;
    }
    public void setUcs(Map<String, String> ucs){
        this.ucs = ucs;
    }

    public String getAppName(){
        return appName;
    }
    public void setAppName(String appName){
        this.appName = appName;
    }

    public String getServer(){
        return server;
    }
    public void setServer(String server){
        this.server = server;
    }

    public int getPort(){
        return port;
    }
    public void setPort(String port){
        try {
            this.port = Integer.parseInt(port);
        }catch(NumberFormatException nfe){
            this.port = 0;
        }
    }

    public int getTenantId(){
        return tenantId;
    }
    public void setTenantId(String tenantId){
        try {
            this.tenantId = Integer.parseInt(tenantId);
        }catch(NumberFormatException nfe) {
            this.tenantId = 101;
        }
    }

}
