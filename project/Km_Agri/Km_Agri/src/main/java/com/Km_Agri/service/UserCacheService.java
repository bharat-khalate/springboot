package com.Km_Agri.service;

import com.Km_Agri.dto.UserDto;
import com.Km_Agri.entities.Room;
import com.Km_Agri.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCacheService {

    private final RedisTemplate<String, UserDto> redisTemplate;

    public void saveUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAuth(user.getAuth().getId());
        if (user.getExpert() != null && user.getExpert().getId() != null) userDto.setExpert(user.getExpert().getId());
        userDto.setStatus(user.getStatus());
        userDto.setPhoneNo(user.getPhoneNo());
        userDto.setLastSeen(user.getLastSeen());
        userDto.setProfilePicture(user.getProfilePicture());
        List<Long> idList = new ArrayList<>();
        for (Room room : user.getRoomList()) {
            idList.add(room.getRoomId());
        }
        userDto.setRoomList(idList);
        redisTemplate.opsForValue().set("user:" + user.getId(), userDto, Duration.ofMinutes(3));
    }

    public UserDto getUser(Long userId) {
        return redisTemplate.opsForValue().get("user:" + userId);
    }

    public boolean isUserCached(Long userId) {
        return redisTemplate.hasKey("user:" + userId);
    }

    public void deleteUser(Long userId) {
        redisTemplate.delete("user:" + userId);
    }
}
