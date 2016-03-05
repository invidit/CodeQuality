package de.invidit.ttt;


import de.invidit.ttt.entity.PlayerData;
import org.junit.Test;

import de.invidit.ttt.entity.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

	@Test
	public void testConstructorNoParameters() {
		Player player = new Player();
		assertThat(player.getName()).isEmpty();
	}
	
	@Test
	public void testConstructorParameters() {
		String name = "Hugo";
		Player player = new Player(new PlayerData(name, "", null));
		assertThat(player.getName()).isEqualTo(name);
	}
	
//	@Test
//	public void testGetNextMoveReturnsValueFromStrategy() {
//		Player player = new Player("Hugo", "X", new FakeMoveStrategy());
//		assertThat(player.getNextMove(null)).isEqualTo(0);
//	}
}
