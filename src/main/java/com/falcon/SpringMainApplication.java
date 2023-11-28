package com.falcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.falcon.entity.UserDetails;
import com.falcon.repository.UserDetailsRepository;
import com.falcon.repository.ServerRepository;
import com.falcon.entity.Server;
import com.falcon.entity.Status;
/**
 * This is SpringBoot Main class from where application execution starts.
 * 
 * @author vn520qv
 *
 */
@SpringBootApplication
public class SpringMainApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(SpringMainApplication.class, args);
	}
	
	  @Autowired
	    private UserDetailsRepository UserDetailsRepository;
	  
	  @Autowired
	  	private ServerRepository ServerRepository;
	 
	  @Override
	 public void run(String...args) throws Exception {
	        this.UserDetailsRepository.save(new UserDetails("jithingijo@gmail.com","Jithin Gijo","972 Moy Avenue, Windsor",25,"Password1"));
	        this.UserDetailsRepository.save(new UserDetails("jiffingijo@gmail.com","Jiffin Gijo","Adoor",19,"Password2"));
	        this.ServerRepository.save(new Server(1123L,"192.168.1.160","Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/server1.png ",Status.SERVER_UP.toString()));
	        this.ServerRepository.save(new Server(1333L,"192.168.0.1","Microsoft", "24 GB", "Personal PC", "http://localhost:8080/server/image/server2.png ",Status.SERVER_UP.toString()));

	    }

}
