package thaohn.thaohn_sample_code.service.impl;

import org.springframework.stereotype.Service;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;
import thaohn.thaohn_sample_code.exception.ResourceNotFoundException;
import thaohn.thaohn_sample_code.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(UserRequestDTO userRequestDTO) {
        System.out.printf("addUser: userRequestDTO=%s\n", userRequestDTO);
        if(userRequestDTO.getFirstName().equals("Thao")) {
            throw  new ResourceNotFoundException("Loi roi ban oi");
        }
        return 0;
    }
}
