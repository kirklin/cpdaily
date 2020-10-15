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

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        String name = shp.getString(key, "你的名字");
        String num = shp.getString(key2, "");
        String reason = shp.getString(key3, "原因：\n目的地：\n出行方式：\n");
        handle.set(key, name);
        handle.set(key2, num);
        handle.set(key3, reason);
    }

    void save(FragmentAddBinding binding) {
        SharedPreferences shp = getApplication().getSharedPreferences(shpName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString(key, String.valueOf(binding.editTextTextPersonName3.getText()));
        //紧急联系人
        editor.putString(key2, String.valueOf(binding.editTextTextPersonName4.getText()));
        //请假原因
        editor.putString(key3, String.valueOf(binding.editTextTextPersonName5.getText()));
        editor.apply();
    }


}