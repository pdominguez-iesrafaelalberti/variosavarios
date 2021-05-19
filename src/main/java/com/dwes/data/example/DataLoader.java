package com.dwes.data.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dwes.entity.Newspaper;
import com.dwes.entity.Subcriptor;
import com.dwes.repository.NewspaperRepository;
import com.dwes.repository.SubcriptorRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	NewspaperRepository newspaperrepository;
	
	@Autowired
	SubcriptorRepository subcriptorrepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		newspaperrepository.deleteAll();
		subcriptorrepository.deleteAll();
		
		Subcriptor s = new Subcriptor("Juan", "C/Mayor 3");
		Subcriptor s1 = new Subcriptor("Homer", "Evergreen Terrace 642");
		Subcriptor s2 = new Subcriptor("Merkel", "Uber Strauss 420");
		
		subcriptorrepository.save(s);
		subcriptorrepository.save(s1);
		subcriptorrepository.save(s2);
		
		Newspaper news = new Newspaper("Wall Street Journal");
		Newspaper news2 = new Newspaper("El País");
		Newspaper news3 = new Newspaper("El Mundo");
	
	
		newspaperrepository.save(news);
		newspaperrepository.save(news2);
		newspaperrepository.save(news3);
		
		
		agregar_relacion(news,s);
		agregar_relacion(news,s1);
		agregar_relacion(news,s2);
		
		
		agregar_relacion(news2,s);
		agregar_relacion(news2,s1);
		
		
		agregar_relacion(news3,s);

	}
	
	void agregar_relacion(Newspaper n, Subcriptor s) {
	
		s.getNewspaper().add(n);
		n.getSubcriptors().add(s);
		
		newspaperrepository.save(n);
	}

}
