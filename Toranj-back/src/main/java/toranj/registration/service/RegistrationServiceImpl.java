package toranj.registration.service;

import javax.swing.text.Position;

import toranj.login.repository.LoginRepository;
import toranj.registration.domain.Extra;
import toranj.registration.domain.Office;
import toranj.registration.domain.Software;
import toranj.registration.repository.RegistrationRepository;

public class RegistrationServiceImpl implements RegistrationService {
	
	public RegistrationServiceImpl() {
		super();	
	}
	
	public String newMember(int idEmployee, String name, String surname, Office office,
		Position position, Extra extra, Software software ) {
		
		RegistrationRepository registrationRepository= new RegistrationRepository();
		
		String success = registrationRepository.newEmployee( idEmployee,  name,  surname,  office, 
				 position,  extra,  software);
		
		return success;
	}
		
		

}
