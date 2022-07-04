package com.ita.speakukrainian.api.models.signup;

import lombok.Data;

@Data
public class SignupRequest {
    public int id;
    public String email;
    public String firstName;
    public String lastName;
    public String phone;
    public String password;
    public String roleName;
}
