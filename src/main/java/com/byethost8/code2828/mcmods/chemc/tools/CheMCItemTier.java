package com.byethost8.code2828.mcmods.chemc.tools;

import java.util.function.Supplier;

import com.byethost8.code2828.mcmods.chemc.CheMC;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CheMCItemTier implements IItemTier {
    SOFT_METAL(1, 24, 8.0F, 1.0F, 32, () -> {
        return Ingredient.fromItems(CheMC.i_li);
    }),
    STRONG_MAO(3, 2048, 8.0F, 1.0F, 32, () -> { // MAO = Metals And their Oxides
        return Ingredient.fromItems(CheMC.i_li);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private CheMCItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
            int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
