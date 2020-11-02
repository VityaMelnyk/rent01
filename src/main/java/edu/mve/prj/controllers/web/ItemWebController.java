package edu.mve.prj.controllers.web;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.form.ItemForm;
import edu.mve.prj.model.Item;
import edu.mve.prj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("spisok", service.getAll());
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form", itemForm);
        return "itemAddForm";
    }
/*@RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }*/

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model) {
        System.out.println(form);
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id,
    @ModelAttribute("form") ItemForm form) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.update(item);
        return "redirect:/web/item/all";
        /*return "updateItem";*/
    }
}