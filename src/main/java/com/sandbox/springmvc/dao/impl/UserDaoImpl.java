package com.sandbox.springmvc.dao.impl;

import com.sandbox.springmvc.dao.UserDao;
import com.sandbox.springmvc.model.RegisteredUser;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Class UserDaoImpl.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#findById(java.lang.Long)
   */
  @Override
  public RegisteredUser findById(Long id) {
    return getEntityManager().find(RegisteredUser.class, id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#saveUser(com.sandbox.springmvc.model.RegisteredUser)
   */
  @Override
  public void saveUser(RegisteredUser user) {
    persist(user);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#updateUser(com.sandbox.springmvc.model.RegisteredUser)
   */
  @Override
  public void updateUser(RegisteredUser user) {
    update(user);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#deleteUserById(java.lang.Long)
   */
  @Override
  public void deleteUserById(Long id) {
    javax.persistence.Query query =
        getEntityManager().createNativeQuery("delete from RegisteredUser where id =" + id);
    query.executeUpdate();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#findAllUsers()
   */
  @Override
  public List<RegisteredUser> findAllUsers() {
    return getEntityManager().createQuery("select a from RegisteredUser a", RegisteredUser.class)
        .getResultList();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#deleteAllUsers()
   */
  @Override
  public void deleteAllUsers() {
    javax.persistence.Query query =
        getEntityManager().createNativeQuery("delete from RegisteredUser");
    query.executeUpdate();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.sandbox.springmvc.dao.UserDao#isUserExist(com.sandbox.springmvc.model.RegisteredUser)
   */
  @Override
  public boolean isUserExist(RegisteredUser user) {
    return user.getId() != null && findById(user.getId()) != null;
  }

}
