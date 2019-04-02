package study.quangtrung.self;

import android.content.Context;
import android.widget.Toast;

class Utility {
    private static Utility utility = new Utility();
    private Toast toast;
    private Context context;

    static Utility getInstance(Context ctx) {
        utility.context = ctx;
        return utility;
    }

    void showToast(String content, int duration) {
        if (null != toast) {
            toast.cancel();
        }
        toast = Toast.makeText(this.context, content, duration);
        toast.show();
    }
}
