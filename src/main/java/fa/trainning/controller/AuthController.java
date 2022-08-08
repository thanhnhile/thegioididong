package fa.trainning.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fa.trainning.dto.AccountDto;
import fa.trainning.dto.AccountTokenResponse;
import fa.trainning.entity.Account;
import fa.trainning.security.JwtTokenUtil;

@RestController
public class AuthController {
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	
	@PostMapping("/login/access")
	public ResponseEntity<?> login(@RequestBody @Valid AccountDto accountDto) {
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							accountDto.getUsername(), accountDto.getPassword())
			);
			
			Account account = (Account) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(account);
			AccountTokenResponse response = new AccountTokenResponse(account.getUsername(), accessToken);
			
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
