package Urban.Green.Spaces.Reservation.API.Project.Repository;

import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
