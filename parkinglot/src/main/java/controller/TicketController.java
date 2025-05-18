package controller;

import dtos.IssueTickerRequestDto;
import dtos.IssueTicketResponseDto;
import dtos.ResponseStatus;
import service.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // /ticket/book
    public IssueTicketResponseDto issueTicket(IssueTickerRequestDto request) {

        var response = new IssueTicketResponseDto();
        try {
            var ticket = ticketService.issueTicket(request.getGateId(), request.getVehicleNumber(),
                    request.getVehiceleOwnerName(), request.getVehicleType());

            response.setTicket(ticket);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILED);
        }

        return response;
    }
}
