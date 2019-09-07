package club.zylearn.sharding.dao;

import org.springframework.dao.DataAccessException;

import club.zylearn.sharding.vo.Person;

public interface IPersonDAO {
	public int doCreate(Person vo) throws DataAccessException;
	public Person findById(Long id) throws DataAccessException;
	public int doUpdate(Person vo) throws DataAccessException;
}
