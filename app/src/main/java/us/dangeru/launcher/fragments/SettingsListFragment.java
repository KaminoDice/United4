package us.dangeru.launcher.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import us.dangeru.launcher.R;
import us.dangeru.launcher.activities.HiddenSettingsActivity;
import us.dangeru.launcher.utils.PropertiesSingleton;

/**
 * Created by Niles on 8/21/17.
 */

public class SettingsListFragment extends Fragment implements HiddenSettingsFragment {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View res = inflater.inflate(R.layout.hidden_settings_list, container, false);
        res.post(new Runnable() {
            @Override
            public void run() {
                ListView list = res.findViewById(R.id.settings_list);
                String debug = PropertiesSingleton.get().getProperty("debug");
                if (debug.isEmpty()) debug = "false";
                String userscript = PropertiesSingleton.get().getProperty("userscript");
                if (userscript.isEmpty()) debug = "false";
                final String[] settings = new String[] { "Janitor Login", "Reset all preferences", "Toggle debug button, currently " + debug, "Toggle userscript, currently " + userscript };
                list.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, settings));
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        switch (i) {
                            case 0:
                                ((HiddenSettingsActivity) getActivity()).swapScreens(HiddenSettingsActivity.FragmentType.JANITOR_LOGIN);
                                break;
                            case 1:
                                PropertiesSingleton.get().resetAllAndExit(getFragmentManager());
                                break;
                            case 2:
                                //noinspection CallToNumericToString
                                PropertiesSingleton.get().setProperty("debug", Boolean.valueOf(!Boolean.valueOf(PropertiesSingleton.get().getProperty("debug"))).toString());
                                run();
                                break;
                            case 3:
                                //noinspection CallToNumericToString
                                PropertiesSingleton.get().setProperty("userscript", Boolean.valueOf(!Boolean.valueOf(PropertiesSingleton.get().getProperty("userscript"))).toString());
                                run();
                                break;
                            default:
                                GenericAlertDialogFragment.newInstance("Should never happen", getFragmentManager());
                                break;
                        }
                    }
                });
            }
        });
        return res;
    }

    @Override
    public HiddenSettingsActivity.FragmentType getType() {
        return HiddenSettingsActivity.FragmentType.SETTINGS_LIST;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.hidden_settings_menu, menu);
    }
}