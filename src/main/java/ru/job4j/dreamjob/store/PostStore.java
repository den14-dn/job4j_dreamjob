package ru.job4j.dreamjob.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostStore {
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

    public Collection<Post> findAll() {
        return posts.values();
    }

    public boolean add(Post post) {
        int id = generatorId.incrementAndGet();
        post.setId(id);
        return posts.put(id, post) != null;
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public boolean update(Post post) {
        int id = post.getId();
        return posts.replace(id, post) != null;
    }
}