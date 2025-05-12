package dev.nithin.Splitwise.controller;

import dev.nithin.Splitwise.DTO.GroupCreateRequestDTO;
import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dev.nithin.Splitwise.service.GroupService;

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

    @GetMapping("/group/{groupId}/settleup")
    public ResponseEntity<SettleUpTransactionResponseDTO> settleUp(@PathVariable("groupId") int id) {
        return ResponseEntity.ok(groupService.getSettleUpTransactions(id));
    }
}
