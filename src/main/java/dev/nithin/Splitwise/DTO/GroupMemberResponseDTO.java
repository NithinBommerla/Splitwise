package dev.nithin.Splitwise.DTO;

import dev.nithin.Splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupMemberResponseDTO {
    private String name;
//    private String email;
//    private String phoneNumber;

    public static GroupMemberResponseDTO from(User user){
        GroupMemberResponseDTO groupMemberResponseDTO = new GroupMemberResponseDTO();
        groupMemberResponseDTO.name = user.getFirstName() + " " + user.getLastName();
//        groupMemberResponseDTO.email = user.getEmail();
//        groupMemberResponseDTO.phoneNumber = user.getPhone();
        return groupMemberResponseDTO;
    }
}
