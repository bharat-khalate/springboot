package com.Km_Agri.service;

import com.Km_Agri.entities.Group;
import com.Km_Agri.entities.Room;
import com.Km_Agri.entities.User;
import com.Km_Agri.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final RoomService roomService;
    private final UserService userService;

    public Group addGroup(Group group) {
        Room room = roomService.getRoomById(group.getRoom().getRoomId());
        User user = userService.getUserById(group.getUser().getId());
        group.setRoom(room);
        return groupRepository.save(group);
    }

    public List<Group> getALlGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupByGroupId(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(() -> new NoSuchElementException("No Group with the id found"));
    }

    public Group updateGroupById(Long groupId, Group group) {
        Group oldGroup = this.getGroupByGroupId(groupId);
        if (group.getProfile() != null) oldGroup.setProfile(group.getProfile());
        if (group.getValidity() != null) oldGroup.setValidity(group.getValidity());
        return groupRepository.save(oldGroup);
    }

    public boolean deleteGroup(Long groupId) {
        this.getGroupByGroupId(groupId);
        groupRepository.deleteById(groupId);
        return true;
    }

}
