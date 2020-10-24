package edu.mve.prj.service.item.interfaces;

import edu.mve.prj.model.Item;

import java.util.List;

public interface ICrudItem {
    Item create(Item item);
    Item get(String id);
    Item update(Item item);
    Item delete(String id);
    List<Item> getAll();
}
