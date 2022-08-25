package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CandidateStore {
    private static final CandidateStore INST = new CandidateStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Developer 1", "I am junior developer"));
        candidates.put(2, new Candidate(2, "Developer 2", "I am senior developer"));
        candidates.put(3, new Candidate(3, "Developer 3", "I am junior developer"));
        candidates.put(4, new Candidate(4, "Developer 4", "I am middle developer"));
        candidates.put(5, new Candidate(5, "Developer 5", "I am junior developer"));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public boolean add(Candidate candidate) {
        return candidates.put(candidate.getId(), candidate) != null;
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public boolean update(Candidate candidate) {
        int id = candidate.getId();
        return candidates.put(id, candidate) != null;
    }

}