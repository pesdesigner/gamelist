package com.graficoeweb.gamelist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    @EmbeddedId
    private BelonginPK id = new BelonginPK();
    private Integer position;

    public Belonging(){
    }
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelonginPK getId() {
        return id;
    }

    public void setId(BelonginPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Belonging belonging)) return false;
        return Objects.equals(id, belonging.id) && Objects.equals(position, belonging.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
