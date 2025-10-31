package br.com.fiap.bo;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.to.PokemonTO;

import java.util.ArrayList;

public class PokemonBO {
    private PokemonDAO pokemonDAO;

    public ArrayList<PokemonTO> findAll() {
        pokemonDAO = new PokemonDAO();
        // aqui se implementa a regra de negócios
        return pokemonDAO.findAll();
    }

    public PokemonTO findByCodigo(Long codigo) {
        pokemonDAO = new PokemonDAO();
        // aqui se implementa a regra de negócios
        return pokemonDAO.findByCodigo(codigo);
    }

    public PokemonTO save (PokemonTO remedio) {
        pokemonDAO = new PokemonDAO();
        // aqui se implementa a regra de negócios
        // verificando se o remédio já está vencido
        /*if (remedio.getDataDeValidade().isBefore(LocalDate.now())) {
            return null;
        }*/
        return pokemonDAO.save(remedio);
    }

    public boolean delete(Long codigo) {
        pokemonDAO = new PokemonDAO();
        //aqui se implementa as regras de negocio
        return pokemonDAO.delete(codigo);
    }

    public PokemonTO update(PokemonTO remedio) {
        pokemonDAO = new PokemonDAO();
        // aqui se implenta as regras de negocio
        return pokemonDAO.update(remedio);
    }
}
