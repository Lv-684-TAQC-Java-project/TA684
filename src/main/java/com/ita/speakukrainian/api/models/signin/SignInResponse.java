package com.ita.speakukrainian.api.models.signin;

import lombok.Data;

@Data
public class SignInResponse {
    private int id;
    private String email;
    private String accessToken;
}
