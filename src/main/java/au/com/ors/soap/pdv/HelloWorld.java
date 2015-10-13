package au.com.ors.soap.pdv;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

