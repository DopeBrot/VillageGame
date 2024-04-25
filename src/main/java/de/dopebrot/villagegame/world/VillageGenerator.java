package de.dopebrot.villagegame.world;
import org.bukkit.util.noise.NoiseGenerator;
import org.bukkit.util.noise.PerlinNoiseGenerator;

public class VillageGenerator {

	private final PerlinNoiseGenerator biomeGenerator;
	private final PerlinNoiseGenerator blockTypeGenerator;
	private final float aboveLand = 0.5f;
	private final float biomeScale = 0.04f;

	public VillageGenerator(long seed) {
		this.biomeGenerator = new PerlinNoiseGenerator(seed);
		this.blockTypeGenerator = new PerlinNoiseGenerator(seed);
	}

	public EVillageBiome getBiome(int x, int z) {
		if (fixMidPoint(this.biomeGenerator, x * biomeScale, z * biomeScale) > aboveLand) {
			return EVillageBiome.Land;
		}
		return EVillageBiome.Water;
	}

	private double fixMidPoint(NoiseGenerator generator, double x, double z) {
		return ((generator.noise(x, z) + 1f) * 0.5f);
	}

}
