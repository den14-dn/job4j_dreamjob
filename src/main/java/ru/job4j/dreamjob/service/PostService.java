package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.store.PostStore;

import java.util.List;

@Service
@ThreadSafe
public class PostService {
    private final PostStore store;

    public PostService(PostStore store) {
        this.store = store;
    }

    public List<Post> findAll() {
        return store.findAll().stream().toList();
    }

    public boolean add(Post post) {
        return store.add(post);
    }

    public Post findById(int id) {
        return store.findById(id);
    }

    public boolean update(Post post) {
        return store.update(post);
    }
}
