package Urban.Green.Spaces.Reservation.API.Project.Service;

import Urban.Green.Spaces.Reservation.API.Project.Repository.GreenSpaceRepository;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Event;
import Urban.Green.Spaces.Reservation.API.Project.Repository.EventRepository;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.GreenSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    GreenSpaceRepository greenSpaceRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public Event createEvent(Event event) {
        Optional<GreenSpace> optionalGreenSpace = greenSpaceRepository.findById(event.getGreenSpace().getId());
        GreenSpace greenSpace = optionalGreenSpace.get();

        event.setGreenSpace(greenSpace);

        return eventRepository.save(event);
    }

    public Event updateEvent(Long eventId, Event event) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        Optional<GreenSpace> optionalGreenSpace = greenSpaceRepository.findById(event.getGreenSpace().getId());

        GreenSpace greenSpace = optionalGreenSpace.get();

        Event event1 = optionalEvent.get();
        event1.setGreenSpace(greenSpace) ;

        event1.setEventTime(event.getEventTime());
        event1.setDescription(event.getDescription());
        event1.setName(event.getName());

        return eventRepository.save(event1);

    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
