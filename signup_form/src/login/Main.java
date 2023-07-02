package login;

public class Main {
	
	
	public static void main(String[] args) {
		IdAndPassword idp =new IdAndPassword();
		login_page lp = new login_page(idp.getLogininfo());
	
}

}
