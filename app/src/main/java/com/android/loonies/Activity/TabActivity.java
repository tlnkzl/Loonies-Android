package com.android.loonies.Activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.loonies.Fragment.FamilyFragment;
import com.android.loonies.Fragment.GoalFragment;
import com.android.loonies.Fragment.HomeFragment;
import com.android.loonies.Fragment.ProfileFragment;
import com.android.loonies.Fragment.TaskFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.loonies.R;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {


    public static TabActivity notificationsActivity;
    public static Boolean isVisible = false;
    private static final String TAG = "MainActivity";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager viewPager;
    TabLayout tabLayout;
    View homeTabView;
    View familyTabView;
    View tasksTabView;
    View goalsTabView;
    View profileTabView;
    CoordinatorLayout mainContent;

    HomeFragment homeFragment;
    FamilyFragment familyFragment;
    TaskFragment taskFragment;
    GoalFragment goalFragment;
    ProfileFragment profileFragment;

    private void initViews() {
        mainContent = findViewById(R.id.main_content);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container2);
        viewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        if (TabActivity.this != null) {
            homeTabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            ((TextView) homeTabView.findViewById(R.id.text)).setText(getString(R.string.home));
            familyTabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            ((TextView) familyTabView.findViewById(R.id.text)).setText(getString(R.string.family));
            tasksTabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            ((TextView) tasksTabView.findViewById(R.id.text)).setText(getString(R.string.task));
            goalsTabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            ((TextView) goalsTabView.findViewById(R.id.text)).setText(getString(R.string.goal));
            profileTabView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tabLayout.getTabAt(0).setCustomView(homeTabView);
            tabLayout.getTabAt(1).setCustomView(familyTabView);
            tabLayout.getTabAt(2).setCustomView(tasksTabView);
            tabLayout.getTabAt(3).setCustomView(goalsTabView);
            tabLayout.getTabAt(4).setCustomView(profileTabView);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        selectTabImage(0);
        notificationsActivity = this;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                selectTabImage(position);
            }

            @Override
            public void onPageScrolled(int position, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectTabImage(tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    private void selectTabImage(int currentTab) {

        ((ImageView) homeTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_home_black_48);
        ((ImageView) familyTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_people_outline_black_48);
        ((ImageView) tasksTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_event_note_black_48);
        ((ImageView) goalsTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_insert_chart_outlined_black_48);
        int valueInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) profileTabView.findViewById(R.id.image).getLayoutParams();
        params.setMargins(0, valueInDp, 0, 0);
        ((ImageView) profileTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_face_black_48);

        ((TextView) homeTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.mediumjunglegreen));
        ((TextView) familyTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.mediumjunglegreen));
        ((TextView) tasksTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.mediumjunglegreen));
        ((TextView) goalsTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.mediumjunglegreen));
        ((TextView) profileTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.mediumjunglegreen));

        switch (currentTab) {
            case 0:
                ((ImageView) homeTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_home_white_48);
                ((TextView) homeTabView.findViewById(R.id.text)).setText(getString(R.string.home));
                ((TextView) homeTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.textColor100));
                break;
            case 1:
                ((ImageView) familyTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_people_white_48);
                ((TextView) familyTabView.findViewById(R.id.text)).setText(getString(R.string.family));
                ((TextView) familyTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.textColor100));
                break;
            case 2:
                ((ImageView) tasksTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_event_note_white_48);
                ((TextView) tasksTabView.findViewById(R.id.text)).setText(getString(R.string.task));
                ((TextView) tasksTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.textColor100));
                break;
            case 3:
                ((ImageView) goalsTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_insert_chart_white_48);
                ((TextView) goalsTabView.findViewById(R.id.text)).setText(getString(R.string.goal));
                ((TextView) goalsTabView.findViewById(R.id.text)).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.textColor100));
                break;
            default:
                ((ImageView) profileTabView.findViewById(R.id.image)).setImageResource(R.drawable.baseline_face_white_48);
        }
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (homeFragment == null)
                        homeFragment = new HomeFragment();
                    return homeFragment;
                case 1:
                    if (familyFragment == null)
                        familyFragment = new FamilyFragment();
                    return familyFragment;
                case 2:
                    if (taskFragment == null)
                        taskFragment = new TaskFragment();
                    return taskFragment;
                case 3:
                    if (goalFragment == null)
                        goalFragment = new GoalFragment();
                    return goalFragment;
                default:
                    if (profileFragment == null)
                        profileFragment = new ProfileFragment();
                    return profileFragment;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */

    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        isVisible = true;
        keyboardControl();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }



/*    public void ToastNotify(final String message, final String title, final String icon) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    getSupportFragmentManager().beginTransaction().detach(homeFragment).attach(homeFragment).commit();
                } catch (IllegalStateException e) {
                    LogHelper.errorLog(e);
                }
            }
        });
    }



    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i(TAG, "This device is not supported by Google Play Services.");
                //ToastNotify("This device is not supported by Google Play Services.");
                finish();
            }
            return false;
        }
        return true;
    }
*/

    private void keyboardControl() {
        mainContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                mainContent.getWindowVisibleDisplayFrame(r);
                int screenHeight = mainContent.getRootView().getHeight();
                int keypadHeight = screenHeight - r.bottom;
                if (keypadHeight > screenHeight * 0.15) {
                    tabLayout.setVisibility(View.GONE);

                } else if (keypadHeight < screenHeight * 0.15) {

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            tabLayout.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                }
            }
        });
    }
}

