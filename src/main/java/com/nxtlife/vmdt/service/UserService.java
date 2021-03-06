package com.nxtlife.vmdt.service;


import com.nxtlife.vmdt.view.SuccessResponse;
import com.nxtlife.vmdt.view.user.UserRequest;
import com.nxtlife.vmdt.view.user.UserResponse;
import com.nxtlife.vmdt.ex.*;
import com.nxtlife.vmdt.view.user.security.PasswordRequest;

import java.util.List;

public interface UserService {

	/**
	 * this method used to save user detail.
	 * 
	 * @param request
	 * @return <tt>UserResponse</tt>
	 * @throws ValidationException
	 *             if role ids are not valid or username or email or contact
	 *             number already exist
	 */
	public UserResponse save(UserRequest request);

	/**
	 * this method used to fetch user details
	 * 
	 * @return list of <tt>UserResponse</tt>
	 */
	public List<UserResponse> findAll();

	/**
	 * this method used to fetch user details by id
	 * 
	 * @param id
	 * @return {@link UserResponse}
	 */
	public UserResponse findById(Long id);

	/**
	 * this method used to fetch user details using auth token
	 * 
	 * @return <tt>UserResponse</tt>
	 * @throws NotFoundException
	 *             - if user not found
	 */
	public UserResponse findByAuthentication();

	/**
	 * this method used to update user info.
	 * 
	 * @param userId
	 * @param request
	 * @return {@link UserResponse}
	 * @throws NotFoundException
	 *             if user not found
	 * @throws ValidationException
	 *             if request body aren't valid like email or contact number or
	 *             empty body or role ids are not valid or email or contact
	 *             number already exists
	 */
	public UserResponse update(Long userId, UserRequest request);

	/**
	 * this method used change password using email or contact.
	 * 
	 * @param username
	 * @return <tt>SuccessResponse</tt> - success message
	 * @throws ValidationException
	 *             if username pattern didn't match or email or contact not
	 *             registered with us
	 * @throws NotFoundException
	 *             if username not found
	 */
	public SuccessResponse forgotPassword(String username);

	/**
	 * this method used to match generated password for change password.
	 * 
	 * @param username
	 * @param generatedPassword
	 * @return <tt>SuccessResponse</tt> - success message
	 * @throws ValidationException
	 *             if generated password didn't match
	 * @throws NotFoundException
	 *             if username not found
	 * 
	 */
	public SuccessResponse matchGeneratedPassword(String username, String generatedPassword);

	/**
	 * this method used to change password using generated password
	 * 
	 * @param request
	 *            - key value pair of generated password and username
	 * @return <tt>SuccessResponse</tt> - success message
	 * @throws ValidationException
	 *             if generated password didn't match
	 */
	public SuccessResponse changePasswordByGeneratedPassword(PasswordRequest request);

	/**
	 * this method used to change password using old password
	 * 
	 * @param request
	 *            - key value pair of old password
	 * @return <tt>SuccessResponse</tt> - success message
	 * @throws ValidationException
	 *             if old password is not correct
	 * @throws NotFoundException
	 *             if user not found with password
	 */
	public SuccessResponse changePassword(PasswordRequest request);


	/**
	 * this method used to activate user successfully. If user not found it
	 * throws exception.
	 * 
	 * @param id
	 * @return {@link SuccessResponse} - success message if user activated
	 *         successfully
	 * @throws NotFoundException
	 *             if user not found
	 */
	public SuccessResponse activate(Long id);

	/**
	 * this method used to delete user successfully. If user not found it throws
	 * exception.
	 * 
	 * @param id
	 * @return {@link SuccessResponse} - success message if user deleted
	 *         successfully
	 * @throws NotFoundException
	 *             if user not found
	 */
	public SuccessResponse delete(Long id);

}
