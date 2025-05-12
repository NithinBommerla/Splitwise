package dev.nithin.Splitwise.service;

import dev.nithin.Splitwise.DTO.GroupCreateRequestDTO;
import dev.nithin.Splitwise.DTO.SettleUpTransactionResponseDTO;
import dev.nithin.Splitwise.exception.GroupNotFoundException;
import dev.nithin.Splitwise.exception.UserAlreadyExistsInGroupException;
import dev.nithin.Splitwise.exception.UserNotFoundException;
import dev.nithin.Splitwise.model.Expense;
import dev.nithin.Splitwise.model.Group;
import dev.nithin.Splitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.nithin.Splitwise.repository.GroupRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Group getGroupById(Integer id) throws GroupNotFoundException {
        return groupRepository.findById(id).orElseThrow(
                () -> new GroupNotFoundException("Group Not found with id :" +id)
        );
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group addExpenseToGroup(Integer groupId, Expense expense) throws GroupNotFoundException {
        Group group = getGroupById(groupId);
        List<Expense> expenses = group.getExpenses();
        expenses.add(expense);
        group.setExpenses(expenses);
        return groupRepository.save(group);
    }

    public SettleUpTransactionResponseDTO getSettleUpTransactions(Integer groupId) {
        return null;
    }

    public Group addMembersToGroup(Integer groupId, List<Integer> userIds) throws GroupNotFoundException, UserNotFoundException {
        for(Integer userId : userIds) {
            if(isUserAlreadyPartOfGroup(userId, groupId))
                throw new UserAlreadyExistsInGroupException("User with userId: "+userId+" already present in the group, Couldn't add any user to the group");
        }
        for(Integer userId : userIds) {
            addMemberToGroup(groupId, userId);
        }
        Group group = getGroupById(groupId);
        return groupRepository.save(group);
    }

    public Group addMemberToGroup(int groupId, int userId) throws GroupNotFoundException, UserNotFoundException, UserAlreadyExistsInGroupException {
        Group group = getGroupById(groupId);
        User user = userService.findByID(userId);
        List<User> members = group.getMembers();
        if(isUserAlreadyPartOfGroup(userId, groupId)) {
            throw new UserAlreadyExistsInGroupException("User already present in the group");
        }
        members.add(user);
        group.setMembers(members);
        group.setUpdatedAt(LocalDateTime.now());
        return groupRepository.save(group);
    }

    private Set<Integer> getAllGroupMembers(int groupId) {
        Group group = getGroupById(groupId);
        Set<Integer> membersIds = new HashSet<>();
        for(User user : group.getMembers()) {
            membersIds.add(user.getId());
        }
        return membersIds;
    }

    private boolean isUserAlreadyPartOfGroup(int userId, int groupId) {
        Set<Integer> membersIds = getAllGroupMembers(groupId);
        return membersIds.contains(userId);
    }

}
