package com.revature.FullStackTestServer.beans.controllers;

import com.revature.FullStackTestServer.beans.services.TestService;
import com.revature.FullStackTestServer.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    TestService testService;

    @Autowired
    public TestController(TestService testService) {
        System.out.println("TestController Constructor...");
        this.testService = testService;
    }

    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/post")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void postNewModel(@RequestBody TestModel model) {
        System.out.println("postNewModel()");
        this.testService.createNew(model);
    }


    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/get")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<TestModel> getModels() {
        System.out.println("getModels()");
        List<TestModel> list = this.testService.getModels();
//        for(TestModel model : list) {
//            System.out.println(model.getMessage());
//        }
        return list;
    }
}
