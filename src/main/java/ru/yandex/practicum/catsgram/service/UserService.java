package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dao.UserDao;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserDao userDao;
   //private final Map<String, User> users = new HashMap();

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> findUserById(String id){
        return userDao.findUserById(id);
    }
   /* public Collection<User> findAll() {
        log.debug("Текущее количество пользователей: {}", users.size());
        return users.values();
    }

    public User create(User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("B переданных данных отсутствует адрес электронной почты");
        }
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException(
                    "Пользователь с указанным адресом электронной почты уже был добавлен ранее");
        }
        users.put(user.getEmail(), user);
        log.debug("Пользователь с указанным email ({})добавлен", user.getEmail());
        return user;
    }

    public User update(User user) throws InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("B переданных данных отсутствует адрес электронной почты");
        }
        users.put(user.getEmail(), user);
        log.debug("Данные пользователя с указанным email ({}) были обновлены.", user.getEmail());
        return user;
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }*/
}
