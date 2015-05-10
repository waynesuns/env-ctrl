package com.waynesun.common.biz.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class PasswordHandler implements CallbackHandler {  
  
    private Map<String, String> passwords = new HashMap<String, String>();  
  
    public PasswordHandler() {  
        passwords.put("mdmserver", "mdmserverpass");  
        passwords.put("fcs", "fcsPassword");  
    }  
  
    public void handle(Callback[] callbacks) throws IOException,  
            UnsupportedCallbackException {  
    	WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];  
        String id = pc.getIdentifier();  
        pc.setPassword((String) passwords.get(id));  
        
    }  
}  