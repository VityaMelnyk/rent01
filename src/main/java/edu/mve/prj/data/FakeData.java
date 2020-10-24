package edu.mve.prj.data;

import edu.mve.prj.model.Client;
import edu.mve.prj.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FakeData {
   private List<Item> items = Stream.of(
            new Item("1", "Coca-Cola","Drink", LocalDateTime.now(), LocalDateTime.now()),
            new Item("2","Pepsi", "Drink",LocalDateTime.now(),LocalDateTime.now()),
            new Item("3","Sprite","Drink", LocalDateTime.now(),LocalDateTime.now())
    ).collect(Collectors.toList());


    private List <Client> clients = Stream.of(
            new Client("1","Alex Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"),
            new Client("2","Bomj Gena", "Chernivtsi pod mostom","16543241",
                    LocalDate.of(2001, Month.APRIL,8), "esche tot bomj"),
            new Client("3","Sergey Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"),
            new Client("1","Viktor Sergeevich", "Chernivtsi","123445",
                    LocalDate.of(2003, Month.APRIL,2), "esche tot bomj"))
            .collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
