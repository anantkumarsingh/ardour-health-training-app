package com.app.atl_test_app_1.ui.account;

import static com.app.atl_test_app_1.database.UserDB.USERS_TABLE;
import static com.app.atl_test_app_1.database.UserDB.USER_ADDRESS;
import static com.app.atl_test_app_1.database.UserDB.USER_ID;
import static com.app.atl_test_app_1.database.UserDB.USER_MOBILE;
import static com.app.atl_test_app_1.database.UserDB.USER_NAME;

import androidx.lifecycle.ViewModelProvider;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.atl_test_app_1.R;
import com.app.atl_test_app_1.database.UserDB;
import com.app.atl_test_app_1.database.VisorDB;
import com.app.atl_test_app_1.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {
    private UserDB userDB;
    private TextView nameView;
    private TextView emailView;
    private TextView addressView;
    private TextView phoneView;
    private TextView weightView;


    private String userName;
    private String userId;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userWt;

    private FragmentAccountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AccountViewModel dashboardViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        userDB = new UserDB(getActivity());
        nameView = root.findViewById(R.id.user_name_acc);
        emailView = root.findViewById(R.id.user_email_acc);
        addressView = root.findViewById(R.id.user_adr_acc);
        phoneView = root.findViewById(R.id.user_phone_acc);
        weightView = root.findViewById(R.id.user_wt_acc);



        if (getArguments() != null) {
            userId = getArguments().getString("user_id_intent");
        }




        //SET USERNAME
        String  getUserInfoQuery = ("SELECT * FROM " + USERS_TABLE + " WHERE " + USER_ID + " = '"+userId+"'");
        Cursor cursor = userDB.getReadableDatabase().rawQuery(getUserInfoQuery, null);
        if (cursor.moveToFirst()){
            userName = cursor.getString(cursor.getColumnIndexOrThrow(USER_NAME));
            userEmail = userId;
            userPhone = cursor.getString(cursor.getColumnIndexOrThrow(USER_MOBILE));
            userAddress = cursor.getString(cursor.getColumnIndexOrThrow(USER_ADDRESS));

        }else{

        }cursor.close();

        if (userName==null){
            userName="";
        }
        if (userEmail==null){
            userEmail="";
        }
        if (userPhone==null){
            userPhone="";
        }
        if (userAddress==null){
            userAddress="";
        }

        nameView.setText(userName);
        phoneView.setText("+91 "+userPhone);
        addressView.setText(userAddress);
        emailView.setText(userEmail);










        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}