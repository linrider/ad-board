package ua.lazin.vladyslav.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ua.lazin.vladyslav.entity.Ad;
import ua.lazin.vladyslav.entity.Author;
import ua.lazin.vladyslav.service.impl.AuthorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("author/authors/*")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorController {
    AuthorServiceImpl service;

    @PostMapping
    public void save(@RequestBody Author author) {
        service.save(author);
    }
    @PutMapping
    public void update(@RequestBody Author author) {
        service.save(author);
    }

    @GetMapping
    public String greeterController() {
        return "Hello, this is ad board!";
    }

    @GetMapping("{id}")
    public Author findById(@PathVariable(value = "id") int id) {
        return service.findById(id);
    }

    @GetMapping("all")
    public List<Author> findAll() {
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") int id) {
        service.deleteById(id);
    }
}
