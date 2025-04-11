package org.symphony.arcaria.api.item.template;

import org.bukkit.Material;
import org.symphony.arcaria.api.item.ItemBuilder;
import org.symphony.arcaria.api.item.interfaces.ItemMaker;

public enum CustomItemsTemplate implements ItemMaker {

    PALE_SWORD(new ItemBuilder(Material.IRON_SWORD).setDisplay("<#bdc3c7>Pale Sword"))

    ;

    private final ItemBuilder builder;

    CustomItemsTemplate(ItemBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void build(ItemMaker itemMaker) {
        this.builder.build(this);
    }
}
