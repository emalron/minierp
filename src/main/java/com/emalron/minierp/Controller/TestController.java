package com.emalron.minierp.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.emalron.minierp.Entity.TestItem;
import com.emalron.minierp.Repository.TestRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
  private final TestRepository repository;

    @GetMapping("/save")
    public String save(@RequestParam(defaultValue = "hello") String name) {
        TestItem item = new TestItem();
        item.setName(name);
        repository.save(item);
        return "✅ Saved: " + name;
    }

    @GetMapping("/list")
    public List<TestItem> list() {
        return repository.findAll();
    }
}