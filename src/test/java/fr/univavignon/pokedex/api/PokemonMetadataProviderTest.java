package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, new PokemonFactory());
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(pokedex.getPokemon(0).getStamina(),pokemonMetadata.getStamina());
    }
}