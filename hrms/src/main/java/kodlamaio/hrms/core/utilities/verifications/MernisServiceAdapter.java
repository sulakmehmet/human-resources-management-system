package kodlamaio.hrms.core.utilities.verifications;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.hrms.entities.concretes.Jobseeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements JobseekerCheckService {

	@Override
	public boolean checkIsRealPerson(Jobseeker jobseeker) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = true;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(jobseeker.getIdentityNumber()), 
					jobseeker.getFirstName().toUpperCase(new Locale("tr")), 
					jobseeker.getLastName().toUpperCase(new Locale("tr")), jobseeker.getYearOfBirth());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
