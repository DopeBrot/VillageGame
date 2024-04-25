package de.dopebrot.villagegame;
import de.dopebrot.Program;
import de.dopebrot.villagegame.game.GameBoard;
import de.dopebrot.villagegame.world.WorldGenerator;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {

	private final Program program;
	private GameBoard gameBoard;

	public Main(Program pgm) {
		this.program = pgm;
	}

	public void onLoad() {

	}

	public void onEnable() {
		try {
			rewriteBukkit();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		setupWorld();
		this.gameBoard = new GameBoard(this);

	}

	private void rewriteBukkit() throws IOException {
		File f1 = new File("village");
		f1.delete();
		File f = new File("bukkit.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
		if (!yml.contains("worlds")) {
			ConfigurationSection sec = yml.createSection("worlds");
			ConfigurationSection cfg = sec.createSection("village");
			cfg.set("generator", "Village");
		}
		yml.save(f);
	}

	private void setupWorld() {
		WorldCreator creator = new WorldCreator("village");
	}

	// disables the plugin
	public void onDisable() {
		Objects.requireNonNull(Bukkit.getWorld("village")).getWorldFolder().delete();
	}

	public Program plugin() {
		return program;
	}

	public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
		return new WorldGenerator();
	}

}
