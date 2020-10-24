package edu.mve.prj.controllers.web;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("web/client")
public class ClientWebController {

    @Autowired
    FakeData data;

    @RequestMapping("/list")
    String getList (Model model){
        model.addAttribute("clients",data.getClients());
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {

        Client item = data.getClients().stream().filter(element -> element.getId().equals(id)).findFirst().orElse(null);
        data.getClients().remove(item);
        return "redirect:/web/client/list";
    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id){
        return "hello";
    }

}
