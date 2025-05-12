package dev.nithin.Splitwise.DTO;

import dev.nithin.Splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;

    public static UserResponseDTO from(User user){
        UserResponseDTO userResponseDto = new UserResponseDTO();
        userResponseDto.userId = user.getId();
        userResponseDto.name = user.getFirstName() + " " + user.getLastName();
        userResponseDto.email = user.getEmail();
        userResponseDto.phoneNumber = user.getPhone();
        return userResponseDto;
    }
}
