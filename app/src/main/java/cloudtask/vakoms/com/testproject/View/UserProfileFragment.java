package cloudtask.vakoms.com.testproject.View;


import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cloudtask.vakoms.com.testproject.R;
import cloudtask.vakoms.com.testproject.data.UserProfileViewModel;
import cloudtask.vakoms.com.testproject.databases.User;


public class UserProfileFragment extends LifecycleFragment {

    @BindView(R.id.id)
    TextView tvId;

    @BindView(R.id.first_name)
    TextView tvFirstName;

    @BindView(R.id.last_name)
    TextView tvLastName;


    private UserProfileViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(1, getActivity());
        viewModel.getUser().observe(this, user -> {
            if (user != null) {
                updateUI(user);
            }
        });
    }

    private void updateUI(User user) {
        tvId.setText(String.valueOf(user.getUid()));
        tvFirstName.setText(user.getFirstName());
        tvLastName.setText(user.getLastName());
    }
}
