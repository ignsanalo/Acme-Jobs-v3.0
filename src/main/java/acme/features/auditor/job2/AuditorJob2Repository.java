
package acme.features.auditor.job2;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJob2Repository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select e from Job e where not e.id in (select j from Auditrecord a join a.job j where a.job.id = j.id and a.auditor.id= ?1)")
	Collection<Job> findManyByAuditorId(int auditorId);

}
