package name.lkk.cpdaily;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateHandle;

import name.lkk.cpdaily.databinding.FragmentAddBinding;

public class MainViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    SavedStateHandle handle;
    String key = getApplication().getResources().getString(R.string.user_name);
    String key2 = getApplication().getResources().getString(R.string.shp_num);
    String key3 = getApplication().getResources().getString(R.string.shp_reason);
    String key4 = getApplication().getResources().getString(R.string.shp_local);
    String key5 = getApplication().getResources().getString(R.string.shp_fdy);

    String shpName = getApplication().getResources().getString(R.string.shp_name);

    public MainViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)&&!handle.contains(key2)&&!handle.contains(key3)) {
            load();
        }
    }

    public String getData() {
        return handle.get(key);
    }

    public String getNum() {
        return handle.get(key2);
    }

    public String getReason() {
        return handle.get(key3);
    }
    public String getLocal() {
        return handle.get(key4);
    }
    public String getFdy() {
        return handle.get(key5);
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        String name = shp.getString(key, "你的名字");
        String num = shp.getString(key2, "");
        String reason = shp.getString(key3, "原因：\n");
        String local = shp.getString(key4, "中国");
        String fdy = shp.getString(key5, "一级：[辅导员]XXX - 审批");

        handle.set(key, name);
        handle.set(key2, num);
        handle.set(key3, reason);
        handle.set(key4, local);
        handle.set(key5, fdy);
    }

    void save(FragmentAddBinding binding) {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString(key, String.valueOf(binding.editTextTextPersonName3.getText()));
        //紧急联系人
        editor.putString(key2, String.valueOf(binding.editTextTextPersonName4.getText()));
        //请假原因
        editor.putString(key3, String.valueOf(binding.editTextTextPersonName5.getText()));
        //请假位置
        editor.putString(key4, String.valueOf(binding.editTextTextPersonName6.getText()));
        //辅导员
        editor.putString(key5, String.valueOf(binding.editTextTextPersonName7.getText()));


        editor.apply();
    }


}