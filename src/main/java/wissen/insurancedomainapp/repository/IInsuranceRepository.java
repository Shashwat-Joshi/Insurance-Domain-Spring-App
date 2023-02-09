package wissen.insurancedomainapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wissen.insurancedomainapp.models.Insurance;

public interface IInsuranceRepository extends JpaRepository<Insurance, Integer> {
}
