package pens.lab.app.belajaractivity.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.Nullable;

import java.util.List;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.list.ListActivity;
import pens.lab.app.belajaractivity.modul.profile.ProfileActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;


    public LoginFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();

        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnLogin = fragmentView.findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLoginClick();
            }
        });

        setTitle("My Login View");

        return fragmentView;
    }

    public void setBtLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email,password);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile() {
            Bundle bundle = new Bundle();
            bundle.putString("email", etEmail.getText().toString());
            bundle.putString("password", etPassword.getText().toString());
            Intent intent = new Intent(activity, ListActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
            activity.finish();
    }

    @Override
    public void redirectToMainList() {
        Bundle bundle = new Bundle();
        bundle.putString("email", etEmail.getText().toString());
        bundle.putString("password", etPassword.getText().toString());
        Intent intent = new Intent(activity, ListActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
        activity.finish();
    }

}
