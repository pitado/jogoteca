package com.jogoteca.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "jogos")
public class Jogo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String titulo;
    @NotBlank private String plataforma;
    @NotNull private BigDecimal preco;
    private LocalDate lancamento;
    private String genero;
    private Integer estoque = 0;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getTitulo(){return titulo;} public void setTitulo(String t){this.titulo=t;}
    public String getPlataforma(){return plataforma;} public void setPlataforma(String p){this.plataforma=p;}
    public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal p){this.preco=p;}
    public LocalDate getLancamento(){return lancamento;} public void setLancamento(LocalDate l){this.lancamento=l;}
    public String getGenero(){return genero;} public void setGenero(String g){this.genero=g;}
    public Integer getEstoque(){return estoque;} public void setEstoque(Integer e){this.estoque=e;}
}