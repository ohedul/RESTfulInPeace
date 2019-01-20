package rokomari.project.controllers;

/*
 * This controller class is created for Admin and general
 * user section*/
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/page")
public class UserController {

	
	@GetMapping("/page/users")
	public String userPage() {
		return "This is for users.";
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/page/admins")
	public String adminPage() {
		return "This is for admins";
	}
	

}
