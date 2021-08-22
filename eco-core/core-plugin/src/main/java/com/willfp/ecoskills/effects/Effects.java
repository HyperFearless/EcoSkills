package com.willfp.ecoskills.effects;

import com.google.common.collect.ImmutableSet;
import com.willfp.eco.core.config.updating.ConfigUpdater;
import com.willfp.ecoskills.effects.effects.EffectAcceleratedEscape;
import com.willfp.ecoskills.effects.effects.EffectBountifulHarvest;
import com.willfp.ecoskills.effects.effects.EffectCraftsmanship;
import com.willfp.ecoskills.effects.effects.EffectDodging;
import com.willfp.ecoskills.effects.effects.EffectEfficientBrewing;
import com.willfp.ecoskills.effects.effects.EffectEyeOfTheDepths;
import com.willfp.ecoskills.effects.effects.EffectGoldenYield;
import com.willfp.ecoskills.effects.effects.EffectMysticResilience;
import com.willfp.ecoskills.effects.effects.EffectPotionmaster;
import com.willfp.ecoskills.effects.effects.EffectSatiation;
import com.willfp.ecoskills.effects.effects.EffectSeamlessMovement;
import com.willfp.ecoskills.effects.effects.EffectSecondChance;
import com.willfp.ecoskills.effects.effects.EffectSerratedStrikes;
import com.willfp.ecoskills.effects.effects.EffectShamanism;
import com.willfp.ecoskills.effects.effects.EffectVersatileTools;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Effects {
    /**
     * All registered Skills.
     */
    private static final Map<String, Effect> REGISTRY = new HashMap<>();

    public static final Effect BOUNTIFUL_HARVEST = new EffectBountifulHarvest();
    public static final Effect CRAFTSMANSHIP = new EffectCraftsmanship();
    public static final Effect EYE_OF_THE_DEPTHS = new EffectEyeOfTheDepths();
    public static final Effect POTIONMASTER = new EffectPotionmaster();
    public static final Effect SEAMLESS_MOVEMENT = new EffectSeamlessMovement();
    public static final Effect SECOND_CHANCE = new EffectSecondChance();
    public static final Effect SERRATED_STRIKES = new EffectSerratedStrikes();
    public static final Effect SHAMANISM = new EffectShamanism();
    public static final Effect VERSATILE_TOOLS = new EffectVersatileTools();
    public static final Effect EFFICIENT_BREWING = new EffectEfficientBrewing();
    public static final Effect MYSTIC_RESILIENCE = new EffectMysticResilience();
    public static final Effect SATIATION = new EffectSatiation();
    public static final Effect GOLDEN_YIELD = new EffectGoldenYield();
    public static final Effect DODGING = new EffectDodging();
    public static final Effect ACCELERATED_ESCAPE = new EffectAcceleratedEscape();

    @ApiStatus.Internal
    public static void registerNewEffect(@NotNull final Effect effect) {
        REGISTRY.put(effect.getId(), effect);
    }

    @Nullable
    public static Effect getByID(@NotNull final String id) {
        return REGISTRY.get(id.toLowerCase());
    }

    @Nullable
    public static Effect getByKey(@NotNull final NamespacedKey key) {
        return REGISTRY.get(key.getKey());
    }

    public static Set<Effect> values() {
        return ImmutableSet.copyOf(REGISTRY.values());
    }

    @ConfigUpdater
    public static void update() {
        for (Effect effect : Effects.values()) {
            effect.update();
        }
    }
}
