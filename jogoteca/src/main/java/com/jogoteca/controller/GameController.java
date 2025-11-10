package com.jogoteca.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/games")
public class GameController {

  record Game(Long id, String title, String studio) {}
  private final Map<Long, Game> db = new LinkedHashMap<>();
  private final AtomicLong seq = new AtomicLong(1);

  public GameController() {
    // seeds
    create(new Game(null, "Hollow Knight", "Team Cherry"));
    create(new Game(null, "Celeste", "Maddy Makes Games"));
  }

  @GetMapping
  public List<Game> list() { return new ArrayList<>(db.values()); }

  @PostMapping
  public Game create(@RequestBody Game body) {
    Long id = seq.getAndIncrement();
    Game g = new Game(id, body.title(), body.studio());
    db.put(id, g);
    return g;
  }

  @PutMapping("/{id}")
  public Game update(@PathVariable Long id, @RequestBody Game body) {
    if (!db.containsKey(id)) throw new NoSuchElementException("not found");
    Game g = new Game(id, body.title(), body.studio());
    db.put(id, g);
    return g;
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) { db.remove(id); }
}
