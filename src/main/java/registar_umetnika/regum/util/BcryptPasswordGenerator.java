package registar_umetnika.regum.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordGenerator {
	public static void main(String[] args) {
		String password = "110897";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
		System.out.println(passwordEncoder.encode(password));
	}

}
