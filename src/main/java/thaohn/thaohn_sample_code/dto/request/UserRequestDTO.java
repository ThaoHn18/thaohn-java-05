package thaohn.thaohn_sample_code.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import thaohn.thaohn_sample_code.util.PhoneNumber;

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
}
