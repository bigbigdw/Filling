package com.example.filling.Dongmu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filling.R;

import java.util.ArrayList;

public class Dongmu_Detail_Tab3 extends Fragment {

    Dongmu_Detail_CommentAdapter adapter;
    EditText Comment;
    Button BtnCommit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dongmu_detail_tab3, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.Dongmu_Detail_Comment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Dongmu_Detail_CommentAdapter();
        recyclerView.setAdapter(adapter);


        Comment = root.findViewById(R.id.Comment);
        BtnCommit = root.findViewById(R.id.BtnCommit);

        BtnCommit.setOnClickListener(view -> {
            String Name = "김";
            String ID = "bibib****";
            String Date = "방금 전";
            String Text = Comment.getText().toString();
            Comment.setText("");
            Dongmu_Detail_CommentData data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member01, Name, ID, Date, Text);
            adapter.changeItem(data,0);
        });

        getData();

        return root;
    }

    private void getData() {
        Dongmu_Detail_CommentData data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member01, "김", "bibib****", "2020.11.07 01:48", "치킨이 친절하고 사장님이 맛있어요");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member05, "진", "youj****", "2020.10.17 18:27", "아이들 술안주로, 어른들 간식으로 적당하네요^^");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member01, "문", "moon****", "2020.08.23 15:48", "가렌이랑 케넨이랑 붙으면 가렌이 이김");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member04, "한", "han.su****", "2020.08.13 02:12", "구구가가 구구가가");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member02, "정", "hyuck****", "2020.08.06 08:15", "주문했습니다 하자없는 상품 부탁드립니다.");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member04, "신", "xxial****", "2020.07.28 05:15", "아아 이것은 [댓글]이라는 것이다. 그것이 댓글이니깐.");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member05, "최", "jongho****", "2020.07.16 15:52", "♚♚히어로즈 오브 더 스☆톰♚♚가입시$$전원 카드팩☜☜뒷면100%증정※ ♜월드오브 워크래프트♜펫 무료증정￥ 특정조건 §§디아블로3§§★공허의유산★초상화획득기회@@@ 즉시이동http://kr.battle.net/heroes/ko/");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member03, "유", "bin****", "2020.06.29 23:09", "테스형도 이게 무슨 앱인지 모르겠다는데요?");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member04, "김", "kun.__.s****", "2020.06.08 05:45", "주문했습니다 하자없는 상품 부탁드립니다.");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member03, "윤", "die_****", "2020.06.06 19:59", "12번 허리 30인치인데 무슨 사이즈 입어야 하나요?");
        adapter.addItem(data);
        data = new Dongmu_Detail_CommentData(R.drawable.dongmu_detail_member05, "정", "yunjun****", "2020.06.06 19:59", "미륏뽈뜬 쏘롸! 새끄리빠이쓰 미");
        adapter.addItem(data);
    }
}
