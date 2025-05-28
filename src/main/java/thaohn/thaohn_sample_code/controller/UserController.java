package thaohn.thaohn_sample_code.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User add ";
    }


    @PutMapping("/{userId}")
    public String updateUser( @PathVariable("userId") int id ,@Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update uswerId="+id);
        return "User update ";
    }

    @PatchMapping("/{userId}")
    public String patchUser( @PathVariable("userId") int id , @RequestParam(required = false) boolean status) {
        return "User status changed ";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable("userId") int id) {
        System.out.printf("User deleted with id=%d\n", id);
        return "User deleted ";

    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable("userId") int userid) {
        System.out.printf("User found with id=%d\n", userid);
        return new UserRequestDTO("thao", "java","phone","email");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(@RequestParam(required = false) String email,@RequestParam(defaultValue ="0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return List.of(new UserRequestDTO("thao", "java","phone","email")
        ,new UserRequestDTO("thao1", "java","phone","email"));
    }
}
