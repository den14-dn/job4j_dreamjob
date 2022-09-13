package ru.job4j.dreamjob.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CandidateStore {
    private final AtomicInteger generatorId = new AtomicInteger(0);
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        int id = generatorId.incrementAndGet();
        candidates.put(id, new Candidate(id, "Developer 1", "I am junior developer"));
        id = generatorId.incrementAndGet();
        candidates.put(id, new Candidate(id, "Developer 2", "I am senior developer"));
        id = generatorId.incrementAndGet();
        candidates.put(id, new Candidate(id, "Developer 3", "I am junior developer"));
        id = generatorId.incrementAndGet();
        candidates.put(id, new Candidate(id, "Developer 4", "I am middle developer"));
        id = generatorId.incrementAndGet();
        candidates.put(id, new Candidate(id, "Developer 5", "I am junior developer"));
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public boolean add(Candidate candidate) {
        int id = generatorId.incrementAndGet();
        candidate.setId(id);
        return candidates.put(id, candidate) != null;
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public boolean update(Candidate candidate) {
        int id = candidate.getId();
        return candidates.replace(id, candidate) != null;
    }

}