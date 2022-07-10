package com.ita.speakukrainian.api.models.user;

import lombok.Data;

@Data
public class CreatedUserRequest implements UsersRequest{
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String roleName;
    public Object urlLogo;
    public boolean status;
}
