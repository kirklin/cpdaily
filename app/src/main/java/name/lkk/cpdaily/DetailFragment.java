package name.lkk.cpdaily;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import name.lkk.cpdaily.databinding.FragmentDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    MainViewModel mainViewModel;
    private FragmentDetailBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mainViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getActivity().getApplication(), this))
                .get(MainViewModel.class);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_menu,menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar1);
        //设置APPBar
        binding.toolbar1.setNavigationIcon(R.drawable.ic_baseline_arrow_back_ios_24);
        binding.toolbar1.setTitle(" ");
        binding.toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_detailFragment_to_leaveFragment2);
            }
        });
        //动态时间
        new TimeThread().start();//启动线程


       String name = getArguments().getString("name");
       //审批申请人
        binding.detailContent2Layout.textView56.setText(name+" - 发起申请");
       // 审批催办人
        binding.detailContent2Layout.textView57.setText(name+" - 发起催办");
        //开始时间
        binding.detailContent1Layout.textView51.setText(getArguments().getString("text2"));

        //结束时间
        binding.detailContent1Layout.textView52.setText(getArguments().getString("text3"));

        //紧急联系人
        binding.detailContent1Layout.textView53.setText(getArguments().getString("text4"));

        //请假原因
        binding.detailContent1Layout.textView54.setText(getArguments().getString("text5"));
        //申请位置
        binding.detailContent1Layout.textView12.setText(getArguments().getString("text10"));

        //审批流程
        binding.detailContent1Layout.textView55.setText(getArguments().getString("text6"));

        binding.detailContent2Layout.textView20.setText(getArguments().getString("text7"));

        binding.detailContent2Layout.textView21.setText(getArguments().getString("text8"));
        binding.detailContent2Layout.textView22.setText(getArguments().getString("text9"));
        //审批人
        binding.detailContent2Layout.textView13.setText(getArguments().getString("text11"));
    }

    //写一个新的线程每隔一秒发送一次消息,这样做会和系统时间相差1秒
    public class TimeThread extends Thread{
        @Override
        public void run() {
            super.run();
            do{
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);

        }
    }
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    binding.time.setText("当前时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
                    break;
            }
            return false;
        }
    });

}