package com.example.kbvora.arihant1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


public class get_all_magazins extends ActionBarActivity {
    ArrayList<magazines> mArrayList;
    ListView mListView;
    String str;

    public static final int CONTEXT_MENU_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_magazins);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.customColor)));
        mArrayList=new ArrayList<magazines>();
        mListView=(ListView)findViewById(R.id.listView1_magazine);
        mArrayList.add( new magazines("ADHAYATAM VIGYAN (GUJARATI-QUARTERLY)","DINESH BHAI MODI","924 -STOCK EXCHANGE TOWER, DALAL STREET,MUMBAI-400023 (MAHARASHTRA)","0222270613"));
        mArrayList.add( new magazines("DASHA SHRIMALI (FORTNIGHTLY)","JAYANT MEHTA","SHRI SAURASHTRA DASHA SHRIMALI SEWA SANGH,KAMANI DASHA SHRIMALI BADI, 2 MALA,542 J.S.U.ROAD, CHEERA BAZAR,MUMBAI- 400002 (MAHARASHTRA)","0222016960"));
        mArrayList.add( new magazines("GHOGHARI JAIN DARSHAN (GUJARATI-MONTHLY)","NAGINDAS SHAH (WABARIKAR)","SHRI GHOGHARI JAIN SEWA SANGH,51, DARIYASTHAN STREET,MUMBAI- 400003 (MAHARASHTRA)"," "));

        mArrayList.add( new magazines("JAIN VICHAR SARITA","PREMCHAND S. JAIN 'PREMKAMAL'","22, SHANTINAGAR, SAINATH ROAD, MALAD (WEST) MUMBAI- 400064 (MAHARASHTRA)","0222270613"));
        mArrayList.add( new magazines("JAIN JAGAT (MONTHLY)","SHANTI PRASAD JAIN","22, SHANTINAGAR, SAINATH ROAD, MALAD (WEST) MUMBAI- 400064 (MAHARASHTRA)","0222270613"));
        mArrayList.add( new magazines("JAIN PRAKASH (GUJARATI-FORTNIGHTLY)","BRAJLAL KANURCHAND GANDHI","AKHIL BHARATIYA SWETAMBAR STHANAK JAIN CONFERENCE,TRIBHUWAN BUILDING, IV- FLOOR, A.B.N. BANK , 1, VIJAY VALLABH CHOWK, PAYEDHUNI,MUMBAI- 400003 (MAHARASHTRA)","0223422927"));
        mArrayList.add( new magazines("KATHIYAWAR JAIN (GUJARATI-MONTHLY)","GUNWANT BARVALIYA (GUNJAN)","SHRI KATHIYAWAR STHANAK JAIN SAMAJ, 14, EALCHIWALA ESTATE, GHATKOPAR (WEST)MUMBAI- 400086 (MAHARASHTRA)","0225221660"));
        mArrayList.add( new magazines("KUSHAL TIMES (MONTHLY)","SHANTI P. JAIN","4F/A2, COURT CHAMBERS, 35, NEW MARIN LINES,MUMBAI-400020 (MAHARASHTRA)","0222039979"));
        mArrayList.add( new magazines("MAHAVEER VICHAR (MONTHLY)"," ","SAKINA MANZIL NO.2 II- FLOOR, 324/30, RAJA RAM MOHAN RAI MARG, NEAR CHARNI ROAD STATION ,MUMBAI-4, (MAHARASHTRA)","0223612893"));
        mArrayList.add( new magazines("PRABUDH JIWAN (GUJARATI-FORTNIGHTLY)","RAMANLAL V. SHAH","MUMBAI JAIN YUWAK SANGH, 385 S.V.P. ROAD, PRATHANA SAMAJ, MUMBAI-400004 (MAHARASHTRA)","022382096"));
        mArrayList.add( new magazines("OSWAL SAMACHAR (GUJARATI-MONTHLY)","HANSRAJ MEGHNA SANDARIYA","SARVODYA SHOPPING CENTRE, PANKAJ, 21, DR. AMBEDKAR ROAD, KHAR ,MUMBAI-400052 (MAHARASHTRA)","0229004812"));
        mArrayList.add( new magazines("SUSHIL SANDESH (MONTHLY)","NAINMAL SURANA","SHRI 4/6, RANI SATI NAGAR, S.V.ROAD, MALAD (WEST), MUMBAI-400064 (MAHARASHTRA)","0228891511"));
        mArrayList.add( new magazines("SWAHITWAL SANDESH (MONTHLY)","DILIP Y. INGOLAY","2, UMAIYA BHAWAN K.A.H. SOCIETY, NEAR. DR. RAJENDRA PRASAD MARG, VARDHMAN NAGAR, MULUND (WEST), MUMBAI- 400080 (MAHARASHTRA)","0225680589"));
        mArrayList.add( new magazines("TIRTHKAR DIVYA SANDESH (MONTHLY)","SURENDRA JAIN","DIVYA SANDESH PRAKASHAN, 4, MARY VILA BUILDING, I- FLOOR, MANJREKAR WADI, MATHURADAS VASAN JI ROAD, ANDHERI (EAST), MUMBAI-400069 (MAHARASHTRA)","0228383140"));
        mArrayList.add( new magazines("Ahimsa Times ( Monthly )","Shri. Anil Kumar Jain ( President )","21, Skipper House, 9, Pusa Road New Delhi - 110005","011-28754012"));
        mArrayList.add( new magazines("Amar Jagat ( Monthly )","Shri. Naresh Kumar Jain","28/38, Gudri Mansur Khan, Agra, Uttar Pradesh - 282003","0562360682"));
        mArrayList.add( new magazines("Shraman Bharti (Weekly)","Smt. Usharani Lodha","Shop: 305, Block No. 40, 1st Floor, Sanjay Place, Agra, Uttar Pradesh - 282002","0562320613"));
        mArrayList.add( new magazines("Kewal Jin Darshan ( Monthly)","Kewal Jin Darshan Trust","15/A, Pratap Kunj Society, Near Vasana Post Office, Ahemdabad, Gujarat - 380007","0796614302"));
        mArrayList.add( new magazines("Samyak Vikas ( Quarterly)","Shri Prakash Palawat","21, Suflam Flats, Opp Jai Hind Press,Ashram Road, Ahmedabad, Gujarat - 380009","0796587541"));
        mArrayList.add( new magazines("Sambodhi( Research ( Yearly )","Shri J. B. Shah & Shri N. M. Kansara","L.D. Institute of Indology, Near Gujarat Univ., Ahemdabad, Gujarat - 380009","0796587541"));
        mArrayList.add( new magazines("Tirthankar Vani( Trilangual ( Quarterly )","Dr. Sikhar Chand Jain","25, Shromani Bungalow, Opposite Baroda Express Highway, Near C. T. M Chaurasta, Ahemdabad, Gujarat - 380026","0795892744"));
        mArrayList.add( new magazines("Swatantra, Jain Chintan ( Monthly )","Shri N. K Jain","253/23, Kabir Marg, Kesar Ganj, Ajmer, Rajasthan - 305001","0145622991"));
        mArrayList.add( new magazines("Shri Vidyasagar Times (Weekly)","Shri Narendra Jain","Bajaria Mohalla, Ashok Nagar, Guna, Madhya Pradesh - 473331","0754322475"));
        mArrayList.add( new magazines("Moksh Dwar Gyan Patrika (Fortnightly)","Shri Gautam Chand Oastwal 'Visharad'","J- 81, Ist- Floor, 9th Cross, Laxmi Narayan Puram (Shriram Puram Area), Bangalore, Karnataka - 580021","0803328512"));
        mArrayList.add( new magazines("Atma Jagriti ( Monthly )","Shri Viranjilal Jain","1004-B, Hon Pahala Mala, Bhavnagar - 364001","0278429680"));
        mArrayList.add( new magazines("Dharam Joyti (Monthly)","Shri Madanlal Jain","84, Balaji Market, Bhilwara, Rajsthan - 311001","0148220525"));
        mArrayList.add( new magazines("Jainam Times (Monthly)","Shri Dipesh Nenavati","5/14, Kashipuri, Bhilwara, Rajasthan - 311001","0148227141"));
        mArrayList.add( new magazines("Margdarshak (Weekly)","Shri Devendra K. Jain","Ruchi Prints, Santosh Tower, 148, 1st Floor , Zone Isd, M. P. Nagar, Bhopal, Madhya Pradesh - 456002","0755566999"));
        mArrayList.add( new magazines("Ajaramar Joyat (Monthly)","Shri Mayur R. Boria","S-14, K.D. Commercial Centre, 2nd Floor, New Station Road , Bhuj-Kutch, Gujarat - 370001","0283251454"));
        mArrayList.add( new magazines("Taruvar Turakhiya (Monthly)","Shri Ramnik Bhai Turakhiya","F/2, Mahisagar Appartments, Near. Amar Complex, New Sabha Road, Baroda - 390008","0265780258"));
        mArrayList.add( new magazines("Samyag Darshan (Monthly)","Shri Namichand Banthia","Akhil Bharatiya Sudharam Jain Sanskriti Rakshak Sangh, Banthia Sadan, Nehru Gate, Bwevar- 305901","01462-51216"));
        mArrayList.add( new magazines("The Vegitarian Guide ( Monthly)","Shri Viranjilal Bagra","The Indian Vegetarian Congres, Eastern Zone, 46 Stand Road, 3rd Floor, Calcutta, West Bengal - 700007","0495-2385449"));
        mArrayList.add( new magazines("Jain Jounral ( Quarterly )","Shri Chiranjilal Bagra","46, Strand Road, 3rd Floor, Calcutta, West Bengal – 700007","04852385449"));
        mArrayList.add( new magazines("Jain Pradeep (Monthly)","Shri Kulbhushan K. Jain","Joyati Chetna Sansthan, Prem Bhawan, Chahparas, Devnand, Saharanpur, Uttar Pradesh - 247554","0133622175"));
        mArrayList.add( new magazines("Ahichatra (Monthly)","Shri Ashok Jain Dhiraj Shastri","P-129, Gali No. 9, Shankar Nagar Extension, Delhi-110051","0112233503"));
        mArrayList.add( new magazines("Arhant Jain Times (Monthly)","Shri Gautam Oswal","Arhant Jain Sangh, Acharaya Sushil Ashram, C-599 Chetna Marg, Defence Colony, New Delhi- 110024","011-4622729"));
        mArrayList.add( new magazines("Apki Samasya Hamara Samadhan (Monthly)","Shri Ashok Sahajanand","239, Dariba Kalan, Delhi- 110006","0113278761"));
        mArrayList.add( new magazines("Tirthkar (Monthly)","Shri Shraynik Anndatay","D-6, Rajhans A. Tilak Nagar, Dorniwali East - 421201","0251435968"));
        mArrayList.add( new magazines("Samedawal Rashmi (Weekly)","Shri Amal Kumar Jain","Easri Bazar, Giridih, Bihar - 825107","0655833369"));
        mArrayList.add( new magazines("Ahimsa Mahakumbh (Monthly)","Shri Mukul Jain","196, Sector-18, Faridabad, Haryana - 121002","0129262549"));
        mArrayList.add( new magazines("Parshad (Monthly)","Shri Vimal Jain","Shri Digambar Jain Mandir, S.R.C.B. Road, Fancy Bazar, Guwahati, Assam - 781001","0361592778"));
        mArrayList.add( new magazines("Jinendra Vani (Monthly)","Shri Shantinath K. Hotpeti","6, Bammapur Gali, Hubli, Karnataka - 580028","0836-364154"));
        mArrayList.add( new magazines("Arhat Vachan (Quarterly)","Shri Anupam Jain","Kundakunda Gyanpith, 584, M.G. Road, Tukoganj, Indore, Madhya Pradesh - 452001","0731545421"));
        mArrayList.add( new magazines("Jain Janmat Darpan (Monthly)","Shri Rishabh Jain","Am-11/126, Sukhliya, Indore, Madhya Pradesh - 452008","0731558899"));
        mArrayList.add( new magazines("Anekant Path (Weekly)","Shri Suresh Chand Jain","Anekant Printers, 367 Sarafa Bond Bazar, Jabalpur, Madhya Pradesh - 482003","0761440871"));
        mArrayList.add( new magazines("Jain Darpan (Monthly)","Shri Premchand Jain Barjatiya","31/B/3, Swarn Path, Nilam Path Mansarovar, Jaipur, Rajasthan - 302020","0141391866"));
        mArrayList.add( new magazines("Pragati Ani Jinvijay (Monthly)","Shri Subhash Akkolay","Sewayog, Shahunagar, Jaisinghpur, Kolahpur, Maharashtra - 416102","25962"));
        mArrayList.add( new magazines("Divya Dhwani (Monthly)","Shri Suresh Rawal","Shri Satshrut Sewa Sadhna Kendra, Shrimad Ramchandra Adhyatmik Sadhna Kendra, Koba, Gandhinagar, Gujarat - 382009","0271276219"));
        mArrayList.add( new magazines("Arhat Tatvam","Shri J. Bhanuranjan","Acharya Kundakunda Tatva Prakashan Samiti, Kundakunda Nagar, Tamilnadu - 604505","0418325033"));
        mArrayList.add( new magazines("Mun Sthan","Shri Krishnanandshastri","Sanmati Nagar, Kupkalan, Sangrur, Punjab - 148019","01675-83064"));
        mArrayList.add( new magazines("Dharamvani (Monthly)","Shri Kailash Chandra Jain","Panchratan, Kailash Kuteer, 411/76, Pulgama Chowk, Lucknow, Uttar Pradesh - 226003","0522267075"));
        mArrayList.add( new magazines("Satyarth (Fortnightly)","Shri Kailash Chandra Jain","411/76, Pulgama Chowk, Lucknow, Uttar Pradesh - 226003","0522-267075"));
        mArrayList.add( new magazines("Janpriya (Weekly)","Shri Bahubali K. Jain","8, Civil Lines, Lalitpur, Uttar Pradesh - 284403","05176-72845"));
        mArrayList.add( new magazines("Shri Palliwal Jain Patrika","Shri Rajendra P. Jain","C-7, Sudha Sadan, Nanak Nagar, Mathura, Uttar Pradesh - 281001","0565404859"));
        mArrayList.add( new magazines("Sarak Joyti (Monthly)","Shri Subhash Chandra Jain","Gyan Bhawan, 150, Khandak Bazar, Meerut, Uttar Pradesh - 250002","0121-521285"));
        mArrayList.add( new magazines("Yatind Vani (Monthly)","Shri Bhanwar Lal Jain","Shri Rajendra Shanti Vihar, Motera, Sabarmati Gandhinagar Highway, Gandhinagar, Gujarat - 382424","02712-22649"));
        mArrayList.add( new magazines("Santdhara (Monthly)","Shri Pawan Jain","Opp. Sweta Press, Uco Bank, Narsinghpur, Madhya Pradesh - 487001","0779230825"));
        mArrayList.add( new magazines("Mangal Bodhi (Monthly)","Shri Sudesh Golecha","Opp. 'Golecha Sadan' Nikalas Temple, Eatwari, Nagpur, Maharashtra - 440002","769526"));
        mArrayList.add( new magazines("Ratnaraj (Monthly)","Shri Rajendra Nagawat","B-45, Sector-8, Noida, Uttar Pradesh - 201301","01191551152"));
        mArrayList.add( new magazines("Jaikanthal (Weekly)","Shri Ajit K. Modi","Pratapgarh, Rajasthan - 312605","0147822142"));
        mArrayList.add( new magazines("Jain Jagriti (Monthly)","Shri Sanjay Kantilal Chowradiya","62, Rituraj Society, Pune, Satara Road, Pune, Maharashtra - 411037","0204295588"));
        mArrayList.add( new magazines("Jain Saurabh (Monthly)","Shri Ramniklal M. Seth","Ashirwad Paper Mart, Malviya Gali, Debar Chowk, Rajkot, Gujarat - 360001","07928415"));
        mArrayList.add( new magazines("Jain Kranti (Monthly)","Shri Rasiklal C. Parekh","31/36, Karanpara, Rajkot, Gujarat - 360001","223039"));
        mArrayList.add( new magazines("Shasan Pragati (Monthly)","Shri Manharlal B. Mehta","1/7, Jagannath Plot, 1st Floor, Rachati Apartment, Manek, Rajkot, Gujarat - 360001","079443363"));
        mArrayList.add( new magazines("Ahimsa Sandesh (Fortnightly)","Shri Ratnesh K. Jain","Post Box No. 85, Ranchi, Bihar - 834001","0651202009"));
        mArrayList.add( new magazines("Gommatvani (Monthly)","Shri S.N. Ashok Kumar Jain","Shri Digambar Jain Ashram, Chetna Road, Shravanbelagola, Hasan, Karnataka - 573135","0817657270"));
        mArrayList.add( new magazines("Jain Bodhak (Monthly)","Shri Kumudni Bai Doshi","162/17, Bharat Bhawan, Railway Lines, Solapur, Maharashtra - 413001","0217312819"));
        mArrayList.add( new magazines("Tarun Kranti (Monthly)","Shri Sunil Gangwal","Mahatama Gandhi Marg, Sonkutch, Dewas, Madhya Pradesh - 455118","0727022256"));
        mArrayList.add( new magazines("Jainmitra (Weekly)","Shri Sailesh Kapariya","Khapatiya Chakla, Gandhi Chowk, Surat, Gujarat - 395003","0261427621"));


                mListView.setAdapter(new magazine_custom_adpter(get_all_magazins.this, mArrayList));
        registerForContextMenu(mListView);


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.listView1_magazine)
        {
            ListView lst=(ListView)v;
        }
        menu.add(Menu.NONE,CONTEXT_MENU_CALL,Menu.NONE,"CALL");


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos=info.position;
        magazines reg=mArrayList.get(pos);
        String id=reg.tele1+"";
        switch (item.getItemId()) {
            case CONTEXT_MENU_CALL:
                dialPhoneNumber(id);
                break;


             default:
                break;
        }


        return super.onContextItemSelected(item);
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_all_magazins, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.megtirthankar_menu_action_home) {
            Intent i  = new Intent(get_all_magazins.this,Homepage_menu.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.megtirthankar_menu_action_Tirthplace) {
            Intent i = new Intent(get_all_magazins.this,getalltirthplace.class);
            startActivity(i);
            return true;
        }

        if (id == R.id.megtirth_menu_action_Jainfestival) {
            Intent i = new Intent(get_all_magazins.this,getAllFestival.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.megtirthankar_menu_action_Jainsongs) {
            Intent i = new Intent(get_all_magazins.this,getallJainsongs.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.megtirth_menu_action_pachhakhanan) {
            Intent i = new Intent(get_all_magazins.this,allpachakhan.class);
            startActivity(i);

            return true;
        }
        if (id == R.id.megtirthankar_menu_action_sun_time) {
            Intent i  = new Intent(get_all_magazins.this,Pager_suntime.class);
            startActivity(i);

            return true;
        }

        if (id == R.id.megtirthankar_menu_action_nearby) {
            Intent i  = new Intent(get_all_magazins.this,MapsActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
