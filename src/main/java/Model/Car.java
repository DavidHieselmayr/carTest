package Model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Car extends PanacheEntity implements Serializable {
    public String kennzeichen;
    public String besitzer;

    @ManyToOne
    public Motor motor;
}
