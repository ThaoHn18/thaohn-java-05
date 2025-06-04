package thaohn.thaohn_sample_code.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Generated;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Generated
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  UserDetailResponse implements Serializable {
    String firstName;
    String lastName;
    String email;
    String phone;

}
