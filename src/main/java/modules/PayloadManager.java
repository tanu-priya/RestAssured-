package modules;

import com.google.gson.Gson;
import pojos.request.LoginRequest;
import pojos.response.LoginResponse;

public class PayloadManager {

    Gson gson = new Gson();

    public String createUserPayload(String email, String password) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        return gson.toJson(loginRequest);
    }

    public LoginResponse parseLoginResponse(String response) {
        return gson.fromJson(response, LoginResponse.class);
    }

}
