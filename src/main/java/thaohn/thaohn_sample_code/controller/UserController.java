package thaohn.thaohn_sample_code.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import thaohn.thaohn_sample_code.configuration.Translator;
import thaohn.thaohn_sample_code.dto.request.UserRequestDTO;
import thaohn.thaohn_sample_code.dto.response.ResponseData;
import thaohn.thaohn_sample_code.dto.response.ResponseError;
import thaohn.thaohn_sample_code.dto.response.ResponseSuccess;
import thaohn.thaohn_sample_code.service.UserService;


import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
@Tag(name = "User Controller")
public class UserController {
    @Autowired
    private UserService userService;

//    @Operation(summary = "", description = "create user", responses = {@ApiResponse(responseCode = "201", description = "", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(name = "ex name", summary = "111", value = """
//            {
//                "status": 201,
//                "message": "User added successfully",
//                "data": 1
//            }
//            """)))})

    @PostMapping("/")
    @Operation(summary = "Add user", description = "Create new user")
    public ResponseData<?> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        try {
            long userId=userService.saveUser(userDTO);
            return new ResponseData(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), userId);
        } catch (Exception e) {
            log.error("errorMessage",e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }

    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable("userId")  @Min(1) int id ,@Valid @RequestBody UserRequestDTO userDTO) {
        log.info("Request update uswerId= {}", userDTO.getLastName());
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.add.success"), 1);
    }

    @PatchMapping("/{userId}")
    public ResponseSuccess patchUser( @PathVariable("userId") int id , @RequestParam(required = false) boolean status) {
        return new ResponseSuccess(HttpStatus.ACCEPTED, Translator.toLocale("user.upd.success"), 1);
    }

    @DeleteMapping("/{userId}")
    public ResponseSuccess deleteUser(@Min(1) @PathVariable("userId") int id) {
        log.info("User deleted with id={}", id);
        return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted successfully", null);

    }

    @GetMapping("/{userId}")
    public ResponseSuccess getUser(@PathVariable("userId") int userid) {
       log.info("User found with id={}", userid);

        return new ResponseSuccess(HttpStatus.OK,"get user",new UserRequestDTO("thao", "java","phone","email"));
    }

    @GetMapping("/list")
    public ResponseSuccess getAllUsers(@RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseSuccess(HttpStatus.OK, "get all users", List.of(new UserRequestDTO("thao", "java", "phone", "email")
                , new UserRequestDTO("thao1", "java", "phone", "email")));
    }
}
