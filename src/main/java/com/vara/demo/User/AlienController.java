package com.vara.demo.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/aliens")
public class AlienController {
    private AlienRepository alienRepository;
    public AlienController(AlienRepository alienRepository) {
        this.alienRepository = alienRepository;
    }
    @GetMapping("/")
    public List<Alien> getAliens() {
        return this.alienRepository.findAll();
    }
    @PostMapping("/")
    public Alien createAlien(@RequestBody Alien alien) {
        // make some validations
        return this.alienRepository.save(alien);
    }
}
