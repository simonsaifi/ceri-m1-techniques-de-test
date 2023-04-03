package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        IPokedex iPokedexMock = Mockito.mock(IPokedex.class);
        IPokedexFactory iPokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
        IPokemonTrainerFactory iPokemonTrainerFactoryMock = Mockito.mock(IPokemonTrainerFactory.class);
       
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Karmasutra", Team.INSTINCT, iPokedexMock);
       
        when(iPokemonTrainerFactoryMock.createTrainer("Karmasutra", Team.INSTINCT, iPokedexFactoryMock))
        .thenReturn(pokemonTrainer);
        assertEquals(pokemonTrainer, iPokemonTrainerFactoryMock
        .createTrainer("Karmasutra", Team.INSTINCT, iPokedexFactoryMock));
    }

}