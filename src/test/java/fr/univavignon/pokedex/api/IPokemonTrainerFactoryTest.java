package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

	private IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

	@Test
	public void testCreateTrainer() {
		String name = "Ash Ketchum";
		Team team = Team.VALOR;
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

		PokemonTrainer trainer = new PokemonTrainer(name, team, pokedexFactory);

		Mockito.when(pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(trainer);

		PokemonTrainer createdTrainer = pokemonTrainerFactory.createTrainer(name, team, pokedexFactory);

		assertEquals(trainer.getName(), createdTrainer.getName());
		assertEquals(trainer.getTeam(), createdTrainer.getTeam());
		assertEquals(trainer.getPokedex(), createdTrainer.getPokedex());
	}
}
