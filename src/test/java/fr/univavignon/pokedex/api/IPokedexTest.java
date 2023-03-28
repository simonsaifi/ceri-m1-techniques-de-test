package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    @Mock private IPokemonMetadataProvider metadataProvider;
    @Mock private IPokemonFactory pokemonFactory;

    private IPokedex pokedex;

    @Before
    public void setUp() throws PokedexException {
        MockitoAnnotations.initMocks(this);

        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbasaur", 613, 64, 4000, 4, 0.89));
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        pokedex.addPokemon(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
    }

    @Test
    public void testSize() {
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        assertEquals(1, pokedex.addPokemon(pokemonFactory.createPokemon(1, 918, 70, 5000, 2)));
        assertEquals(2, pokedex.size());
        assertEquals(pokemonFactory.createPokemon(1, 918, 70, 5000, 2), pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(613, pokemon.getAttack());
        assertEquals(64, pokemon.getDefense());
        assertEquals(4000, pokemon.getStamina());
        assertEquals(4, pokemon.getCp());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(1);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertEquals(pokemons, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsWithSorting() {
        pokedex.addPokemon(pokemonFactory.createPokemon(1, 918, 70, 5000, 2));
        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemonFactory.createPokemon(1, 918, 70, 5000, 2));
        expectedPokemons.add(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        List<Pokemon> actualPokemons = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp).reversed());
        assertEquals(expectedPokemons, actualPokemons);
    }
}
