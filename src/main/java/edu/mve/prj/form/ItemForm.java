package edu.mve.prj.form;

import edu.mve.prj.model.Item;

import java.time.LocalDateTime;
import java.util.Objects;

public class ItemForm {
    private String id = " ";
    private String name = " ";
    private String description = " ";
    private String Created_at = " ";
    private String Modified_at = " ";

    public ItemForm() {
    }

    public ItemForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ItemForm(String id, String name, String description, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        Created_at = created_at;
        Modified_at = modified_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(String created_at) {
        Created_at = created_at;
    }

    public String getModified_at() {
        return Modified_at;
    }

    public void setModified_at(String modified_at) {
        Modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "ItemForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", Created_at='" + Created_at + '\'' +
                ", Modified_at='" + Modified_at + '\'' +
                '}';
    }
}

