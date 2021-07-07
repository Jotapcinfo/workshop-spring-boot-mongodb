package br.com.portaljmti.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.portaljmti.workshopmongo.domain.Post;
import br.com.portaljmti.workshopmongo.domain.User;
import br.com.portaljmti.workshopmongo.dto.AuthorDTO;
import br.com.portaljmti.workshopmongo.repository.PostRepository;
import br.com.portaljmti.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		

		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, dateFormat.parse ("05/07/2021"), "Partiu viagem", "Vou viajar para outro País! Abraços", new AuthorDTO(maria));
        Post post2 = new Post(null, dateFormat.parse ("08/07/2021"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
	

	}

}
