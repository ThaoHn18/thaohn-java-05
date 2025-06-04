package thaohn.thaohn_sample_code.service;

import org.springframework.stereotype.Service;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;
import thaohn.thaohn_sample_code.dto.response.UserDetailResponse;

import java.util.List;

@Service
public interface UserService {
    long saveUser(UserRequestDTO userRequestDTO);
    void updateUser(long userId, UserRequestDTO userRequestDTO);
    void deleteUser(long userId);
    void changeStatus(long userId, UserRequestDTO userRequestDTO);
    UserDetailResponse getUser(long userId);

    List<UserDetailResponse> getAllUsers(int pageNo, int pagesize);

}
