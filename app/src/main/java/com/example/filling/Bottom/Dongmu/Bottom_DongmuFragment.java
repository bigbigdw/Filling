package com.example.filling.Bottom.Dongmu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.Bottom.Filling.Bottom_FillingFragment;
import com.example.filling.Dongmu.Dongmu_Detail;
import com.example.filling.Dongmu.Dongmu_Detail_MenuAdapter;
import com.example.filling.Dongmu.Dongmu_Detail_MenuData;
import com.example.filling.Dongmu.Dongmu_List;
import com.example.filling.Dongmu.Dongmu_ListAdapter;
import com.example.filling.Dongmu.Dongmu_ListData;
import com.example.filling.Dongmu.Dongmu_Search;
import com.example.filling.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static android.content.Context.LOCATION_SERVICE;

public class Bottom_DongmuFragment extends Fragment {

    private GpsTracker gpsTracker;
    TextView textview_address, DongmuSearchText;

    Dongmu_ListAdapter adapter;

    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

    ImageView FillingAD, FAQImg;
    HorizontalScrollView ScrollBefore;
    TableLayout ScrollAfter;
    LinearLayout onClickUnfold, onClickFold, DongmuList01, DongmuSearch, Weather, Location, Fake;

    CarouselView Dongmu_Lower_carousel;

    int[] LowerImages = {R.drawable.dongmu_lower_ex12, R.drawable.dongmu_lower_ex11, R.drawable.dongmu_lower_ex01, R.drawable.dongmu_lower_ex02, R.drawable.dongmu_lower_ex03, R.drawable.dongmu_lower_ex04, R.drawable.dongmu_lower_ex05, R.drawable.dongmu_lower_ex06, R.drawable.dongmu_lower_ex07, R.drawable.dongmu_lower_ex08, R.drawable.dongmu_lower_ex09, R.drawable.dongmu_lower_ex10};
    String[] MarkText = {"분위기갑","유명맛집","해장국", "밥집", "횟집", "맥주", "분위기굿", "중화요리", "밥집", "전국맛집", "고기맛집", "파스타"};
    String[] Title = {"스미스가좋아하는한옥", "한옥달", "진짜해장국", "뚝도시장", "보물선", "을지맥옥", "뇨끼바", "무탄", "온천집", "마이클바이해비치", "몽탄", "라구"};
    String[] Comment = {"1511","5651","1562", "452", "4651", "489", "1465", "1651", "1562", "452", "4651", "489", "1465", "1651"};
    String[] Recommend = {"6226","1515","12", "626", "132", "151", "6262", "6262", "12", "626", "132", "151", "6262", "6262"};
    String[] Tag1 = {"#삼청동","#단호박크림스프","#해장국", "#성수동", "#신사역맛집", "#을지맥옥", "#뇨끼바", "#무탄 ", "#온천집", "#브런치", "#용산맛집", "#라구파스타"};
    String[] Tag2 = {"#스미스가좋아하는한옥","#감베로니","#진짜해장국", "#뚝도시장", "#신사역회맛집", "#을지로", "#한남동카페", "#압구정무탄", "#시네트롤", "#종로맛집", "#삼각지맛집", "#라구"};
    String[] Tag3 = {"#고급진데","#로제파스타","#동역사", "#서울맛집", "#가로수길맛집", "#을지로3가", "#한남동맛집", "#트러플한우스테이크짜장면", "#다이어트참쉽죠?", "#쉬림프타코", "#이영자맛집", "#파스타"};
    String[] Tag4 = {"#겁나 비싸보임","#스텔라피자","#진짜해장국대화정", "#서울숲", "#가로수길술집", "#맥주", "#인것같아", "#중식맛집", "#근데난안됨", "#시그니처맛집", "#용산고기집", "#뇨끼"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.bottom_dongmu, container, false);

        if (!checkLocationServicesStatus()) {

            showDialogForLocationServiceSetting();
        } else {

            checkRunTimePermission();
        }

        gpsTracker = new GpsTracker(getActivity());

        double latitude = gpsTracker.getLatitude();
        double longitude = gpsTracker.getLongitude();

        String address = getCurrentAddress(latitude, longitude);

        Location = root.findViewById(R.id.Location);
        textview_address = root.findViewById(R.id.Address);
        Weather = root.findViewById(R.id.Weather);
        Location.setOnClickListener(v -> {

            textview_address.setText(address);
            Weather.setVisibility(View.GONE);
            Toast.makeText(requireContext().getApplicationContext(), "현재위치 \n위도 " + latitude + "\n경도 " + longitude, Toast.LENGTH_SHORT).show();
        });

        Fake = root.findViewById(R.id.Fake);

