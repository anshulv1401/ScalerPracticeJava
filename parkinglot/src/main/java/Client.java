import controller.TicketController;
import dtos.IssueTickerRequestDto;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import service.TicketService;

public class Client {
    public static void main(String[] args) {
        var gateRepository = new GateRepository();
        var parkingSpotRepo = new ParkingSpotRepository();
        var parkingFloorRepo = new ParkingFloorRepository(parkingSpotRepo.getAllParkingSpot(),
                gateRepository.getAllGates());
        var parkingLotRepo = new ParkingLotRepository(parkingFloorRepo.getAllParkingFloors());
        var ticketRepo = new TicketRepository();
        var vehicleRepo = new VehicleRepository();

        var ticketService = new TicketService(gateRepository, vehicleRepo, parkingLotRepo, ticketRepo, parkingSpotRepo);

        var ticketController = new TicketController(ticketService);

        var request = new IssueTickerRequestDto();
        request.setGateId(1l);
        request.setParkingLotId(1l);
        request.setVehiceleOwnerName("Anshul");
        request.setVehicleNumber("1");
        request.setVehicleType(VehicleType.SUV);

        var response = ticketController.issueTicket(request);

        System.out.println(response.getResponseStatus());
    }
}