package org.lf.bazaar;

/**
 * Some of item in bazaar will not add in instantly
 */
@SuppressWarnings("unused")
public enum ItemID {

    /* Farming */
    //Wheat
    WHEAT,
    ENCHANTED_BREAD,
    HAY_BLOCK,
    ENCHANTED_HAY_BLOCK,
    //Carrot
    CARROT_ITEM,
    ENCHANTED_CARROT,
    ENCHANTED_CARROT_ON_A_STICK,
    ENCHANTED_GOLDEN_CARROT,
    //Potato
    POTATO_ITEM,
    ENCHANTED_POTATO,
    ENCHANTED_BAKED_POTATO,
    //Pumpkin
    PUMPKIN,
    ENCHANTED_PUMPKIN,
    //Melon
    MELON,
    ENCHANTED_MELON,
    ENCHANTED_GLISTERING_MELON,
    ENCHANTED_MELON_BLOCK,
    //Seeds
    SEEDS,
    ENCHANTED_SEEDS,
    //Red Mushroom
    RED_MUSHROOM,
    ENCHANTED_RED_MUSHROOM,
    HUGE_MUSHROOM_1,
    ENCHANTED_HUGE_MUSHROOM_1,
    //Brown Mushroom
    BROWN_MUSHROOM,
    ENCHANTED_BROWN_MUSHROOM,
    HUGE_MUSHROOM_2,
    ENCHANTED_HUGE_MUSHROOM_2,
    //Cocoa Beans
    INK_SACK3("INK_SACK:3"),
    ENCHANTED_COCOA,
    ENCHANTED_COOKIE,
    //Cactus
    CACTUS,
    ENCHANTED_CACTUS_GREEN,
    ENCHANTED_CACTUS,
    //Sugar Cane
    SUGAR_CANE,
    ENCHANTED_SUGAR,
    ENCHANTED_PAPER,
    ENCHANTED_SUGAR_CANE,
    //Feather
    FEATHER,
    ENCHANTED_FEATHER,
    //Leather & Beef
    LEATHER,
    ENCHANTED_LEATHER,
    RAW_BEEF,
    ENCHANTED_RAW_BEEF,
    //Pork
    PORK,
    ENCHANTED_PORK,
    ENCHANTED_GRILLED_PORK,
    //Chicken
    RAW_CHICKEN,
    ENCHANTED_RAW_CHICKEN,
    ENCHANTED_EGG,
    ENCHANTED_CAKE,
    SUPER_EGG,
    //Mutton
    MUTTON,
    ENCHANTED_MUTTON,
    ENCHANTED_COOKED_MUTTON,
    //Rabbit
    RABBIT,
    ENCHANTED_RABBIT,
    RABBIT_FOOT,
    RABBIT_HIDE,
    ENCHANTED_RABBIT_FOOT,
    ENCHANTED_RABBIT_HIDE,
    //Nether Warts
    NETHER_STALK,
    ENCHANTED_NETHER_STALK,

    /* Mining */
    //Cobblestone
    COBBLESTONE,
    ENCHANTED_COBBLESTONE,
    //Coal
    COAL,
    ENCHANTED_COAL,
    ENCHANTED_CHARCOAL,
    ENCHANTED_COAL_BLOCK,
    //Iron
    IRON_INGOT,
    ENCHANTED_IRON,
    ENCHANTED_IRON_BLOCK,
    //Gold
    GOLD_INGOT,
    ENCHANTED_GOLD,
    ENCHANTED_GOLD_BLOCK,
    //Diamond
    DIAMOND,
    ENCHANTED_DIAMOND,
    ENCHANTED_DIAMOND_BLOCK,
    //Lapis
    INK_SACK4("INK_SACK:4"),
    ENCHANTED_LAPIS_LAZULI,
    ENCHANTED_LAPIS_LAZULI_BLOCK,
    //Emerald
    EMERALD,
    ENCHANTED_EMERALD,
    ENCHANTED_EMERALD_BLOCK,
    //Redstone
    REDSTONE,
    ENCHANTED_REDSTONE,
    ENCHANTED_REDSTONE_BLOCK,
    //Quartz
    QUARTZ,
    ENCHANTED_QUARTZ,
    ENCHANTED_QUARTZ_BLOCK,
    //Obsidian
    OBSIDIAN,
    ENCHANTED_OBSIDIAN,
    //Glowstone
    GLOWSTONE_DUST,
    ENCHANTED_GLOWSTONE_DUST,
    ENCHANTED_GLOWSTONE,
    //Gravel
    GRAVEL,
    //Flint
    FLINT,
    ENCHANTED_FLINT,
    //Ice
    ICE,
    ENCHANTED_ICE,
    PACKED_ICE,
    ENCHANTED_PACKED_ICE,
    //Netherrack
    NETHERRACK,
    //Sand
    SAND,
    ENCHANTED_SAND,
    //End Stone
    ENDER_STONE,
    ENCHANTED_ENDSTONE,
    //Snow
    SNOW_BALL,
    SNOW_BLOCK,
    ENCHANTED_SNOW_BLOCK,

