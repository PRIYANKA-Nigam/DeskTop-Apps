package login;
import java.lang.*;
import java.util.*;

public class IdAndPassword {
HashMap<String,String> logininfo = new HashMap<String,String>();

public IdAndPassword() {
	logininfo.put("Bro", "pizza");
	logininfo.put("Hi","Hello");
	logininfo.put("go", "dutch");
}

public HashMap<String, String> getLogininfo() {
	return logininfo;
}

public void setLogininfo(HashMap<String, String> logininfo) {
	this.logininfo = logininfo;
}



}
