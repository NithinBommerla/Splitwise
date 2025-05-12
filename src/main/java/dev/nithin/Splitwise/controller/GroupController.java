package dev.nithin.Splitwise.controller;

import dev.nithin.Splitwise.DTO.GroupCreateRequestDTO;
import dev.nithin.Splitwise.DTO.GroupResponseDTO;
import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dev.nithin.Splitwise.service.GroupService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity<Group> createGroup(@RequestBody GroupCreateRequestDTO requestDTO) {
        return ResponseEntity.ok(groupService.createGroup(requestDTO));
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable("id") int id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GroupResponseDTO>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        // return ResponseEntity.ok(groups);
        List<GroupResponseDTO> groupResponseDTOs = convertGroupsToResponseDTO(groups);
        return ResponseEntity.ok(groupResponseDTOs);
    }

    @GetMapping("/group/{groupId}/settleup")
    public ResponseEntity<SettleUpTransactionResponseDTO> settleUp(@PathVariable("groupId") int id) {
        return ResponseEntity.ok(groupService.getSettleUpTransactions(id));
    }

    @PutMapping("/group/{groupId}/addMember/{userId}")
    public ResponseEntity<GroupResponseDTO> addMemberToGroup(@PathVariable("groupId") int groupId, @PathVariable("userId") int userId) {
        Group group = groupService.addMemberToGroup(groupId, userId);
        // return ResponseEntity.ok(group);
        return ResponseEntity.ok(GroupResponseDTO.from(group));
    }

    @PutMapping("/group/{groupId}/addMembers")
    public ResponseEntity<GroupResponseDTO> addMembersToGroup(@PathVariable("groupId") int groupId, @RequestBody List<Integer> userIds) {
        Group group = groupService.addMembersToGroup(groupId, userIds);
        // return ResponseEntity.ok(group);
        return ResponseEntity.ok(GroupResponseDTO.from(group));
    }

    private List<GroupResponseDTO> convertGroupsToResponseDTO(List<Group> groups) {
        // return groups.stream().map(GroupResponseDTO::from).toList();
        List<GroupResponseDTO> groupResponseDTOs = new ArrayList<>();
        for (Group group : groups) {
            groupResponseDTOs.add(GroupResponseDTO.from(group));
        }
        return groupResponseDTOs;
    }
}
