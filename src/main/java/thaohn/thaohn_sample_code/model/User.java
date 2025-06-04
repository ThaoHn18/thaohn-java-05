package thaohn.thaohn_sample_code.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import thaohn.thaohn_sample_code.util.Gender;
import thaohn.thaohn_sample_code.util.UserStatus;
import thaohn.thaohn_sample_code.util.UserType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends AbstractEntity {

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    Date dateOfBirth;

    @Enumerated(EnumType.STRING)
//    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "gender")
    Gender gender;

    String phone;

    String email;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Enumerated(EnumType.STRING)
//    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "status")
    UserStatus status;

    @Enumerated(EnumType.STRING)
//    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "type")
    UserType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Address> addresses = new HashSet<>();


    public void saveAddress(Address address) {
        if (address != null) {
            if (addresses == null) {
                addresses = new HashSet<>();
            }
            addresses.add(address);
            address.setUser(this); // save user_id
        }
    }
}
