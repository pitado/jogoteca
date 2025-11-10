package com.jogoteca.api;
import com.jogoteca.domain.Jogo;
import com.jogoteca.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/jogos")
@CrossOrigin
public class JogoController {
    private final JogoService service;
    public JogoController(JogoService service){this.service=service;}
    @GetMapping public List<Jogo> listar(@RequestParam(value="q",required=false)String q){return service.listar(q);}
    @GetMapping("/{id}") public Jogo buscar(@PathVariable Long id){return service.buscar(id);}
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Jogo criar(@Valid @RequestBody Jogo j){return service.criar(j);}
    @PutMapping("/{id}") public Jogo atualizar(@PathVariable Long id,@Valid @RequestBody Jogo j){return service.atualizar(id,j);}
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void remover(@PathVariable Long id){service.remover(id);}
}