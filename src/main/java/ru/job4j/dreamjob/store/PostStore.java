package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PostStore {
    private static final PostStore INST = new PostStore();
    private final AtomicInteger generatorId = new AtomicInteger(0);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        int id = generatorId.incrementAndGet();
        posts.put(id, new Post(id, "Junior Java Job", "Need junior java developer"));
        id = generatorId.incrementAndGet();
        posts.put(id, new Post(id, "Middle Java Job", "Need meddle java developer"));
        id = generatorId.incrementAndGet();
        posts.put(id, new Post(id, "Senior Java Job", "Need senior java developer"));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public boolean add(Post post) {
        int id = generatorId.incrementAndGet();
        post.setId(id);
        return posts.put(id, post) != null;
    }
}