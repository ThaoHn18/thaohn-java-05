package thaohn.thaohn_sample_code.service;

import org.springframework.stereotype.Service;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;

@Service
public interface UserService {
    int addUser(UserRequestDTO userRequestDTO);
}
