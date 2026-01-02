package pojos.response;

public class LoginResponse {

	public String accessToken;

	public LoginResponse() {
		
	}
	
	public LoginResponse(String accessToken ) {
		this.accessToken = accessToken;	
	}
	
	public  String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
