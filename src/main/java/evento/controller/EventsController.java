package evento.controller;

import evento.business.RESTforEvents.*;
import evento.business.RESTforUsers.GetUsersUseCase;
import evento.controller.DTOs.EventDTO;
import evento.controller.DTOs.events.CreateEventResponseDTO;
import evento.controller.DTOs.events.GetAllEventsResponseDTO;
import evento.controller.converters.EventDTOConverter;
import evento.controller.converters.events.CreateEventResponseDTOConverter;
import evento.controller.converters.events.GetAllEventsResponseDTOConverter;
import evento.controller.converters.users.GetAllUsersResponseDTOConverter;
import evento.domain.Event;
import evento.domain.User;
import evento.domain.eventActions.*;
import evento.domain.userActions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventsController {
    private final GetEventsUseCase getEventsUseCase;
    private final CreateEventUseCase createEventUseCase;
    private final DeleteEventUseCase deleteEventUseCase;
    private final GetEventUseCase getEventUseCase;

    private  final UpdateEventUseCase updateEventUseCase;

    @GetMapping()
    public ResponseEntity<GetAllEventsResponseDTO> getAllEvents() {
        GetAllEventsRequest request = new GetAllEventsRequest();
        return ResponseEntity.ok(GetAllEventsResponseDTOConverter.convert(getEventsUseCase.getEvents(request)));
    }

    @GetMapping("/{location}")
    public ResponseEntity<GetAllEventsResponseDTO> getAllEvents(@PathVariable(value = "location", required = false)  String location) {
        GetAllEventsRequest request = new GetAllEventsRequest();
        request.setLocation(location);
        return ResponseEntity.ok(GetAllEventsResponseDTOConverter.convert(getEventsUseCase.getEvents(request)));
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<GetAllEventsResponseDTO> getAllEventsByOrganizer(@PathVariable(value = "organizerId") long organizerId) {
        GetAllEventsRequest request = new GetAllEventsRequest();
        request.setOrganizerId(organizerId);
        return ResponseEntity.ok(GetAllEventsResponseDTOConverter.convert(getEventsUseCase.getEvents(request)));
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable(value = "id")  long id) {
        Optional<Event> eventOptional = getEventUseCase.getEvent(id);
        if (eventOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(EventDTOConverter.convert(eventOptional.get()));
    }
    @PostMapping()
    public ResponseEntity<CreateEventResponseDTO> createEvent(@RequestBody @Valid CreateEventRequest createEventRequest) {
        CreateEventResponseDTO response = CreateEventResponseDTOConverter.convert(createEventUseCase.createEvent(createEventRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable long eventId) {
        deleteEventUseCase.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable("id") long id, @RequestBody @Valid UpdateEventRequest request) {
        request.setId(id);
        updateEventUseCase.updateEvent(request);
        return ResponseEntity.noContent().build();
    }

}
