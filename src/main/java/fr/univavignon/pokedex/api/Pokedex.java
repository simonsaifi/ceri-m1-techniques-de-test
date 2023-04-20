package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pokedex implements IPokedex {

    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    public static List<Pokemon> pokemons = new ArrayList<Pokemon>();

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
        pokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        Collections.sort(pokemons, order);
        return pokemons;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}