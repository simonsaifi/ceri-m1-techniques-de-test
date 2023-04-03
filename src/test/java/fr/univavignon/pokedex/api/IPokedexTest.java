package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest{

    Pokemon bulbizarre = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aquali = new Pokemon(0, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    IPokedex iPokedexMock = Mockito.mock(IPokedex.class);

    @Test
    public void testSize() {
        when(iPokedexMock.size()).thenReturn(0);
        assertEquals(0,iPokedexMock.size());
    }

    @Test
    public void testAddPokemon() {
        when(iPokedexMock.addPokemon(bulbizarre)).thenReturn(0);
        assertEquals(0,iPokedexMock.addPokemon(bulbizarre));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(iPokedexMock.getPokemon(anyInt())).thenAnswer(input -> {
            if((int)input.getArgument(0) > 150 || (int)input.getArgument(0) < 0) throw new PokedexException("Index must be between 0 and 150!");
            else return bulbizarre;
        });
        assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(-1));
        assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(151));
        assertEquals(bulbizarre, iPokedexMock.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        when(iPokedexMock.getPokemons()).thenReturn(pokemons);
        assertEquals(pokemons,iPokedexMock.getPokemons());
    }

    @Test
    public void testGetPokemons2() {
        when(iPokedexMock.getPokemons(any())).thenAnswer(input -> {
            Comparator<Pokemon> order = input.getArgument(0);
            List<Pokemon> pokemons = new ArrayList<Pokemon>();
            if(order == PokemonComparators.NAME || order == PokemonComparators.CP) {
                pokemons.add(aquali);
                pokemons.add(bulbizarre);
                return pokemons;
            }
            else {
                pokemons.add(bulbizarre);
                pokemons.add(aquali);
                return pokemons;
            }
        });
        pokemons.add(aquali);
        pokemons.add(bulbizarre);
        assertEquals(pokemons.get(0).getName(), iPokedexMock.getPokemons(PokemonComparators.NAME).get(0).getName());
        assertEquals(pokemons.get(0).getCp(), iPokedexMock.getPokemons(PokemonComparators.CP).get(0).getCp());
        pokemons.clear();
        pokemons.add(bulbizarre);
        pokemons.add(aquali);
        assertEquals(pokemons.get(0).getIndex(), iPokedexMock.getPokemons(PokemonComparators.INDEX).get(0).getIndex());
    }
}