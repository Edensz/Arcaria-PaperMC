package org.example.project.api.item;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.example.project.api.data.PersistentData;
import org.example.project.api.item.interfaces.ItemMaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemBuilder {
    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material material) {this(new ItemStack(material));}
    public ItemBuilder(@NotNull ItemStack stack) {
        this.item = stack;
        this.meta = stack.getItemMeta();
    }

    public ItemBuilder setDisplay(String display) {
        this.meta.displayName(MiniMessage.miniMessage().deserialize(display));
        return this.update(this.meta);
    }

    public <T, Z> ItemBuilder setData(String key, PersistentDataType<T, Z> type, Z value) {
        PersistentData.set(this.meta, key, type, value);
        return this.update(this.meta);
    }

    public @Nullable <T, Z> Z getData(String key, PersistentDataType<T, Z> type) {
        return PersistentData.get(this.meta, key, type);
    }

    public ItemBuilder setID(String id) {
        return this.setData("identifier", PersistentDataType.STRING, id);
    }

    public ItemStack build(@NotNull ItemMaker itemMaker) {
        this.setID(itemMaker.name());
        return this.item;
    }

    private ItemBuilder update(ItemMeta meta) {
        this.item.setItemMeta(meta);
        return this;
    }
}
