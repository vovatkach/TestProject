package cloudtask.vakoms.com.testproject.data;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import cloudtask.vakoms.com.testproject.databases.User;

/**
 * Created by tkach on 29.06.17.
 */

public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;

    public void init(int userId, Activity activity) {
        if (this.user != null) {
            return;
        }
        UserRepository userRepository = new UserRepository();
        user=userRepository.getUser(userId, activity);
    }

    public LiveData<User> getUser() {
        return user;
    }
}
