package com.example.kbvora.arihant1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link tirthankar_details5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tirthankar_details5 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;

    private OnFragmentInteractionListener4 mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tirthankar_details5.
     */
    // TODO: Rename and change types and number of parameters
    public static tirthankar_details5 newInstance(String param1, String param2, String param3, String param4, String param5) {
        tirthankar_details5 fragment = new tirthankar_details5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        fragment.setArguments(args);
        return fragment;
    }

    public tirthankar_details5() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
        }
    }
    ImageView img1,img2,img3,img4,img5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tirthankar_details5, container, false);

        img1=(ImageView)view.findViewById(R.id.imgphoto1_fragment_tirthankar_details5);
        img2=(ImageView)view.findViewById(R.id.imgphoto2_fragment_tirthankar_details5);
        img3=(ImageView)view.findViewById(R.id.imgphoto3_fragment_tirthankar_details5);
        img4=(ImageView)view.findViewById(R.id.imgphoto4_fragment_tirthankar_details5);
        img5=(ImageView)view.findViewById(R.id.imgphoto5_fragment_tirthankar_details5);

        if(mParam1!="") {
            Picasso.with(getActivity()).load(mParam1).into(img1);
        }
        else
        {
            img1.setVisibility(View.INVISIBLE);
        }
        if(mParam2!="") {
            Picasso.with(getActivity()).load(mParam2).into(img2);
        }
        else
        {
            img2.setVisibility(View.INVISIBLE);
        }
        if(mParam3!="") {
            Picasso.with(getActivity()).load(mParam3).into(img3);
        }
        else
        {
            img3.setVisibility(View.INVISIBLE);
        }
        if(mParam4!="") {
            Picasso.with(getActivity()).load(mParam4).into(img4);
        }
        else
        {
            img4.setVisibility(View.INVISIBLE);
        }
        if(!(mParam5.equals(null)|| mParam5.equals(""))) {
            Picasso.with(getActivity()).load(mParam5).into(img5);
        }
        else
        {
            img5.setVisibility(View.INVISIBLE);
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction4(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener4) activity;
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
    public interface OnFragmentInteractionListener4 {
        // TODO: Update argument type and name
        public void onFragmentInteraction4(Uri uri);
    }

}
