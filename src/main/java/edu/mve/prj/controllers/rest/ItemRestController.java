package edu.mve.prj.controllers.rest;

import edu.mve.prj.model.Item;
import edu.mve.prj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/item")
    public class ItemRestController {
       @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    List<Item> getAll() {

        return service.getAll();
    }
    @RequestMapping("/delete/{id}")
    Item deleteById(@PathVariable("id") String id) {
       /* Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/

        /*return "redirect:/api/item/all";*/
        return service.delete(id);
    }
}
