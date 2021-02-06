package ci.ahmadfauzirahman.bonding.api.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import java.util.HashMap;

import ci.ahmadfauzirahman.bonding.model.AkunModel;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context _context;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String NIK = "nik";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String namaLengkap = "nama_lengkap";
    public static final String EMAIL = "email";
    public static final String TELEPON = "telp";
    public static final String ROLE = "role";

    public Context getContext() {
        return _context;
    }

    public SessionManager(Context context) {
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(AkunModel akunModel) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(NIK, String.valueOf(akunModel.getNik()));
        editor.putString(USERNAME, akunModel.getUsername());
        editor.putString(PASSWORD, akunModel.getPassword());
        editor.putString(namaLengkap, akunModel.getNamaLengkap());
        editor.putString(EMAIL, akunModel.getEmail());
        editor.putString(TELEPON, akunModel.getTelepon());
        editor.putString(ROLE, akunModel.getRole());
        editor.commit();

    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(NIK, sharedPreferences.getString(NIK, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD, null));
        user.put(namaLengkap, sharedPreferences.getString(namaLengkap, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(ROLE, sharedPreferences.getString(ROLE, null));
        user.put(TELEPON, sharedPreferences.getString(TELEPON, null));
        return user;
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }


}
