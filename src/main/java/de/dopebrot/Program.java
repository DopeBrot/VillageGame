package de.dopebrot;
import de.dopebrot.villagegame.Main;
import org.bukkit.command.PluginCommand;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Program extends JavaPlugin {

	private Main main;
	public static void main(String[] args) {

	}
	@Override
	public void onLoad() {
		this.main = new Main(this);
		this.main.onLoad();
	}
	@Override
	public void onDisable() {
		this.main.onDisable();
	}
	@Override
	public void onEnable() {
		this.main.onEnable();
	}
	@Override
	public @Nullable ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
		return main.getDefaultWorldGenerator(worldName, id);
	}

	public PluginCommand registerCommand(String s) {
		return getCommand(s);
	}

}
