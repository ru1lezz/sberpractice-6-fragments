package fragments.serzhan.com.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {
    private Button button;
    private IActivityCallbacks mIActivityCallbacks;
    private String data;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mIActivityCallbacks = ((MainActivity) context);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.button);
        initListeners();
    }

    private void initListeners() {
        button.setOnClickListener((v) -> {
            mIActivityCallbacks.pressButton();
            Bundle bundle = new Bundle();
            bundle.putString("RANDOM_NUMBERS", data);
            getChildFragmentManager().beginTransaction()
                    .add(R.id.fragmentTextView, BlankFragment.newInstance(bundle))
                    .commitNow();
        });
    }

    public void setData(String data) {
        this.data = data;
    }

    public static ButtonFragment newInstance() {
        ButtonFragment buttonFragment = new ButtonFragment();
        return buttonFragment;
    }

    public static ButtonFragment newInstance(Bundle bundle) {
        ButtonFragment buttonFragment = new ButtonFragment();
        buttonFragment.setArguments(bundle);
        return buttonFragment;
    }
}
