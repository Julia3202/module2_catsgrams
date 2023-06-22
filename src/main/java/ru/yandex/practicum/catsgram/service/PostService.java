package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exception.PostNotFoundException;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostService {
    private final UserService userService;
    private final List<Post> posts = new ArrayList<>();
    private static Integer postId = 0;

    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    public List<Post> findAll() {
        log.debug("Текущее количество постов: {}", posts.size());
        return posts;
    }

    private static Integer createId() {
        return postId++;
    }

    public Post create(Post post) throws UserNotFoundException {
        User author = userService.findUserByEmail(post.getAuthor());
        if (author == null) {
            throw new UserNotFoundException("Пользователь " + post.getAuthor() + " не найден.");
        }
        post.setId(createId());
        posts.add(post);
        log.debug("Пост автора ({}) был добавлен", post.getAuthor());
        return post;
    }

    public Post findPostById(Integer postId) {
        return posts.stream()
                .filter(post -> post.getId().equals(postId))
                .findFirst()
                .orElseThrow(() -> new PostNotFoundException("Пост с ID-" + postId + " не был найден."));
    }
}
