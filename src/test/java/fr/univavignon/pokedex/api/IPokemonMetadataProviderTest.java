package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() throws Exception {
        this.pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        this.pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        when(this.pokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(this.pokemonMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertEquals(this.pokemonMetadata, this.pokemonMetadataProvider.getPokemonMetadata(1));
    }
}
