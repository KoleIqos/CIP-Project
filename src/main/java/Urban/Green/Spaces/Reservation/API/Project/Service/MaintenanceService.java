package Urban.Green.Spaces.Reservation.API.Project.Service;

import Urban.Green.Spaces.Reservation.API.Project.Repository.GreenSpaceRepository;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.GreenSpace;
import Urban.Green.Spaces.Reservation.API.Project.com.example.greenspacereservation.model.Maintenance;
import Urban.Green.Spaces.Reservation.API.Project.Repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    GreenSpaceRepository greenSpaceRepository;
    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> getAllMaintenanceTasks() {
        return maintenanceRepository.findAll();
    }

    public Optional<Maintenance> getMaintenanceTaskById(Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId);
    }

    public Maintenance createMaintenanceTask(Maintenance maintenanceTask) {
        Optional<GreenSpace> optionalGreenSpace = greenSpaceRepository.findById(maintenanceTask.getGreenSpace().getId());
        GreenSpace greenSpace = optionalGreenSpace.get();

        maintenanceTask.setGreenSpace(greenSpace);
        return maintenanceRepository.save(maintenanceTask);
    }

    public void deleteMaintenanceTask(Long maintenanceId) {
        maintenanceRepository.deleteById(maintenanceId);
    }

    public Maintenance updateMaintenance(Long maintanceId, Maintenance maintance) {
        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(maintanceId);
        Optional<GreenSpace> optionalGreenSpace = greenSpaceRepository.findById(maintance.getGreenSpace().getId());

        GreenSpace greenSpace = optionalGreenSpace.get();

        Maintenance maintenance = optionalMaintenance.get();
        maintenance.setScheduleTime(maintance.getScheduleTime());
        maintenance.setGreenSpace(greenSpace);

        return maintenanceRepository.save(maintenance);

    }
}
