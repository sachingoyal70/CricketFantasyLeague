/**
 * 
 */
package in.sachin.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sachin.cricket.model.Company;

/**
 * @author Yash Singh
 *
 */
@Repository("companyDetailsRepository")
public interface CompanyDetailsRepository extends JpaRepository<Company, Long>{
	Company findByUserName(String name);
}
