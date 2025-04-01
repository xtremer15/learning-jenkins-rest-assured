package org.example.auth.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthPojo {
    @JsonProperty("accessToken")
    private String accessToken;
    @JsonProperty("refreshToken")
    private  String refreshToken;
    @JsonProperty("id")
    private int id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private  String lastName;
    @JsonProperty("gender")
    private  String gender;
    @JsonProperty("image")
    private String image;
}
