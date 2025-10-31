package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PokemonTO {
    // atributos
    private Long codigo;
    @NotBlank
    private String nomePokemon;
    @NotNull
    private Double alturaPokemon;
    @NotNull
    private Double pesoPokemon;
    @NotBlank
    private String categoria;
    @PastOrPresent
    private LocalDate dataDeCaptura;
    //construtores
    public PokemonTO() {
    }

    public PokemonTO(Long codigo, String nomePokemon, Double alturaPokemon, Double pesoPokemon, String categoria, LocalDate dataDeCaptura) {
        this.codigo = codigo;
        this.nomePokemon = nomePokemon;
        this.alturaPokemon = alturaPokemon;
        this.pesoPokemon = pesoPokemon;
        this.categoria = categoria;
        this.dataDeCaptura = dataDeCaptura;
    }
    //getter e setter
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public Double getAlturaPokemon() {
        return alturaPokemon;
    }

    public void setAlturaPokemon(Double alturaPokemon) {
        this.alturaPokemon = alturaPokemon;
    }

    public Double getPesoPokemon() {
        return pesoPokemon;
    }

    public void setPesoPokemon(Double pesoPokemon) {
        this.pesoPokemon = pesoPokemon;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataDeCaptura() {
        return dataDeCaptura;
    }

    public void setDataDeCaptura(LocalDate dataDeCaptura) {
        this.dataDeCaptura = dataDeCaptura;
    }
}
