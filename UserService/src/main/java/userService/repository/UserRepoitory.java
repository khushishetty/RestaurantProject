package userService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import userService.model.UserModel;

public interface UserRepoitory extends CrudRepository<UserModel, String> {
	
	public List<UserModel> findByPassword(String password);

}
