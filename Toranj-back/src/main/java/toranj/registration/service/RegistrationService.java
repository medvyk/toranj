package toranj.registration.service;

import javax.swing.text.Position;

import toranj.registration.domain.Extra;
import toranj.registration.domain.Office;
import toranj.registration.domain.Software;

public interface RegistrationService {
	
	
	public String newMember(int idEmployee, String name, String surname, Office office,
			Position position, Extra extra, Software software );

}
