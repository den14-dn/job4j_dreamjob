package ru.job4j.dreamjob.service;

import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.store.PostStore;

import java.util.List;

public class PostService {
    private final PostStore store = PostStore.instOf();

    public List<Post> findAll() {
        return store.findAll().stream().toList();
    }
}
