package andrei.genesysexamples.get_contact;

import andrei.genesysexamples.get_contact.ucs.UCSGetContact;
import andrei.genesysexamples.get_contact.ucs.UCSInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetContactApplication.class, args);

		UCSInit ucsInit = new UCSInit(); //Настраиваем связь с сервером
		ucsInit.init();

		UCSGetContact ucsGetContact = new UCSGetContact();
		ucsGetContact.init(); //Подключаем коннект из UCSInit

		//Ищем контакт по его значению и нужному атрибуту (находятся в таблице генезис CONTACTS)
		int count = ucsGetContact.getContacts("79504558520", "PhoneNumber");
		System.out.println(count);
		System.out.println(ucsGetContact.getMapContact());
	}

}
