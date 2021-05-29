package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.EmailVerificationService;
import kodlamaio.hrms.core.utilities.verifications.JobseekerCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService {

	private JobseekerDao jobseekerDao;
	private JobseekerCheckService jobseekerCheckService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao) {
		super();
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Jobseeker jobseeker) {

		if (jobseekerCheckService.checkIsRealPerson(jobseeker)) {
			if (emailVerificationService.emailVerification(jobseeker)) {
				this.jobseekerDao.save(jobseeker);
				return new SuccessResult("Kayıt işlemi gerçekleştirildi.");
			} else {
				return new ErrorResult("Email doğrulaması gerçekleştirmelisiniz.");
			}

		} else {
			return new ErrorResult("Hatalı giriş gerçekleştirdiniz.");
		}

	}

}
