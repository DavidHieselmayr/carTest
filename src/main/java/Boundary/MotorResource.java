package Boundary;

import Model.Car;
import Model.Motor;
import Repository.MotorRepository;
import org.jboss.logging.annotations.Pos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("motor")
public class MotorResource {

    @Inject
    MotorRepository motorRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createCar(Motor motor) {
        try {
            this.motorRepository.persist(motor);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateMotor(Motor motor) {
        try {
            this.motorRepository.updateMotor(motor);
            return Response.accepted().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("/{id}")
    public Response removeMotor(@PathParam("id") Long id) {
        try {
            this.motorRepository.deleteById(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/versuch/{id}")
    public Response versuch(@PathParam("id") Long id) {
        try {
            Motor motor = this.motorRepository.findById(id);
            return Response.ok(this.motorRepository.findById(id)).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
