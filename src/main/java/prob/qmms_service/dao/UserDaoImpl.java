package prob.qmms_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import prob.qmms_service.models.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public User getUser(String userId) {
        Optional<User> user = Optional.ofNullable(em.find(User.class,userId));
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new NoResultException("User with id " +userId +" not found!");
        }

    }
            }
