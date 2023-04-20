package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(0,613, 64, 4000, 4);
        Pokemon pokemon2 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        assertEquals(pokemon.getAttack(), pokemon2.getAttack());
        assertEquals(pokemon.getCp(), pokemon2.getCp());
        assertEquals(pokemon.getHp(), pokemon2.getHp());
        assertEquals(pokemon.getDust(), pokemon2.getDust());
        assertEquals(pokemon.getCandy(), pokemon2.getCandy());
    }

}