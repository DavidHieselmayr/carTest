package Boundary;


import Model.Car;
import Model.Motor;
import Repository.CarRepository;
import Repository.MotorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("car")
public class CarResource {

    @Inject
    CarRepository carRepository;

    @Inject
    MotorRepository motorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        return this.carRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(Car car) {
        try {
            Motor motor = this.motorRepository.findById(car.motor.id);
            car.motor = motor;
            this.carRepository.persist(car);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Car getCar(@PathParam("id") Long id) {
        try {
            Car car = this.carRepository.findById(id);
            return car;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
