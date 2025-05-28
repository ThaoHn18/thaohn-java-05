package thaohn.thaohn_sample_code.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import thaohn.thaohn_sample_code.util.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @Pattern(regexp = "^ACTIVE|INACTIVE|NONE$", message = "status must be one in {ACTIVE, INACTIVE, NONE}")
    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;
    @GenderSubset(anyOf ={Gender.FEMALE,Gender.MALE,Gender.OTHER} )
    private Gender  gender;

    @NotNull(message = "type not null")
    @EnumValue(name = "type", enumClass = UserType.class)
    private String type;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRequestDTO(String firstName, String email, String lastName, String phone) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
