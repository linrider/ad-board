package ua.lazin.vladyslav.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import ua.lazin.vladyslav.entity.Ad;
import ua.lazin.vladyslav.service.impl.AdServiceImpl;

import java.util.List;

@RestController
@RequestMapping("ad/ads")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdController {
    AdServiceImpl service;
    @PostMapping
    public void save(@RequestBody Ad ad) {
        service.save(ad);
    }
    @PutMapping
    public void update(@RequestBody Ad ad) {
        service.update(ad);
    }

    @GetMapping("/{id}")
    public Ad findById(@PathVariable(value = "id") int id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<Ad> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") int id) {
        service.deleteById(id);
    }
}
