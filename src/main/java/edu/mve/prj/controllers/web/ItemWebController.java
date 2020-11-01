package edu.mve.prj.controllers.web;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.form.ItemForm;
import edu.mve.prj.model.Item;
import edu.mve.prj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    /*@RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(@RequestBody ItemForm form, Model model){
        *//*System.out.println(form);
        Item item = new Item();
        form.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);*/
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(ItemForm form, Model model){
        ItemForm itemForm = new ItemForm();
        model.addAttribute("itemForm", itemForm);
        return "itemAddForm";
    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }
}
