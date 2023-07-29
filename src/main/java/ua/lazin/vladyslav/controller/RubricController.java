package ua.lazin.vladyslav.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ua.lazin.vladyslav.entity.Rubric;
import ua.lazin.vladyslav.service.impl.RubricServiceImpl;

import java.util.List;

@RestController
@RequestMapping("rubric/rubrics")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RubricController {
    RubricServiceImpl service;

    @PostMapping
    public void save(@RequestBody Rubric rubric) {
        service.save(rubric);
    }
    @PutMapping
    public void update(@RequestBody Rubric rubric) {
        service.update(rubric);
    }

    @GetMapping("/{id}")
    public Rubric findById(@PathVariable(value = "id") int id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<Rubric> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") int id) {
        service.deleteById(id);
    }
}
