package fragments.serzhan.com.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {

    private TextView textView;

    public BlankFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.textView1);
        textView.clearComposingText();
        textView.setText(getArguments().getString("RANDOM_NUMBERS"));
    }

    public static BlankFragment newIntance() {
        return new BlankFragment();
    }

    public static BlankFragment newInstance(Bundle bundle) {
        BlankFragment blankFragment = new BlankFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }
}