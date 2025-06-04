package thaohn.thaohn_sample_code.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import thaohn.thaohn_sample_code.util.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Getter
public class UserRequestDTO  implements Serializable {
    @NotBlank(message = "firstName must be not blank")
    private  String firstName;
    @NotNull(message = "latsName must be not null")
    private  String lastName;
    @Email(message ="Email invalid format" )
    private  String email;
    @PhoneNumber
    private  String phone;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;
    @NotEmpty
    List<String> permissions;
    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;
    @GenderSubset(anyOf ={Gender.FEMALE,Gender.MALE,Gender.OTHER} )
    private Gender  gender;

    @NotNull(message = "type not null")
    @EnumValue(name = "type", enumClass = UserType.class)
    private String type;
    private String username;
    private String password;
    private Set<AddressDTO> addresses;


    public UserRequestDTO(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }


}
