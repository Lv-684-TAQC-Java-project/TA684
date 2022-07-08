package com.ita.speakukrainian.api.models.user;

import lombok.Data;

@Data
public class UserRequest implements UsersRequest {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private String status;
    private String roleName;
}
