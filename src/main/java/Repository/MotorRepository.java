package Repository;

import Model.Motor;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MotorRepository implements PanacheRepository<Motor> {
    public void updateMotor(Motor motor) {
        try{
            Panache.getEntityManager().merge(motor);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
