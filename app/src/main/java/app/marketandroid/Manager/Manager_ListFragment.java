package app.marketandroid.Manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import app.marketandroid.R;

public class Manager_ListFragment extends Fragment {
    ViewGroup viewGroup;
    ArrayList<MGRecyclerItem> mData = null;
    RecyclerView mRecyclerView = null;
    ArrayList<MGRecyclerItem> mList = new ArrayList<>();
    MGRecyclerViewAdapter mAdapter;
    Spinner mg_products_spinner,mg_weight_spinner;
    ArrayList<String> plist = new ArrayList<>();
    ArrayList<String> wlist = new ArrayList<>();
    ArrayAdapter<String> padapter;
    ArrayAdapter<String> wadapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mg_products_spinner = getActivity().findViewById(R.id.mg_products_spinner);
        mg_weight_spinner = getActivity().findViewById(R.id.mg_weight_spinner);
        plist.add(0,"농부");
        wlist.add(0,"품종");
        padapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,plist);
        wadapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_dropdown_item,wlist);


        mg_products_spinner.setAdapter(padapter);
        mg_weight_spinner.setAdapter(wadapter);
        mg_products_spinner.setSelection(0);
        mg_weight_spinner.setSelection(0);
        mg_products_spinner.setDropDownVerticalOffset(180);
        mg_weight_spinner.setDropDownVerticalOffset(180);

        mRecyclerView = getActivity().findViewById(R.id.mgrecyclerView);
        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new MGRecyclerViewAdapter(mList);
        mData = mList;
        mRecyclerView.setAdapter(mAdapter);
        addItem("농부1","감자","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부2","고구마","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부3","당근","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부4","사과","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부5","감자","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부6","복숭아","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        addItem("농부7","가지","20Kg","3Box","300,000원","(1Box 당 100,000원)");
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.manager_list_fragment, container, false);
        return viewGroup;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void addItem(String user_name, String products, String weight, String count, String total_price, String personal_price) {
        MGRecyclerItem item = new MGRecyclerItem(user_name,products,weight,count,total_price,personal_price);
        item.setUser_name(user_name);
        item.setProductsStr(products);
        item.setWeightStr(weight);
        item.setCountStr(count);
        item.setTotal_priceStr(total_price);
        item.setPersonal_priceStr(personal_price);
        mList.add(item);
    }

}