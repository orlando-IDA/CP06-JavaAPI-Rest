package br.com.fiap.dao;

import br.com.fiap.to.PokemonTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDAO {
    public ArrayList<PokemonTO> findAll() {
        ArrayList<PokemonTO> pokemons = new ArrayList<PokemonTO>();
        String sql = "select * from ddd_pokemon order by codigo";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PokemonTO pokemon = new PokemonTO();
                    pokemon.setCodigo(rs.getLong("codigo"));
                    pokemon.setNomePokemon(rs.getString("nome_pokemon"));
                    pokemon.setAlturaPokemon(rs.getDouble(("altura_pokemon")));
                    pokemon.setPesoPokemon(rs.getDouble(("peso_pokemon")));
                    pokemon.setCategoria(rs.getString("categoria_pokemon"));
                    pokemon.setDataDeCaptura(rs.getDate("data_de_captura").toLocalDate());
                    pokemons.add(pokemon);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return pokemons;
    }

    public PokemonTO findByCodigo(Long codigo) {
        PokemonTO pokemon = new PokemonTO();
        String sql = "select * from ddd_pokemon where codigo = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pokemon.setCodigo(rs.getLong("codigo"));
                pokemon.setNomePokemon(rs.getString("nome_pokemon"));
                pokemon.setAlturaPokemon(rs.getDouble(("altura_pokemon")));
                pokemon.setPesoPokemon(rs.getDouble(("peso_pokemon")));
                pokemon.setCategoria(rs.getString("categoria_pokemon"));
                pokemon.setDataDeCaptura(rs.getDate("data_de_captura").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return pokemon;
    }

    public PokemonTO save(PokemonTO pokemon) {

        String sql = "insert into ddd_pokemon (nome_pokemon, altura_pokemon, peso_pokemon, categoria_pokemon, data_de_captura) values(?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, pokemon.getNomePokemon());
            ps.setDouble(2, pokemon.getAlturaPokemon());
            ps.setDouble(3, pokemon.getPesoPokemon());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDeCaptura()));

            if (ps.executeUpdate() > 0) {
                return pokemon;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());

        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from ddd_pokemon where codigo = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public PokemonTO update(PokemonTO pokemon) {
        String sql = "update ddd_pokemon set nome_pokemon = ?,altura_pokemon = ?, peso_pokemon = ?, categoria_pokemon = ?, " +
                "data_de_captura = ? where codigo = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1, pokemon.getNomePokemon());
            ps.setDouble(2, pokemon.getAlturaPokemon());
            ps.setDouble(3, pokemon.getPesoPokemon());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDeCaptura()));
            ps.setLong(6, pokemon.getCodigo());
            if(ps.executeUpdate() > 0) {
                return pokemon;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }



}

