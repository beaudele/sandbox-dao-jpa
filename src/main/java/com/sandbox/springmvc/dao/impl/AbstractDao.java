package com.sandbox.springmvc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * The Class AbstractDao.
 */
public abstract class AbstractDao {

  /** The manager. */
  @PersistenceContext
  private EntityManager manager;

  /**
   * Gets the entity manager.
   *
   * @return the entity manager
   */
  protected EntityManager getEntityManager() {
    return manager;
  }

  /**
   * Persist.
   *
   * @param entity the entity
   */
  public void persist(Object entity) {
    getEntityManager().persist(entity);
  }

  /**
   * Delete.
   *
   * @param entity the entity
   */
  public void delete(Object entity) {
    getEntityManager().remove(entity);
  }

  /**
   * Update.
   *
   * @param entity the entity
   */
  public void update(Object entity) {
    getEntityManager().merge(entity);
  }
}
