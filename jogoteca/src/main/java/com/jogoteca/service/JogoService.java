package com.jogoteca.service;
import com.jogoteca.domain.Jogo;
import com.jogoteca.repository.JogoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JogoService {
    private final JogoRepository repo;
    public JogoService(JogoRepository repo){this.repo=repo;}
    public List<Jogo> listar(String q){return (q==null||q.isBlank())?repo.findAll():repo.findByTituloContainingIgnoreCase(q);}
    public Jogo buscar(Long id){return repo.findById(id).orElseThrow(()->new RuntimeException("Jogo não encontrado"));}
    public Jogo criar(Jogo j){return repo.save(j);}
    public Jogo atualizar(Long id,Jogo j){Jogo atual=buscar(id);atual.setTitulo(j.getTitulo());atual.setPlataforma(j.getPlataforma());atual.setPreco(j.getPreco());atual.setLancamento(j.getLancamento());atual.setGenero(j.getGenero());atual.setEstoque(j.getEstoque());return repo.save(atual);}
    public void remover(Long id){repo.deleteById(id);}
}