package com.caseyjbrooks.searchbox.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.caseyjbrooks.clog.Clog;
import com.caseyjbrooks.searchbox.Searchbox;

public class BlankFragment extends Fragment {

    public static Fragment getInstance() {
        Fragment blankFragment = new BlankFragment();
        Bundle args = new Bundle();
        blankFragment.setArguments(args);
        return blankFragment;
    }

    public BlankFragment() {
    }

// Data members
//--------------------------------------------------------------------------------------------------

    FloatingActionButton fab;
    Searchbox searchbox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        searchbox = (Searchbox) view.findViewById(R.id.searchbox);
        fab = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchbox.isRevealed()) {
                    searchbox.hide(getActivity());
                }
                else {
                    searchbox.setSearchboxListener(listener);
                    searchbox.reveal(getActivity());
                }
            }
        });

        return view;
    }

    Searchbox.SearchboxListener listener = new Searchbox.SearchboxListener() {
        @Override
        public boolean onSearch(String query) {
            Clog.i("Searchbox", "A search query was submitted: #{$1}", query);
            return false;
        }

        @Override
        public void onQueryChanged(String query) {
            Clog.i("Searchbox", "The search query was changed: #{$1}", query);
        }

        @Override
        public boolean onSearchMenuItemSelected(MenuItem selectedItem) {
            switch(selectedItem.getItemId()) {
            case R.id.menu_viewAsList:
                Clog.i("Menu item 'View As List' was selected");
                return true;
            case R.id.menu_viewAsGrid:
                Clog.i("Menu item 'View As Grid' was selected");
                return true;
            default:
                return false;
            }
        }
    };
}
