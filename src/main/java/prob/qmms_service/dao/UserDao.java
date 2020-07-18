package prob.qmms_service.dao;

import prob.qmms_service.models.User;

import javax.persistence.NoResultException;

public interface UserDao {
    public User getUser(String userId) throws NoResultException;
}
