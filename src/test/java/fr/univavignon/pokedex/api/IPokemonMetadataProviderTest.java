package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest{

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        PokemonMetadata pokemonMetadata = Mockito.mock(PokemonMetadata.class);
        when(iPokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(input -> {
            if((int)input.getArgument(0) < 0 || (int)input.getArgument(0) > 150) {
                throw new PokedexException("Index must be between 0 and 150!");
            }
            else return pokemonMetadata;
        });
        assertThrows(PokedexException.class,()->iPokemonMetadataProvider.getPokemonMetadata(-1));
        assertThrows(PokedexException.class,()->iPokemonMetadataProvider.getPokemonMetadata(151));
        assertEquals(iPokemonMetadataProvider.getPokemonMetadata(0), pokemonMetadata);
    }


}