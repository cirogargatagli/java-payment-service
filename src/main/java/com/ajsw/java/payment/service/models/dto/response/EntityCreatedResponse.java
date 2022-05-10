package com.ajsw.java.payment.service.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class EntityCreatedResponse extends Response{
    @Getter
    @Setter
    public int id;

    public EntityCreatedResponse() {
        super();
    }

    public EntityCreatedResponse(int id, String nameEntity) {
        super(201, nameEntity + " created succesfully");
        this.id = id;
    }
}
