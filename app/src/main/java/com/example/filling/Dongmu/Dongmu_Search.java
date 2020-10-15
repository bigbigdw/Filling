package com.example.filling.Dongmu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.filling.Bottom.Dongmu.Bottom_DongmuFragment;
import com.example.filling.Bottom.Dongmu.Dongmu_Bottom_List;
import com.example.filling.Bottom.Dongmu.Dongmu_Bottom_ListItem;
import com.example.filling.R;

import java.util.ArrayList;
import java.util.Objects;

public class Dongmu_Search extends AppCompatActivity {

    ListView listView;
    Dongmu_Search.DongmuAdapter adapter;
    EditText DongmuSearchText;
    LinearLayout SearchResult;
    NestedScrollView DongmuSearchScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dongmu_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.Dongmu_Bottom_List);
        adapter = new Dongmu_Search.DongmuAdapter();
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex01, "#태극당 #팥빙수", "15M", "태극당", "서울 중구 장충동 동호로24길 7",  R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex02, "#샤로수길 #중동닭발떡볶이 #닭발 #조하", "651M", "중동닭발떡볶이", "서울 관악구 봉천동 1612-51", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex03, "#샤로수길 #이태리파파 #피자성애자 #념념념", "150M", "혜화돌쇠아저씨", "서울 종로구 명륜4가 23", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex04, "#민정식당 #수육", "145M", "민정식당", "서울 광진구 자양동 232-35", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex05, "#건대입구 #해피니스디저트", "561M", "해피니스디저트", "서울 광진구 자양4동 뚝섬로27길 60", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex06, "#서울대입구역 #봉천동양대창", "198M", "봉천동양대창", "서울 관악구 봉천동 번지 1층 1601-16", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex07, "#송리단길 #콘메", "19M", "콘메", "서울 송파구 송파동 백제고분로42길 6-30", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex08, "#서울대입구역 #행운동조개 #조개구이 #해물라면 #김치존맛", "165M", "행운동조개", "서울 관악구 봉천동 1666-21번지 1층", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex09, "#송파역 #대원정육식당 #치마살 #육사시미", "169M", "대원정육식당", "서울 송파구 송파대로37길 70", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex10, "#소프트쉘크랩커리 #쏨땀 #팟타이", "91M", "쏭타이치앙마이", "서울 용산구 한강로2가 한강대로40길 39-5", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off));

        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex11, "#신라호텔 #미슐랭 #라연 #한정식 #디너 #와인", "984M", "라연", "서울 중구 장충동 동호로 249",  R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex12, "#멘야하나비 #잠실맛집 #마제소바 #송파맛집 #송리단길 #송리단길맛집", "918M", "멘야하나비", "서울 송파구 송파동 백제고분로45길 38", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex13, "#공항칼국수 #공칼 #버섯칼국수 #택배맛집", "65M", "공항칼국수", "서울 강서구 공항동 공항대로 18-1", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex14, "#선주가 #마곡맛집 #마곡나루맛집 #서울식물원 #서울식물원맛집 ", "145M", "선주가", "서울 강서구 마곡동 760-2번지 마곡나루역캐슬파크 1층", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex15, "#마곡 #마곡맛집 #마곡수제맥주 #코끼리탭룸", "561M", "코끼리탭룸", "서울 강서구 마곡동 공항대로 195 힐스테이트 에코동익", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex16, "#한남 #한남동 #한남동카페 #한강진역 #한강진역카페 #앤드하리 #앤드하리한남 #카페투어 #카페스타그램", "198M", "앤드하리", "인천 강화군 길상면 동검리 95", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex17, "#인천맛집 #강화도맛집 #평가네된장", "45M", "평가네된장", "인천광역시 강화군 화도면 가능포로89번길 11", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex18, "#영종도 #마시랑카페 #주말 #일상", "411M", "마시랑카페", "인천 중구 덕교동 마시란로 163", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex19, "#직장인점심 #점심메뉴추천 #점심 #원당맛집 #맛스타그램 #먹스타그램", "584M", "또와순대국", "인천 중구 중산동 Haneuljungang-ro195beon-gil 24", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));

        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex21, "#Bisque #Risotto #임파스토 #송도맛집", "1651M", "임파스토", "인천 연수구 송도2동 아트센터대로 203",  R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex22, "#미식가 #맛집투어 #어글리스토브 #강남역", "498M", "어글리스토브", "서울 강남구 역삼동 강남대로98길 20", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex23, "#일상 #데일리 #먹스타그램 #카페 #송도 #송도맛집 #송도카페 #송도양과점 #크로플 #food", "165M", "송도양과점", "인천 송도1동", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex24, "#송도파스타 #실란트로 #송도실란트로 #송도맛집 ", "948M", "실란트로", "ho, 194, Central-ro thesharp centralpark2, 128 A dong, 연수구 인천광역시 대한민국", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex25, "#하동제첩국 #하동여행 #섬진강재첩국수", "758M", "하동제첩국", "경남 하동군 하동읍 비파리 428", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex26, "#하동 #하동여행 #섬진강 #스타웨이 #스타웨이하동 #스타웨이하동스카이워크 #재첩국", "1162M", "스타웨이하동", "경남 하동군 악양면 섬진강대로 3358-110", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_red, R.drawable.dongmu_bottomlist_donation_on, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex27, "#은안재 #화과자", "486M", "은안재", "경남 진주시 망경동 100-10", R.drawable.dongmu_bottomlist_ad_red, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_on));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex28, "#진주맛집 #중식당 #이차이", "581M", "이차이", "경남 진주시 평거동 진양호로 21 KR 위너스빌딩 2층", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_on, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));

        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex31, "#제주도 #애월 #신의한모", "165M", "서원", "제주시 애월읍 하귀1리 1620-4", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex32, "#대정읍 #대정맛집 #점심 ", "654M", "제주고로", "제주 서귀포시 대정읍 서삼중로 94", R.drawable.dongmu_bottomlist_ad_off, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_off, R.drawable.dongmu_bottomlist_present_red));
        adapter.addItem(new Dongmu_Bottom_ListItem(R.drawable.dongmu_main_bottom_ex33, "#제주도두반점 #제주시맛집 #중국집 #제주짬뽕맛집", "968M", "하동제첩국", "제주시 도두동 1679", R.drawable.dongmu_bottomlist_ad_on, R.drawable.dongmu_bottomlist_coupon_off, R.drawable.dongmu_bottomlist_donation_red, R.drawable.dongmu_bottomlist_present_off));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(getApplicationContext(), Dongmu_Detail.class);
            startActivity(intent);
        });

        DongmuSearchText = findViewById(R.id.DongmuSearchText);
        SearchResult = findViewById(R.id.SearchResult);
//        DongmuSearchScroll = findViewById(R.id.DongmuSearchScroll);

        DongmuSearchText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(DongmuSearchText.getWindowToken(), 0);
                SearchResult.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                return true;
            }
            return false;
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//toolbar의 back키 눌렀을 때 동작
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class DongmuAdapter extends BaseAdapter {
        ArrayList<Dongmu_Bottom_ListItem> items = new ArrayList<>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(Dongmu_Bottom_ListItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            Dongmu_Bottom_List view = new Dongmu_Bottom_List(getApplicationContext());

            Dongmu_Bottom_ListItem item = items.get(position);
            view.setFoodImgresId(item.getFoodImgresId());
            view.setImgTag1resId(item.getImgTag1resId());
            view.setImgTag2resId(item.getImgTag2resId());
            view.setImgTag3resId(item.getImgTag3resId());
            view.setImgTag4resId(item.getImgTag4resId());

            view.setCategory(item.getCategory());
            view.setDistance(item.getDistance());
            view.setTitle(item.getTitle());
            view.setLocation(item.getLocation());
            return view;
        }
    }

}
