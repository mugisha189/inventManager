package com.example.inventManager.services.serviceImpl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.inventManager.dto.requests.CreateUserDTO;
import com.example.inventManager.models.User;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.repositories.UserRepository;
import com.example.inventManager.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> getUserById(UUID userId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            if (user == null)
                throw new BadRequestException("The user with the provided id is not found");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse(true, "The user retrieved successfully", user));
        } catch (BadRequestException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, exception.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse> createUser(CreateUserDTO createUserDTO) { 
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        User user = new User(createUserDTO.getUsername(), createUserDTO.getPassword(), createUserDTO.getEmail())
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}