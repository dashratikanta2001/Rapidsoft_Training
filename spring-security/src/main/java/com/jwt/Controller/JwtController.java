package com.jwt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.helper.JwtUtil;
import com.jwt.models.JwtRequest;
import com.jwt.models.JwtResponse;
import com.jwt.service.CustomUserDetailsService;

@RestController
@RequestMapping("/")
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/hh")
	public String hh()
	{
		return "Working";
	}
	
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.err.println("Error");
		}
			
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	
	
//	
////	
//	@PostMapping("/token")
//	public ResponseEntity<?> generateToken1(@RequestBody JwtRequest jwtRequest) throws Exception
//	{
//		
////		System.out.println(jwtRequest);
//
////		try {
////			this.authenticationManager.authenticate(
////					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
////		} catch (UsernameNotFoundException e) {
////			e.printStackTrace();
////			throw new Exception("Bad Credentials");
////		} catch (BadCredentialsException e) {
////			e.printStackTrace();
////			throw new Exception("Bad Credentials");
////		}
////		
////		System.out.println(jwtRequest);
////
////			
////		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
////		String token = this.jwtUtil.generateToken(userDetails);
////		System.out.println(token);
////		
////		return ResponseEntity.ok(new JwtResponse(token));
//		
//		try {
////			this.authenticationManager.authenticate(
////					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
//			System.out.println("Entered to first step");
//			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword());
//			
//			System.out.println("Auth token = \n"+authenticationToken);
//			System.out.println("Entered to 1st 2nd  step");
//			authenticationManager.authenticate(authenticationToken);
//			System.out.println("Entered to 2nd step");
//			
//		} catch (UsernameNotFoundException e) {
//			// TODO: handle exception
////			e.printStackTrace();
//			System.out.println("Username not found");
//			throw new Exception("Bad cridentials");
//		}
//		catch (BadCredentialsException e) {
//			// TODO: handle exception
////			e.printStackTrace();
//			
//			System.out.println("Bad cridentials");
//			throw new Exception("Bad cridentials");
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			
//			System.out.println("Something went wrong.");
//		}
//		System.out.println("Entered to 3rd step");
//
//		UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
//		System.out.println("Entered to 4th step");
//
//		String token = jwtUtil.generateToken(userDetails);
//		System.out.println("Entered to 5th step");
//		
//		
////		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
////		String token = this.jwtUtil.generateToken(userDetails);
////		System.out.println(token);
//
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
	
	
	
	
}










