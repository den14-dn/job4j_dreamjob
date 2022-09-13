package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.store.CandidateStore;

import java.util.List;

@Service
@ThreadSafe
public class CandidateService {
    private final CandidateStore store;

    public CandidateService(CandidateStore store) {
        this.store = store;
    }

    public List<Candidate> findAll() {
        return store.findAll().stream().toList();
    }

    public void add(Candidate candidate) {
        store.add(candidate);
    }
}
