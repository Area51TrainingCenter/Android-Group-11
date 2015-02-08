package pe.area51.clasefacebook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

public class MainFragment extends Fragment {

    // Este objeto nos ayudará a notificar al SDK de Facebook los cambios en el ciclo de vida del fragment.
    private UiLifecycleHelper uiLifecycleHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiLifecycleHelper = new UiLifecycleHelper(getActivity(), callback);
        uiLifecycleHelper.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Session session = Session.getActiveSession();
        if (session != null && (session.isOpened() || session.isClosed())) {
            onSessionStateChange(session, session.getState(), null);
        }
        uiLifecycleHelper.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        uiLifecycleHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiLifecycleHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiLifecycleHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiLifecycleHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.fragment_layout_loginbutton);
        // Por defecto se pide de forma automática el permiso para leer el perfil público, sin embargo si se quiere agregar más permisos se puede hacer de la siguiente forma.
        loginButton.setReadPermissions("public_profile");
        loginButton.setFragment(this);
        return view;
    }

    private Session.StatusCallback callback = new Session.StatusCallback() {

        @Override
        public void call(Session session, SessionState sessionState, Exception e) {
            onSessionStateChange(session, sessionState, e);
        }
    };

    private void onSessionStateChange(Session session, SessionState sessionState, Exception e) {
        if (session.isClosed()) {
            Log.d("MainFragment", "Facebook session closed");
        } else if (session.isOpened()) {
            Log.d("MainFragment", "Facebook session opened");
            //Si la sesión está abierta, haremos una consulta para obtener los datos del usuario.
            Request.newMeRequest(session, new Request.GraphUserCallback() {
                @Override
                public void onCompleted(GraphUser graphUser, Response response) {
                    Toast.makeText(getActivity(), getString(R.string.user_name, graphUser.getName()), Toast.LENGTH_SHORT).show();
                }
            }).executeAsync();
        }
    }
}
