package edu.mve.prj.controllers.web;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.model.Item;
import edu.mve.prj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
    @RequestMapping("/web/item")
    public class ItemWebController {
      @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("spisok",service.getAll());
        return "itemsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        /*System.out.println(" ви нажали Delete ");

        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);

        service.getAll().remove(item);*/
        return "redirect:/web/item/all";
    }
}
