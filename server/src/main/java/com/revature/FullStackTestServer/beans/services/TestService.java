package com.revature.FullStackTestServer.beans.services;

import com.revature.FullStackTestServer.beans.repositories.TestRepository;
import com.revature.FullStackTestServer.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        System.out.println("TestService Constructor...");
        this.testRepository = testRepository;
    }

    public void createNew(TestModel model) {
        this.testRepository.save(model);
    }

    public List<TestModel> getModels() {
        return this.testRepository.findAll();
    }
}
