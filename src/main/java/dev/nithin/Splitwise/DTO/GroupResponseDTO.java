package dev.nithin.Splitwise.DTO;

import dev.nithin.Splitwise.model.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GroupResponseDTO {
    private int groupId;
    private String name;
    private String description;
    private GroupMemberResponseDTO creator;
    private String createdAt;
    private String updatedAt;
    private List<GroupMemberResponseDTO> members;

    public static GroupResponseDTO from(Group group) {
        GroupResponseDTO groupResponseDto = new GroupResponseDTO();
        groupResponseDto.groupId = group.getId();
        groupResponseDto.name = group.getGroupName();
        groupResponseDto.description = group.getDescription();
        groupResponseDto.creator = GroupMemberResponseDTO.from(group.getCreatedBy());
        groupResponseDto.createdAt = String.valueOf(group.getCreatedAt());
        groupResponseDto.updatedAt = String.valueOf(group.getUpdatedAt());
        groupResponseDto.members = group.getMembers().stream().map(GroupMemberResponseDTO::from).toList();
        return groupResponseDto;
    }
}
