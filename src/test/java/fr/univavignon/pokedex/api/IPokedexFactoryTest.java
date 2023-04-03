package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokedexFactory mockIPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex iPokedex = Mockito.mock(IPokedex.class);
        when(mockIPokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(iPokedex);

        assertEquals(iPokedex, mockIPokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }

}