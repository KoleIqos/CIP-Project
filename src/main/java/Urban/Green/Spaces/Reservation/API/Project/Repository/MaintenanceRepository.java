package Urban.Green.Spaces.Reservation.API.Project.Repository;

import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
