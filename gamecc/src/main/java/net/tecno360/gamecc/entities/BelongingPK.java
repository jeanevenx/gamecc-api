package net.tecno360.gamecc.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game g;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private ClassificationList l;

    public BelongingPK() {
    }

    public BelongingPK(Game g, ClassificationList l) {
        this.g = g;
        this.l = l;
    }

    public Game getG() {
        return g;
    }

    public void setG(Game g) {
        this.g = g;
    }

    public ClassificationList getL() {
        return l;
    }

    public void setL(ClassificationList l) {
        this.l = l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingPK that)) return false;
        return Objects.equals(g, that.g) && Objects.equals(l, that.l);
    }

    @Override
    public int hashCode() {
        return Objects.hash(g, l);
    }
}
