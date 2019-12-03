
package acme.features.auditor.job2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorJob2ShowService implements AbstractShowService<Auditor, Job> {

	@Autowired
	AuditorJob2Repository repository;


	@Override
	public boolean authorise(final Request<Job> request) {

		assert request != null;

		boolean result;

		int jobID;
		Job job;
		Auditor auditor;
		Principal principal;

		jobID = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobID);
		principal = request.getPrincipal();

		result = job.isFinalMode();

		return result;

	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline", "salary", "moreInfo", "description", "finalMode");
	}

	@Override
	public Job findOne(final Request<Job> request) {

		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;

	}

}
