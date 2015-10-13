
package au.com.ors.soap.pdv;

import javax.jws.WebService;

@WebService(endpointInterface = "au.com.ors.soap.pdv.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

