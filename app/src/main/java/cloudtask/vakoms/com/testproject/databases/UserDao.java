package cloudtask.vakoms.com.testproject.databases;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by tkach on 29.06.17.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Insert
    void insertUser(User user);

    @Delete
    void delete(User user);
}
