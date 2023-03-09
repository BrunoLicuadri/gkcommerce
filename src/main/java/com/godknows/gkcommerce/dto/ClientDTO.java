package com.godknows.gkcommerce.dto;

import com.godknows.gkcommerce.entities.User;

public class ClientDTO {

    private long id;
    private String name;

    public ClientDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
