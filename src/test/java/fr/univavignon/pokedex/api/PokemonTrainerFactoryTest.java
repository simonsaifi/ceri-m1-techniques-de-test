package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Karmasutra", Team.INSTINCT, new PokedexFactory());
        PokemonTrainer trainer1 = new PokemonTrainer("Karmasutra", Team.INSTINCT, new Pokedex(new PokemonMetadataProvider(), new PokemonFactory()));
        assertEquals(trainer.getName(), trainer1.getName());
        assertEquals(trainer.getTeam(), trainer1.getTeam());
        assertEquals(trainer.getPokedex().getPokemons(), trainer1.getPokedex().getPokemons());
    }

}