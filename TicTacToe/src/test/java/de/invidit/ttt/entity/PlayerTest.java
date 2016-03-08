package de.invidit.ttt.entity;


import de.invidit.ttt.FakeMoveStrategy;
import de.invidit.ttt.entity.PlayerData;
import de.invidit.ttt.strategy.MinimaxStrategy;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import de.invidit.ttt.entity.Player;

public class PlayerTest {

	@Test
	public void testConstructorNoParameters() {
		Player player = new Player();
		Assertions.assertThat(player.getName()).isEmpty();
	}
	
	@Test
	public void testConstructorParameters() {
		String name = "Hugo";
		Player player = new Player(new PlayerData(name, "", null));
		Assertions.assertThat(player.getName()).isEqualTo(name);
	}


	@Test(expected = NullPointerException.class)
	public void testInitConstructorWithNullThrowsNPE() {
		new Player(null);
	}

	@Test(expected = NullPointerException.class)
	public void testNameSetterWithNullThrowsNPE() {
		Player sut = new Player();

		sut.setName(null);
	}

	@Test
	public void testEqualsWithTwoAttributesIsEqual() {
		Player player1 = new Player("Hugo", "X");
		Player player2 = new Player("Hugo", "X");

		Assertions.assertThat(player1).isEqualTo(player2);
	}

	@Test
	public void testEqualsWithDifferentNameIsNotEqual() {
		Player player1 = new Player("Karl", "X");
		Player player2 = new Player("Hugo", "X");

		Assertions.assertThat(player1).isNotEqualTo(player2);
	}

	@Test
	public void testEqualsWithDifferentSymbolIsNotEqual() {
		Player player1 = new Player("Hugo", "X");
		Player player2 = new Player("Hugo", "Y");

		Assertions.assertThat(player1).isNotEqualTo(player2);
	}

	@Test
	public void testEqualsWithDifferentStrategyIsEqual() {
		PlayerData data1 = new PlayerData("Hugo", "X", new FakeMoveStrategy());
		PlayerData data2 = new PlayerData("Hugo", "X", new MinimaxStrategy());

		Player player1 = new Player(data1);
		Player player2 = new Player(data2);

		Assertions.assertThat(player1).isEqualTo(player2);
	}

	@Test
	public void testGetNextMoveReturnsValueFromStrategy() {
		PlayerData data = new PlayerData("Hugo", "X", new FakeMoveStrategy());
		Player player = new Player(data);
		Assertions.assertThat(player.getNextMove(null)).isEqualTo(0);
	}
}
