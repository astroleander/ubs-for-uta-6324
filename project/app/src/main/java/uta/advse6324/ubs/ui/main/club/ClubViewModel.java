package uta.advse6324.ubs.ui.main.club;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

import javax.net.ssl.SSLSession;

import uta.advse6324.ubs.db.ClubDBHelper;
import uta.advse6324.ubs.db.PostDBHelper;
import uta.advse6324.ubs.pojo.Club;
import uta.advse6324.ubs.pojo.Post;

public class ClubViewModel  extends AndroidViewModel {
    private ClubDBHelper dbhelper;
    private MutableLiveData<ArrayList<Club>> mClubList;

    public ClubViewModel(Application application) {
        super(application);
        mClubList = new MutableLiveData<>();
        dbhelper = new ClubDBHelper(getApplication().getApplicationContext());
        dbhelper.onCreate(dbhelper.getReadableDatabase());
//        dbhelper.insert(new Club("club0", "yxz", "music","This is a introduction of club0"));
//        dbhelper.insert(new Club("club1", "yxz", "sport","This is a introduction of club1"));
        Club[] list = dbhelper.queryAllClub();
        ArrayList<Club> arr = new ArrayList<>(Arrays.asList(list));
        dbhelper.close();
        mClubList.setValue(arr);
    }

    public LiveData<ArrayList<Club>> getList() {
        return mClubList;
    }
}