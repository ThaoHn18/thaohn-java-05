package thaohn.thaohn_sample_code.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;
import thaohn.thaohn_sample_code.dto.response.ResponseData;
import thaohn.thaohn_sample_code.dto.response.ResponseError;
import thaohn.thaohn_sample_code.dto.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Operation(summary = "", description = "create user", responses = {@ApiResponse(responseCode = "201", description = "", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(name = "ex name", summary = "111", value = """
//            {
//                "status": 201,
//                "message": "User added successfully",
//                "data": 1
//            }
//            """)))})
    @PostMapping("/")
    public ResponseData<?> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
//        return new ResponseData(HttpStatus.CREATED.value(), "User added successfully", 1);
        return new ResponseError(HttpStatus.BAD_REQUEST.value(),"Cannot create user");
    }


    @PutMapping("/{userId}")
    public ResponseSuccess updateUser( @PathVariable("userId") int id ,@Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update uswerId="+id);
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully", 1);
    }

    @PatchMapping("/{userId}")
    public ResponseSuccess patchUser( @PathVariable("userId") int id , @RequestParam(required = false) boolean status) {
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User cahnged successfully", 1);
    }

    @DeleteMapping("/{userId}")
    public ResponseSuccess deleteUser(@Min(1) @PathVariable("userId") int id) {
        System.out.printf("User deleted with id=%d\n", id);
        return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted successfully", null);

    }

    @GetMapping("/{userId}")
    public ResponseSuccess getUser(@PathVariable("userId") int userid) {
        System.out.printf("User found with id=%d\n", userid);

        return new ResponseSuccess(HttpStatus.OK,"get user",new UserRequestDTO("thao", "java","phone","email"));
    }

    @GetMapping("/list")
    public ResponseSuccess getAllUsers(@RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseSuccess(HttpStatus.OK, "get all users", List.of(new UserRequestDTO("thao", "java", "phone", "email")
                , new UserRequestDTO("thao1", "java", "phone", "email")));
    }
}