        RecyclerView recyclerView = root.findViewById(R.id.Dongmu_Bottom_List);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Dongmu_ListAdapter();


        recyclerView.setAdapter(adapter);

        new android.os.Handler().postDelayed(
                () -> {
                    recyclerView.setVisibility(View.VISIBLE);
                    Dongmu_Lower_carousel.setVisibility(View.VISIBLE);
                    Fake.setVisibility(View.GONE);
                },
                300);

        getData();


        Dongmu_Lower_carousel = root.findViewById(R.id.Dongmu_Lower_carousel);
        Dongmu_Lower_carousel.setPageCount(LowerImages.length);
        Dongmu_Lower_carousel.setViewListener(viewListener);
        Dongmu_Lower_carousel.setImageClickListener(position -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_Detail.class);
            startActivity(intent);
        });

        ScrollBefore = root.findViewById(R.id.ScrollBefore);
        ScrollAfter = root.findViewById(R.id.ScrollAfter);
        ScrollAfter.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_List.class);
            intent.putExtra("textview_address",String.format("%s", address));
            startActivity(intent);
        });
        onClickUnfold = root.findViewById(R.id.onClickUnfold);
        onClickUnfold.setOnClickListener(v -> {
            ScrollBefore.setVisibility(View.GONE);
            ScrollAfter.setVisibility(View.VISIBLE);
        });
        onClickFold = root.findViewById(R.id.onClickFold);
        onClickFold.setOnClickListener(v -> {
            ScrollAfter.setVisibility(View.GONE);
            ScrollBefore.setVisibility(View.VISIBLE);
        });
        DongmuList01 = root.findViewById(R.id.DongmuList01);
        DongmuList01.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_List.class);
            intent.putExtra("textview_address",String.format("%s", address));
            startActivity(intent);
        });

        DongmuSearch = root.findViewById(R.id.DongmuSearch);
        DongmuSearch.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext().getApplicationContext(), Dongmu_Search.class);
            intent.putExtra("textview_address",String.format("%s", address));
            startActivity(intent);
        });

        DongmuSearchText = root.findViewById(R.id.DongmuSearchText);
        DongmuSearchText.setClickable(false);
        DongmuSearchText.setFocusable(false);


        FillingAD = root.findViewById(R.id.FillingAD);
        FAQImg = root.findViewById(R.id.FAQImg);
        root.findViewById(R.id.FillingAD).setOnClickListener(view -> Toast.makeText(requireContext().getApplicationContext(), "이젠 든든하지 않습니다." , Toast.LENGTH_SHORT).show());

        root.findViewById(R.id.FAQImg).setOnClickListener(view -> NavHostFragment.findNavController(Bottom_DongmuFragment.this)
                .navigate(R.id.action_Bottom_Dongmu_to_Drawer_FAQ));

        return root;
    }


    private void getData(){
        Dongmu_ListData data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex01, "#태극당 #팥빙수", "15M", "태극당", "서울 중구 장충동 동호로24길 7", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex02, "#샤로수길 #중동닭발떡볶이 #닭발 #조하", "651M", "중동닭발떡볶이", "서울 관악구 봉천동 1612-51", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex03, "#샤로수길 #이태리파파 #피자성애자 #념념념", "150M", "혜화돌쇠아저씨", "서울 종로구 명륜4가 23", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex04, "#민정식당 #수육", "145M", "민정식당", "서울 광진구 자양동 232-35", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex05, "#건대입구 #해피니스디저트", "561M", "해피니스디저트", "서울 광진구 자양4동 뚝섬로27길 60", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex06, "#서울대입구역 #봉천동양대창", "198M", "봉천동양대창", "서울 관악구 봉천동 번지 1층 1601-16", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex07, "#송리단길 #콘메", "19M", "콘메", "서울 송파구 송파동 백제고분로42길 6-30", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex08, "#서울대입구역 #행운동조개 #조개구이 #해물라면 #김치존맛", "165M", "행운동조개", "서울 관악구 봉천동 1666-21번지 1층", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex09, "#송파역 #대원정육식당 #치마살 #육사시미", "169M", "대원정육식당", "서울 송파구 송파대로37길 70", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red);
        adapter.addItem(data);
        data = new Dongmu_ListData(R.drawable.dongmu_main_bottom_ex10, "#소프트쉘크랩커리 #쏨땀 #팟타이", "91M", "쏭타이치앙마이", "서울 용산구 한강로2가 한강대로40길 39-5", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off);
        adapter.addItem(data);
    }

    /*
     * ActivityCompat.requestPermissions를 사용한 퍼미션 요청의 결과를 리턴받는 메소드입니다.
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        if (permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면

            boolean check_result = true;


            // 모든 퍼미션을 허용했는지 체크합니다.

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }


            if (check_result) {

                //위치 값을 가져올 수 있음
                ;
            } else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), REQUIRED_PERMISSIONS[1])) {

                    Toast.makeText(requireContext().getApplicationContext(), "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(requireContext().getApplicationContext(), "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    void checkRunTimePermission() {

        //런타임 퍼미션 처리
        // 1. 위치 퍼미션을 가지고 있는지 체크합니다.
        int hasFineLocationPermission = ContextCompat.checkSelfPermission(requireContext().getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(requireContext().getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION);


        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED) {

            // 2. 이미 퍼미션을 가지고 있다면
            // ( 안드로이드 6.0 이하 버전은 런타임 퍼미션이 필요없기 때문에 이미 허용된 걸로 인식합니다.)


            // 3.  위치 값을 가져올 수 있음


        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.

            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), REQUIRED_PERMISSIONS[0])) {

                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(requireContext().getApplicationContext(), "이 앱을 실행하려면 위치 접근 권한이 필요합니다.", Toast.LENGTH_LONG).show();
                // 3-3. 사용자게에 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);


            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

    }


    public String getCurrentAddress(double latitude, double longitude) {

        //지오코더... GPS를 주소로 변환
        Geocoder geocoder = new Geocoder(requireContext().getApplicationContext(), Locale.getDefault());

        List<Address> addresses;

        try {

            addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    7);
        } catch (IOException ioException) {
            //네트워크 문제
            Toast.makeText(requireContext().getApplicationContext(), "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show();
            return "지오코더 서비스 사용불가";
        } catch (IllegalArgumentException illegalArgumentException) {
            Toast.makeText(requireContext().getApplicationContext(), "잘못된 GPS 좌표", Toast.LENGTH_LONG).show();
            return "잘못된 GPS 좌표";

        }


        if (addresses == null || addresses.size() == 0) {
            Toast.makeText(requireContext().getApplicationContext(), "주소 미발견", Toast.LENGTH_LONG).show();
            return "주소 미발견";

        }

        Address address = addresses.get(0);
        return address.getAddressLine(0) + "\n";

    }


    //여기부터는 GPS 활성화를 위한 메소드들
    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext().getApplicationContext());
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하실래요?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", (dialog, id) -> {
            Intent callGPSSettingIntent
                    = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
        });
        builder.setNegativeButton("취소", (dialog, id) -> dialog.cancel());
        builder.create().show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GPS_ENABLE_REQUEST_CODE) {//사용자가 GPS 활성 시켰는지 검사
            if (checkLocationServicesStatus()) {
                if (checkLocationServicesStatus()) {

                    Log.d("@@@", "onActivityResult : GPS 활성화 되있음");
                    checkRunTimePermission();
                    return;
                }
            }
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.dongmu_main_lower_carousel, null);

            TextView Dongmu_Lower_MarkText = customView.findViewById(R.id.Dongmu_Lower_MarkText);
            TextView Dongmu_Lower_Comment = customView.findViewById(R.id.Dongmu_Lower_Comment);
            TextView Dongmu_Lower_Recommend = customView.findViewById(R.id.Dongmu_Lower_Recommend);
            TextView Dongmu_Lower_Title = customView.findViewById(R.id.Dongmu_Lower_Title);
            TextView Dongmu_Lower_Tag1 = customView.findViewById(R.id.Dongmu_Lower_Tag1);
            TextView Dongmu_Lower_Tag2 = customView.findViewById(R.id.Dongmu_Lower_Tag2);
            TextView Dongmu_Lower_Tag3 = customView.findViewById(R.id.Dongmu_Lower_Tag3);
            TextView Dongmu_Lower_Tag4 = customView.findViewById(R.id.Dongmu_Lower_Tag4);
            ImageView Images = customView.findViewById(R.id.Dongmu_Lower_Img);

            Images.setImageResource(LowerImages[position]);
            Dongmu_Lower_Title.setText(Title[position]);
            Dongmu_Lower_MarkText.setText(MarkText[position]);
            Dongmu_Lower_Comment.setText(Comment[position]);
            Dongmu_Lower_Recommend.setText(Recommend[position]);
            Dongmu_Lower_Tag1.setText(Tag1[position]);
            Dongmu_Lower_Tag2.setText(Tag2[position]);
            Dongmu_Lower_Tag3.setText(Tag3[position]);
            Dongmu_Lower_Tag4.setText(Tag4[position]);

            Dongmu_Lower_carousel.setIndicatorGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

            return customView;
        }
    };


}
