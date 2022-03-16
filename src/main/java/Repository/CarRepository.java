package Repository;

import Model.Car;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {


}
