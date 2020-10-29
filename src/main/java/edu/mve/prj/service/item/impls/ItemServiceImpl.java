package edu.mve.prj.service.item.impls;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.model.Item;
import edu.mve.prj.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ItemServiceImpl implements ICrudItem {

    @Autowired
    FakeData data;

    @Override
    public Item create(Item item) {
        if (item.getId()!= null){
            this.getAll().add(item);
        }else{
            Integer id = this.getAll().stream().map(el -> el.getId())

                    .mapToInt(el -> Integer.valueOf(el)).max().orElse(0);

            item.setId(String.valueOf(id+1));

            item.setCreated_at(LocalDateTime.now());
            item.setModified_at(LocalDateTime.now());

            this.getAll().add(item);
        }
        return item;
    }

    @Override
    public Item get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        this.getAll().remove(item);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return data.getItems();
    }
}
