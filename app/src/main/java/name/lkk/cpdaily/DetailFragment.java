package name.lkk.cpdaily;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import name.lkk.cpdaily.databinding.FragmentDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

        //审批流程
        binding.detailContent1Layout.textView55.setText(getArguments().getString("text6"));

        binding.detailContent2Layout.textView20.setText(getArguments().getString("text7"));

        binding.detailContent2Layout.textView21.setText(getArguments().getString("text8"));
        binding.detailContent2Layout.textView22.setText(getArguments().getString("text9"));


    }
}