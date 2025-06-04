package thaohn.thaohn_sample_code.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thaohn.thaohn_sample_code.dto.request.AddressDTO;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;
import thaohn.thaohn_sample_code.dto.response.UserDetailResponse;
import thaohn.thaohn_sample_code.exception.ResourceNotFoundException;
import thaohn.thaohn_sample_code.model.Address;
import thaohn.thaohn_sample_code.model.User;
import thaohn.thaohn_sample_code.repository.UserRepository;
import thaohn.thaohn_sample_code.service.UserService;
import thaohn.thaohn_sample_code.util.UserType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public long saveUser(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .firstName(userRequestDTO.getFirstName())
                .lastName(userRequestDTO.getLastName())
                .dateOfBirth(userRequestDTO.getDateOfBirth())
                .gender(userRequestDTO.getGender())
                .phone(userRequestDTO.getPhone())
                .email(userRequestDTO.getEmail())
                .username(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .status(userRequestDTO.getStatus())
                .type(UserType.valueOf(userRequestDTO.getType().toUpperCase()))
                .build();

        userRequestDTO.getAddresses().forEach(a ->
                user.saveAddress(Address.builder()
                        .apartmentNumber(a.getApartmentNumber())
                        .floor(a.getFloor())
                        .building(a.getBuilding())
                        .streetNumber(a.getStreetNumber())
                        .street(a.getStreet())
                        .city(a.getCity())
                        .country(a.getCountry())
                        .addressType(a.getAddressType())
                        .build()));
        log.info("user saved");
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDTO userRequestDTO) {
        User user = getUserById(userId);
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setDateOfBirth(userRequestDTO.getDateOfBirth());
        user.setGender(userRequestDTO.getGender());
        user.setPhone(userRequestDTO.getPhone());
        user.setEmail(userRequestDTO.getEmail());
        if(!userRequestDTO.getEmail().equals(user.getEmail())) {
            user.setEmail(userRequestDTO.getEmail());
        }
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(userRequestDTO.getPassword());
        user.setStatus(userRequestDTO.getStatus());
        user.setType(UserType.valueOf(userRequestDTO.getType().toUpperCase()));
        user.setAddresses(convertToAddress(userRequestDTO.getAddresses()));
        userRepository.save(user);
        log.info("user updated");


    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
        log.info("user deleted, userId={}", userId);

    }

    @Override
    public void changeStatus(long userId, UserRequestDTO userRequestDTO) {
        User user = getUserById(userId);
        user.setStatus(userRequestDTO.getStatus());
        userRepository.save(user);
        log.info("user updated userId={}, status={}", userId, userRequestDTO.getStatus());

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        User user = getUserById(userId);
        return UserDetailResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();

    }

    @Override
    public List<UserDetailResponse> getAllUsers(int pageNo, int pagesize) {
        return List.of();
    }

    private Set<Address> convertToAddress(Set<AddressDTO> addresses) {
        Set<Address> result = new HashSet<>();
        addresses.forEach(a ->
                result.add(Address.builder()
                        .apartmentNumber(a.getApartmentNumber())
                        .floor(a.getFloor())
                        .building(a.getBuilding())
                        .streetNumber(a.getStreetNumber())
                        .street(a.getStreet())
                        .city(a.getCity())
                        .country(a.getCountry())
                        .addressType(a.getAddressType())
                        .build())
        );
        return result;
    }

    private User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
    }
}
