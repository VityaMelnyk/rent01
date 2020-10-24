package edu.mve.prj.controllers.rest;

import edu.mve.prj.data.FakeData;
import edu.mve.prj.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    @Autowired
    FakeData data;

    @RequestMapping("/list")
    List<Client> getAll() {
        return data.getClients();
    }
}
