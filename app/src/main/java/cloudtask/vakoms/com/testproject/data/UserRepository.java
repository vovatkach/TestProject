package cloudtask.vakoms.com.testproject.data;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;

import cloudtask.vakoms.com.testproject.databases.AppDatabase;
import cloudtask.vakoms.com.testproject.databases.User;

/**
 * Created by tkach on 29.06.17.
 */

public class UserRepository {

    public LiveData<User> getUser(int userId, Activity activity) {
        final MutableLiveData<User> data = new MutableLiveData<>();

        AppDatabase database = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "db").build();
        database.userDao().insertUser(new User("Vova", "Tkach"));
        database.userDao().insertUser(new User("Vova", "Tkach"));
        database.userDao().insertUser(new User("Vova", "Tkach"));
        database.userDao().insertUser(new User("Vova", "Tkach"));
        User user = database.userDao().getUsers().get(userId);
        data.setValue(user);
        return data;
    }
}
