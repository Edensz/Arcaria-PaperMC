package org.symphony.arcaria.api.item.interfaces;

public interface ItemMaker {
    String name();
    void build(ItemMaker itemMaker);
}
