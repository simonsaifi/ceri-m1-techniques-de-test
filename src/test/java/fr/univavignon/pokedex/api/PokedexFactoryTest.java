package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokedex pokedex0 = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        IPokedex pokedex1 = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
        assertEquals(pokedex0.getPokemons(), pokedex1.getPokemons());
    }

}