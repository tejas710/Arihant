package com.example.kbvora.arihant1;

import android.app.Activity;
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
 * Use the {@link tirthankar_details2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tirthankar_details2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6 = "param6";
    private static final String ARG_PARAM7 = "param7";
    private static final String ARG_PARAM8 = "param8";
    private static final String ARG_PARAM9 = "param9";
    private static final String ARG_PARAM10 = "param10";
    private static final String ARG_PARAM11= "param11";
    private static final String ARG_PARAM12 = "param12";
    private static final String ARG_PARAM13 = "param13";
    private static final String ARG_PARAM14 = "param14";
    private static final String ARG_PARAM15 = "param15";
    private static final String ARG_PARAM16 = "param16";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String mParam5;
    private String mParam6;
    private String mParam7;
    private String mParam8;
    private String mParam9;
    private String mParam10;
    private String mParam11;
    private String mParam12;
    private String mParam13;
    private String mParam14;
    private String mParam15;
    private String mParam16;


    private OnFragmentInteractionListener1 mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tirthankar_details2.
     */
    // TODO: Rename and change types and number of parameters
    public static tirthankar_details2 newInstance(String param1, String param2,String param3,String param4,String param5,String param6,String param7,String param8,String param9,String param10,String param11,String param12,String param13,String param14,String param15,String param16) {
        tirthankar_details2 fragment = new tirthankar_details2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7, param7);
        args.putString(ARG_PARAM8, param8);
        args.putString(ARG_PARAM9, param9);
        args.putString(ARG_PARAM10, param10);
        args.putString(ARG_PARAM11, param11);
        args.putString(ARG_PARAM12, param12);
        args.putString(ARG_PARAM13, param13);
        args.putString(ARG_PARAM14, param14);
        args.putString(ARG_PARAM15, param15);
        args.putString(ARG_PARAM16, param16);

        fragment.setArguments(args);
        return fragment;
    }

    public tirthankar_details2() {
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
            mParam6 = getArguments().getString(ARG_PARAM6);
            mParam7 = getArguments().getString(ARG_PARAM7);
            mParam8 = getArguments().getString(ARG_PARAM8);
            mParam9 = getArguments().getString(ARG_PARAM9);
            mParam10 = getArguments().getString(ARG_PARAM10);
            mParam11= getArguments().getString(ARG_PARAM11);
            mParam12 = getArguments().getString(ARG_PARAM12);
            mParam13 = getArguments().getString(ARG_PARAM13);
            mParam14 = getArguments().getString(ARG_PARAM14);
            mParam15 = getArguments().getString(ARG_PARAM15);
            mParam16 = getArguments().getString(ARG_PARAM16);
        }
    }
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tirthankar_details2, container, false);
        tv1=(TextView)view.findViewById(R.id.lblchyvandate_fragment_tirthankar_details2);
        tv2=(TextView)view.findViewById(R.id.lbljanmadate_fragment_tirthankar_details2);
        tv3=(TextView)view.findViewById(R.id.lbldikshadate_fragment_tirthankar_details2);
        tv4=(TextView)view.findViewById(R.id.lblkevalgyandate_fragment_tirthankar_details2);
        tv5=(TextView)view.findViewById(R.id.lblmokshadate_fragment_tirthankar_details2);
        tv6=(TextView)view.findViewById(R.id.lblheven_fragment_tirthankar_details2);
        tv7=(TextView)view.findViewById(R.id.lblbirthplace_fragment_tirthankar_details2);
        tv8=(TextView)view.findViewById(R.id.lblparents_fragment_tirthankar_details2);
        tv9=(TextView)view.findViewById(R.id.lblcomplex_fragment_tirthankar_details2);
        tv10=(TextView)view.findViewById(R.id.lblsymbol_fragment_tirthankar_details2);
        tv11=(TextView)view.findViewById(R.id.lblheight_fragment_tirthankar_details2);
        tv12=(TextView)view.findViewById(R.id.lblage_fragment_tirthankar_details2);
        tv13=(TextView)view.findViewById(R.id.lbltree_fragment_tirthankar_details2);
        tv14=(TextView)view.findViewById(R.id.lblattentsprits_fragment_tirthankar_details2);
        tv15=(TextView)view.findViewById(R.id.lbldisciple_fragment_tirthankar_details2);
        tv16=(TextView)view.findViewById(R.id.lblnorvanplace_fragment_tirthankar_details2);

        tv1.setText(mParam1);
        tv2.setText(mParam2);
        tv3.setText(mParam3);
        tv4.setText(mParam4);
        tv5.setText(mParam5);
        tv6.setText(mParam6);
        tv7.setText(mParam7);
        tv8.setText(mParam8);
        tv9.setText(mParam9);
        tv10.setText(mParam10);
        tv11.setText(mParam11);
        tv12.setText(mParam12);
        tv13.setText(mParam13);
        tv14.setText(mParam14);
        tv15.setText(mParam15);
        tv16.setText(mParam16);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction1(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener1) activity;
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
    public interface OnFragmentInteractionListener1 {
        // TODO: Update argument type and name
        public void onFragmentInteraction1(Uri uri);
    }


}
