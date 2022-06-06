package com.example.mydemos.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.Toast;

import com.example.mydemos.R;

import java.security.PublicKey;

public class LoaderCursor extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_view);
        FragmentManager fm = getFragmentManager();
        //获取当前FragmentId,如果没有加，创建一个CursorLoaderListFragment到content中
        if (fm.findFragmentById(android.R.id.content) == null) {
            CursorLoaderListFragment list = new CursorLoaderListFragment();
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }

    }


    /**
     * ListFragment,显示列表比自己创建ListView轻松
     * QueryTextListener,onCloseListener接口：响应View事件
     * LoaderManager加载后台数据库数据
     */
    public static class CursorLoaderListFragment extends ListFragment
            implements SearchView.OnQueryTextListener, SearchView.OnCloseListener,
            LoaderManager.LoaderCallbacks<Cursor> {
        //光标适配器，映射某个Cursor的列到xml布局文件中的某个TextView/ImageView
        SimpleCursorAdapter mAdapter;
        //用于过滤
        SearchView mSearchView;
        String mCurFulter;

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setEmptyText("No phone numbers");
            setHasOptionsMenu(true);
            //SimpleCursorAdapter具体用法：
            /**
             * p1:getActivity(),p2:布局list view item，p3:curosr,p4:数据哪些列,p5:绑定xml id
             */

            mAdapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_2, null, new String[]{
                    ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.CONTACT_STATUS}, new int[]{android.R.id.text1, android.R.id.text2}, 0);
            //将ListView内容绑定到Cursor
            setListAdapter(mAdapter);
            //显示进度条，提示等待，等数据加载完在显示
            setListShown(false);
            //启动后台数据加载
            getLoaderManager().initLoader(0, null, this);
        }

        public static class MySearchView extends SearchView {

            public MySearchView(Context context) {
                super(context);
            }

            @Override
            public void onActionViewCollapsed() {
                setQuery("", false);
                super.onActionViewCollapsed();
            }
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            MenuItem item = menu.add("Search");
            item.setIcon(android.R.drawable.ic_menu_search);

            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
            mSearchView = new MySearchView(getActivity());
            mSearchView.setOnQueryTextListener(this);
            mSearchView.setOnCloseListener(this);
            mSearchView.setIconifiedByDefault(true);
            item.setActionView(mSearchView);
        }

        /**
         * 输入文本变化时重新加载数据
         * @param newText
         * @return
         */
        public boolean onQueryTextChange(String newText) {
            String newFilter = !TextUtils.isEmpty(newText) ? newText : null;
            if (mCurFulter == null && newFilter == null) {
                return true;
            }
            if (mCurFulter != null && mCurFulter.equals(newFilter)) {
                return true;
            }
            mCurFulter = newFilter;
            //重新加载
            getLoaderManager().restartLoader(0, null, this);
            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String s) {
            return true;
        }

        @Override
        public boolean onClose() {
            if (!TextUtils.isEmpty(mSearchView.getQuery())) {
                mSearchView.setQuery(null, true);
            }
            return true;
        }


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentComplexList", "Item clicked: " + id);
        }

        static final String[] CONTACTS_SUMMARY_PROJECTION = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.CONTACT_STATUS,
                ContactsContract.Contacts.CONTACT_PRESENCE,
                ContactsContract.Contacts.PHOTO_ID,
                ContactsContract.Contacts.LOOKUP_KEY,
        };

        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            Uri uri;
            if (mCurFulter != null) {
                uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(mCurFulter));
            } else {
                uri = ContactsContract.Contacts.CONTENT_URI;
            }
            String select = "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                    + ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1) AND ("
                    + ContactsContract.Contacts.DISPLAY_NAME + " != '' ))";
            return new CursorLoader(getActivity(), uri,
                    CONTACTS_SUMMARY_PROJECTION, select, null,
                    ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
        }

        /**
         * 数据加载完成，把数据传给Adapter
         * @param loader
         * @param cursor
         */
        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            mAdapter.swapCursor(cursor);
            if (isResumed()) {
                //加载完成显示数据
                setListShown(true);
            } else {
                setListShownNoAnimation(true);
            }

        }

        /**
         * 离开时旧的Cursor关闭，导致不会内存泄露
         * @param loader
         */
        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
            mAdapter.swapCursor(null);
        }
    }
}