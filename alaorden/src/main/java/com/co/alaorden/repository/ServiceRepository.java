package com.co.alaorden.repository;

import com.co.alaorden.model.ServiceEntity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {
	/**tener en cuenta
		validar que no tenga contratos a la fecha
	 */
	@Query(value = "SELECT s.* FROM Service s "
			+ " JOIN Company cp ON s.companyId = cp.id"
			+ " JOIN City ct ON ct.id = cp.city"
			+ " WHERE s.serviceType = :type"
			+ " AND ct.id = :city"
			+ " AND NOT EXISTS (SELECT * FROM Contract WHERE contractDate = :date )", nativeQuery = true)
	List<ServiceEntity> findByEmail(@Param("date") Date date, @Param("type") String type, @Param("city") int city);
}
