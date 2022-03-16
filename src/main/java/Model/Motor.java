package Model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Motor extends PanacheEntity implements Serializable {

    public String bezeichnung;
    public int serialNumber;

    @OneToMany(mappedBy = "motor", cascade = CascadeType.ALL)
    public List<Car> cars;
}
