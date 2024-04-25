package de.dopebrot.villagegame.cube;
import de.dopebrot.villagegame.world.EVillageBiome;
import org.jetbrains.annotations.NotNull;

public enum ECubeType {

	Beach(0.4f, "skin_beach", "beach", new EVillageBiome[]{EVillageBiome.Water}), // (Strand)
	Ocean(0.8f, "skin_ocean", "ocean", new EVillageBiome[]{EVillageBiome.Water}),
	Swamp(0.3f, "skin_swamp", "swamp", new EVillageBiome[]{EVillageBiome.Water, EVillageBiome.Land}), // (Sumpf)
	Campsite(0.4f, "skin_campsite", "campsite", new EVillageBiome[]{EVillageBiome.Land}), // (Lagerplatz)
	Canyon(0.2f, "skin_canyon", "canyon", new EVillageBiome[]{EVillageBiome.Land}), // (Schlucht)
	Castle(0.1f, "skin_castle", "castle", new EVillageBiome[]{EVillageBiome.Land}), // (Burg)
	Cave(0.3f, "skin_cave", "cave", new EVillageBiome[]{EVillageBiome.Land}), // (Höhle)
	Dune(0.5f, "skin_dune", "dune", new EVillageBiome[]{EVillageBiome.Land}), // (Düne)
	Dungeon(0.4f, "skin_dungeon", "dungeon", new EVillageBiome[]{EVillageBiome.Land}), // (Verlies)
	Farm(0.5f, "skin_farm", "farm", new EVillageBiome[]{EVillageBiome.Land}), // (Bauernhof)
	Field(0.4f, "skin_field", "field", new EVillageBiome[]{EVillageBiome.Land}), // (Feld)
	Forest(0.8f, "skin_forest", "forest", new EVillageBiome[]{EVillageBiome.Land}), // (Lichtung im Wald)
	Garden(0.5f, "skin_garden", "garden", new EVillageBiome[]{EVillageBiome.Land}), // (Garten)
	Hilltop(0.6f, "skin_hilltop", "hilltop", new EVillageBiome[]{EVillageBiome.Land}), // (Hügel)
	Lake(0.5f, "skin_lake", "lake", new EVillageBiome[]{EVillageBiome.Land}), // (Ufer des Sees)
	Mine(0.3f, "skin_mine", "mine", new EVillageBiome[]{EVillageBiome.Land}), // (Mine)
	Mountain(0.4f, "skin_mountain", "mountain", new EVillageBiome[]{EVillageBiome.Land}), // (Bergpass)
	Oasis(0.4f, "skin_oasis", "oasis", new EVillageBiome[]{EVillageBiome.Land}), // (Oase)
	Orchard(0.6f, "skin_orchard", "orchard", new EVillageBiome[]{EVillageBiome.Land}), // (Obstgarten)
	Plain(0.7f, "skin_plain", "plain", new EVillageBiome[]{EVillageBiome.Land}), // (Ebene)
	Quarry(0.5f, "skin_quarry", "quarry", new EVillageBiome[]{EVillageBiome.Land}), // (Steinbruch)
	River(0.6f, "skin_river", "river", new EVillageBiome[]{EVillageBiome.Land}), // (Flussüberquerung)
	Ruins(0.3f, "skin_ruin", "ruin", new EVillageBiome[]{EVillageBiome.Land}), // (Ruinen)
	Shrine(0.2f, "skin_shrine", "shrine", new EVillageBiome[]{EVillageBiome.Land}), // (Schrein)
	Village(0.5f, "skin_village", "village", new EVillageBiome[]{EVillageBiome.Land}), // (Dorf)
	Watchtower(0.1f, "skin_watchtower", "watchtower", new EVillageBiome[]{EVillageBiome.Land}), // (Wachturm)
	;

	// chance = 0 > 1    || 0 == never , 1 == always

	private final float chance;
	private final String fileName;
	private final String name;
	private final EVillageBiome[] onlySpawn;
	ECubeType(float chance, String fileName, String name, EVillageBiome[] onlySpawn) {
		this.chance = chance;
		this.fileName = fileName;
		this.name = name;
		this.onlySpawn = onlySpawn;
	}
	public ECubeType get(int i) {
		return values()[i];
	}
	public float chance() {
		return chance;
	}
	public String fileName() {
		return fileName;
	}
	@NotNull
	public String cubeName() {
		return name;
	}
	public EVillageBiome[] onlySpawn() {
		return onlySpawn;
	}

	public boolean isLand(ECubeType type) {
		return switch (type) {
			case Swamp, Campsite, Canyon, Castle, Cave, Dune, Dungeon, Farm, Field, Forest, Garden, Hilltop, Lake, Mine, Mountain, Oasis, Orchard, Plain, Quarry, River, Ruins, Shrine, Village ->
					true;
			default ->
					false;
		};
	}

	private ECubeType[] getLands() {
		return new ECubeType[]{Swamp, Campsite, Canyon, Castle, Cave, Dune, Dungeon, Farm, Field, Forest, Garden, Hilltop, Lake, Mine, Mountain, Oasis, Orchard, Plain, Quarry, River, Ruins, Shrine, Village};
	}

	private ECubeType[] getWater() {
		return new ECubeType[]{Beach, Ocean, Swamp};
	}

	public boolean isWater(ECubeType type) {
		return switch (type) {
			case Beach, Ocean, Swamp ->
					true;
			default ->
					false;
		};
	}

}
