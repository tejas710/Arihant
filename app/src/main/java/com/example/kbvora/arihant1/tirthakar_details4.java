package com.example.kbvora.arihant1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link tirthakar_details4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tirthakar_details4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
String mParam3,mParam4;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener3 mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tirthakar_details4.
     */
    // TODO: Rename and change types and number of parameters
    public static tirthakar_details4 newInstance(String param1, String param2) {
        tirthakar_details4 fragment = new tirthakar_details4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public tirthakar_details4() {
        // Required empty public constructor
    }
    TextView tv1,tv2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tirthakar_details4, container, false);
        tv1=(TextView)view.findViewById(R.id.lblstavan_fragment_tirthankar_details4);
        tv2=(TextView)view.findViewById(R.id.lblstuti_fragment_tirthankar_details4);
        mParam3=mParam1.substring(19,mParam1.length());
        mParam4=mParam2.substring(19,mParam2.length());
        tv1.setText(mParam3);
        tv2.setText(mParam4);
        tv1.setSelected(true);
        tv2.setSelected(true);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(tirthakar_details4.this.getActivity(),audiostavntirthankar.class);
                it.putExtra("path",mParam1+"");
                startActivity(it);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(tirthakar_details4.this.getActivity(),audiostavntirthankar.class);
                it1.putExtra("path",mParam2+"");
                startActivity(it1);
            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction3(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener3) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener3 {
        // TODO: Update argument type and name
        public void onFragmentInteraction3(Uri uri);
    }

}
