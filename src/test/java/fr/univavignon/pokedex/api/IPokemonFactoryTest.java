package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;

public class IPokemonFactoryTest {

    public IPokemonFactory pokemonFactory;

    @Test
    public void testCreatePokemon() {
        pokemonFactory = new IPokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 50, 2000, 3);
        Assert.assertNotNull(pokemon);
        Assert.assertEquals(0, pokemon.getIndex());
        Assert.assertEquals(500, pokemon.getCP());
        Assert.assertEquals(50, pokemon.getHP());
        Assert.assertEquals(2000, pokemon.getDust());
        Assert.assertEquals(3, pokemon.getCandy());
    }
}
