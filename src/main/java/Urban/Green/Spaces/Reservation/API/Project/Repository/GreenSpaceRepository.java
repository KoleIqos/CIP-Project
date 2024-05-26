package Urban.Green.Spaces.Reservation.API.Project.Repository;

import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.GreenSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenSpaceRepository extends JpaRepository<GreenSpace, Long> {


}
