package org.example.project.api.item.interfaces;

public interface ItemMaker {
    String name();
    void build(ItemMaker itemMaker);
}
