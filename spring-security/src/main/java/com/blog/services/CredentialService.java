package com.blog.services;

import com.blog.dto.UserDto;
import com.blog.response.Response;

public interface CredentialService {

	Response<?> addUserCredential(UserDto userDto);
}