    /* Combat */
    //Rotten Flesh
    ROTTEN_FLESH,
    ENCHANTED_ROTTEN_FLESH,
    //Bone
    BONE,
    ENCHANTED_BONE,

    //String
    STRING,
    ENCHANTED_STRING,
    //Spider Eye
    SPIDER_EYE,
    ENCHANTED_SPIDER_EYE,
    ENCHANTED_FERMENTED_SPIDER_EYE,
    //GunPowder
    SULPHUR,
    ENCHANTED_GUNPOWDER,
    ENCHANTED_FIREWORK_ROCKET,
    //Ender Pearl
    ENDER_PEARL,
    ENCHANTED_ENDER_PEARL,
    ENCHANTED_EYE_OF_ENDER,
    //Ghast Tear
    GHAST_TEAR,
    ENCHANTED_GHAST_TEAR,
    //Slime Ball
    SLIME_BALL,
    ENCHANTED_SLIME_BALL,
    ENCHANTED_SLIME_BLOCK,
    //Blaze Rod
    BLAZE_ROD,
    ENCHANTED_BLAZE_POWDER,
    ENCHANTED_BLAZE_ROD,
    //Magma Cream
    MAGMA_CREAM,
    ENCHANTED_MAGMA_CREAM,

    /* Woods & Fishes */
    //Oak
    LOG,
    ENCHANTED_OAK_LOG,
    //Spruce
    LOG1("LOG:1"),
    ENCHANTED_SPRUCE_LOG,
    //Birch
    LOG2("LOG:2"),
    ENCHANTED_BIRCH_LOG,
    //Dark Oak
    LOG_21("LOG_2:1"),
    ENCHANTED_DARK_OAK_LOG,
    //Acacia
    LOG_2,
    ENCHANTED_ACACIA_LOG,
    //Jungle
    LOG3("LOG:3"),
    ENCHANTED_JUNGLE_LOG,
    //Raw Fish
    RAW_FISH,
    ENCHANTED_RAW_FISH,
    ENCHANTED_COOKED_FISH,
    //Salmon
    RAW_FISH1("RAW_FISH:1"),
    ENCHANTED_RAW_SALMON,
    ENCHANTED_COOKED_SALMON,
    //Clownfish
    RAW_FISH2("RAW_FISH:2"),
    ENCHANTED_CLOWNFISH,
    //Pufferfish
    RAW_FISH3("RAW_FISH:3"),
    ENCHANTED_PUFFERFISH,
    //Prismarine Shard
    PRISMARINE_SHARD,
    ENCHANTED_PRISMARINE_SHARD,
    //Prismarine Crystals
    PRISMARINE_CRYSTALS,
    ENCHANTED_PRISMARINE_CRYSTALS,
    //Clay
    CLAY_BALL,
    ENCHANTED_CLAY_BALL,
    //Lily Pad
    WATER_LILY,
    ENCHANTED_WATER_LILY,
    //Ink
    INK_SACK,
    ENCHANTED_INK_SACK,
    //Sponge
    SPONGE,
    ENCHANTED_SPONGE,
    ENCHANTED_WET_SPONGE,
    //Baits











    //Fishing Festival Items






    /* Oddities */
    //Revenant Flesh
    REVENANT_FLESH,
    REVENANT_VISCERA,
    //Tarantula
    TARANTULA_SILK,
    TARANTULA_WEB,
    //Wolf Tooth
    WOLF_TOOTH,
    GOLDEN_TOOTH,
    //Hot Potato Book
    HOT_POTATO_BOOK,

    //Compactor
    COMPACTOR,
    SUPER_COMPACTOR_3000,
    //Summoning Eye
    SUMMONING_EYE,
    //Dragon Fragment
    PROTECTOR_FRAGMENT,
    OLD_FRAGMENT,
    UNSTABLE_FRAGMENT,
    STRONG_FRAGMENT,
    YOUNG_FRAGMENT,
    WISE_FRAGMENT,
    SUPERIOR_FRAGMENT,

    //Enchanted Redstone Lamp
    ENCHANTED_REDSTONE_LAMP,
    //Fuels
    ENCHANTED_LAVA_BUCKET,
    HAMSTER_WHEEL,
    FOUL_FLESH,
    CATALYST,

    //Candies
    GREEN_CANDY,
    PURPLE_CANDY,
    //Gifts
    WHITE_GIFT,
    GREEN_GIFT,
    RED_GIFT,
    //Mythological




    //Refined Mineral

    //Booster Cookie

    //Stock of Stonks
    STOCK_OF_STONKS,
    ;

    private final String ID;
    ItemID() {
        ID = toString();
    }
    ItemID(String id) {
        ID = id;
    }

    public String getID() {
        return ID;
    }

}
