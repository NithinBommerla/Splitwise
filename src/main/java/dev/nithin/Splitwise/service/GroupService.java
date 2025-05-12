package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.DTO.GroupCreateRequestDTO;
import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.exception.GroupNotFoundException;
import dev.nithin.Splitwise.model.Expense;
import dev.nithin.Splitwise.model.Group;
import dev.nithin.Splitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nithin.Splitwise.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    public Group createGroup(GroupCreateRequestDTO requestDTO) {
        Group group = new Group();
        group.setGroupName(requestDTO.getName());
        group.setTotalAmountSpent(0);
        group.setAllSettledUp(false);

        User createdBy = userService.findByID(requestDTO.getCreatorId());
        group.setCreatedBy(createdBy);

        List<User> members = new ArrayList<>();

        for(Integer userId : requestDTO.getUserIDs()) {
            User user = userService.findByID(userId);
            members.add(user);
        }
        group.setMembers(members);

        return groupRepository.save(group);
    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException("Group Not found with id :" +id)
        );
    }

    public Group addExpenseToGroup(Integer groupId, Expense expense) {
        Group group = getGroupById(groupId);
        List<Expense> expenses = group.getExpenses();
        expenses.add(expense);
        group.setExpenses(expenses);
        return groupRepository.save(group);
    }

    public SettleUpTransactionResponseDTO getSettleUpTransactions(Integer groupId) {
        return null;
    }

//    public Group AddMembersToGroup(List<Integer> userIds, Integer groupId) {
//        Group group = getGroupById(groupId);
//        for(Integer userId : userIds) {
//            User user = userService.findByID(userId);
//            group.getMembers().add(user);
//        }
//    }
}
