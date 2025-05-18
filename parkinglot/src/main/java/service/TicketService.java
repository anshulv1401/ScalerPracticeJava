package service;

import exceptions.GateNotFoundException;
import factory.SpotAsssignmentFactory;
import models.Ticket;
import models.Vehicle;
import models.enums.TicketStatus;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSpotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository,
            ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket issueTicket(Long gateId,
            String vehicleNumber, String ownerName,
            VehicleType vehicleType,
            Long parkingLotId)
            throws GateNotFoundException {
        var ticket = new Ticket();
        ticket.setEntryTime(System.currentTimeMillis());

        var optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate with id " + gateId + " not found");
        }
        ticket.setGeneratedAt(optionalGate.get());
        ticket.setGeneratedBy(optionalGate.get().getCurrentOperator());

        var optionalVehicle = vehicleRepository.findByVehicelNumber(vehicleNumber);

        Vehicle vehicle;
        if (optionalVehicle.isEmpty()) {
            var newVehicle = new Vehicle();
            newVehicle.setOwner(ownerName);
            newVehicle.setVehicleNumber(vehicleNumber);
            newVehicle.setVehicleType(vehicleType);
            vehicleRepository.save(newVehicle);
            vehicle = newVehicle;
        } else {
            vehicle = optionalVehicle.get();
        }

        ticket.setVehicle(vehicle);
        ticket.setTicketStatus(TicketStatus.VALID);
        // could be custom
        ticket.setTickerNumber("Ticket:" + System.currentTimeMillis());

        var optionalParkingLot = parkingLotRepository.findById(parkingLotId);

        if (optionalParkingLot.isEmpty()) {
            throw new RuntimeException("Invalid parking id");
        }

        var parkingLot = optionalParkingLot.get();
        var strategyType = parkingLot.getSpotAssignmentStrategy();

        // based on the type, get the corresponding algo
        var strategy = SpotAsssignmentFactory.getSpotAssignmentStrategy(strategyType, parkingSpotRepository);
        var parkingSpot = strategy.assignSpot(vehicleType, optionalGate.get());

        ticket.setParkingSpot(parkingSpot);
        ticketRepository.save(ticket);

        return ticket;
    }
}
