package kodlamaio.hrms.core.utilities.verifications;

import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerCheckService {
	
	boolean checkIsRealPerson(Jobseeker jobseeker);

}
