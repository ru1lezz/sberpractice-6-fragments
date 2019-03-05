package fragments.serzhan.com.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class EditTextFragment extends Fragment {

    private EditText editText;
    private IActivityCallbacks iActivityCallbacks;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            iActivityCallbacks = ((MainActivity) context);
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
        View view = inflater.inflate(R.layout.fragment_edit_text, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public String getData() {
        return editText.getText().toString();
    }

    public static EditTextFragment newInstance() {
        EditTextFragment editTextFragment = new EditTextFragment();
        return editTextFragment;
    }

    public static EditTextFragment newInstance(Bundle bundle) {
        EditTextFragment editTextFragment = new EditTextFragment();
        editTextFragment.setArguments(bundle);
        return editTextFragment;
    }

}
