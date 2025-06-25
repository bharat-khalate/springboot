package com.Km_Agri.service;

import com.Km_Agri.dto.UserDto;
import com.Km_Agri.entities.Auth;
import com.Km_Agri.entities.Expert;
import com.Km_Agri.entities.Room;
import com.Km_Agri.entities.User;
import com.Km_Agri.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserCacheService userCacheService;


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUserById(Long id) {
        if (userCacheService.isUserCached(id)) {
            UserDto userDto = userCacheService.getUser(id);
            Auth auth = new Auth();
            auth.setId(userDto.getId());
            List<Room> idList = new ArrayList<>();
            for (Long roomId : userDto.getRoomList()) {
                Room room = new Room();
                room.setRoomId(roomId);
                idList.add(room);
            }
            Expert expert = new Expert();
            expert.setId(userDto.getExpert());
            User user = new User(userDto.getId(), userDto.getPhoneNo(), userDto.getProfilePicture(), userDto.getStatus(), userDto.getLastSeen(), auth, expert, idList);
            return user;
        }
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("no user fount with id" + id));
        userCacheService.saveUser(user);
        return user;
    }

    public User updateUserById(Long userId, User newUser) {
        newUser.setId(userId);
        return userRepository.save(newUser);
    }

    public boolean deleteUserById(Long userId) {
        this.getUserById(userId);
        if (userCacheService.isUserCached(userId)) userCacheService.deleteUser(userId);
        userRepository.deleteById(userId);
        return true;
    }
}
