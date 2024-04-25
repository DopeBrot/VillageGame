package de.dopebrot.villagegame.game;

import de.dopebrot.villagegame.Main;
import de.dopebrot.villagegame.cube.VillageCube;
import de.dopebrot.villagegame.debug.ImageUpdater;
import de.dopebrot.villagegame.world.EVillageBiome;
import de.dopebrot.villagegame.world.VillageGenerator;
import org.bukkit.event.Listener;

import java.awt.*;
import java.util.ArrayList;

public class GameBoard implements Listener {

	public static GameBoard gameBoard;
	private ImageUpdater biomeDisplay;
	private ArrayList<VillageCube> cubes;
	private VillageGenerator villageGenerator;

	public GameBoard(Main main) {
		this.villageGenerator = new VillageGenerator(15013);
		this.biomeDisplay = new ImageUpdater("BiomeDisplay");
		for (int x = -400; x <= 400; x++) {
			for (int y = -400; y <= 400; y++) {
				if (villageGenerator.getBiome(x, y) == EVillageBiome.Land) {
					biomeDisplay.draw(x + 400, y + 400, new Color(73, 154, 55));
					continue;
				}
				biomeDisplay.draw(x + 400, y + 400, new Color(76, 169, 226));
			}
		}

	}

}
