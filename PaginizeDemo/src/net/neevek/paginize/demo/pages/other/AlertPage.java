package net.neevek.paginize.demo.pages.other;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import net.neevek.lib.android.paginize.Page;
import net.neevek.lib.android.paginize.PageActivity;
import net.neevek.lib.android.paginize.annotation.InjectView;
import net.neevek.lib.android.paginize.annotation.PageLayout;
import net.neevek.paginize.demo.R;


@PageLayout(R.layout.page_alert)
public class AlertPage extends Page implements View.OnClickListener {

    @InjectView(value = R.id.btn_confirm, listeners = {View.OnClickListener.class})
    private Button mBtnConfirm;

    public AlertPage(PageActivity pageActivity) {
        super(pageActivity);
        setType(Page.TYPE.TYPE_DIALOG);
        interceptAllTouchEvents();
    }

    private void interceptAllTouchEvents() {
        getView().setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                hide();
                break;
        }
    }

    @Override
    public boolean onBackPressed() {
        hide();
        return true;
    }
}