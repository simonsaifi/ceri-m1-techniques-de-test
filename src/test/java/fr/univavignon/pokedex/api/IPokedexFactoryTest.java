package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Ivysaur", 156, 158, 120));

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertEquals(0, pokedex.getPokemon(0).getIndex());
        assertEquals("Bulbasaur", pokedex.getPokemon(0).getName());
        assertEquals(126, pokedex.getPokemon(0).getAttack());
        assertEquals(126, pokedex.getPokemon(0).getDefense());
        assertEquals(90, pokedex.getPokemon(0).getStamina());

        assertEquals(1, pokedex.getPokemon(1).getIndex());
        assertEquals("Ivysaur", pokedex.getPokemon(1).getName());
        assertEquals(156, pokedex.getPokemon(1).getAttack());
        assertEquals(158, pokedex.getPokemon(1).getDefense());
        assertEquals(120, pokedex.getPokemon(1).getStamina());
    }
}
