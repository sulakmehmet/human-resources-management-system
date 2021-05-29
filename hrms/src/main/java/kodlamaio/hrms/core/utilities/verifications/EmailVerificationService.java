package kodlamaio.hrms.core.utilities.verifications;

import kodlamaio.hrms.entities.concretes.User;

public interface EmailVerificationService {
	
	boolean emailVerification(User user);

}
