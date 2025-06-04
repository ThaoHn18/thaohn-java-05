package thaohn.thaohn_sample_code.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import thaohn.thaohn_sample_code.model.User;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class AddressDTO {
    String apartmentNumber;

    String floor;

    String building;

    String streetNumber;

    String street;

    String city;

    String country;

    Integer addressType;
}
